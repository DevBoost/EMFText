/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.dbschema.discovery;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.dbschema.AttributeColumn;
import org.emftext.language.dbschema.Column;
import org.emftext.language.dbschema.ColumnType;
import org.emftext.language.dbschema.DBSchema;
import org.emftext.language.dbschema.DBSchemaUtil;
import org.emftext.language.dbschema.DbschemaFactory;
import org.emftext.language.dbschema.ForeignKeyColumn;
import org.emftext.language.dbschema.Table;

public class SchemaReader {

	private Connection connection;
	private DatabaseMetaData metaData;
	private Map<Integer, String> typeMap = new LinkedHashMap<Integer, String>();

	public SchemaReader() {
		super();
	}

	private void connect(String jdbcDriver, String jdbcConnectionUrl,
			String jdbcUser, String jdbcPassword, String schema) {
		try {
			Class.forName(jdbcDriver);
			this.connection = DriverManager.getConnection(jdbcConnectionUrl, jdbcUser, jdbcPassword);
			this.metaData = connection.getMetaData();
		
			Field[] fields = Types.class.getFields();
			Field field;
			for (int i = 0; i < fields.length; i++) {
				field = fields[i];
				typeMap.put((Integer) field.get(null), field.getName());
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Could not load JDBC driver.", e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public DBSchema discoverSchema(String jdbcDriver, String jdbcConnectionUrl,
			String schemaName, String jdbcUser, String jdbcPassword) throws SQLException, IOException {
		
		connect(jdbcDriver, jdbcConnectionUrl, jdbcUser, jdbcPassword, schemaName);
		DBSchema schema = DbschemaFactory.eINSTANCE.createDBSchema();
		schema.setName(schemaName);

		discoverTables(schema);
		connectReferencingTables(schema);
		
		return schema;
	}

	private void discoverTables(DBSchema newSchema) throws SQLException {
		ResultSet tables = getTables(newSchema.getName());
		while (tables.next()) {
			String tableName = tables.getString("TABLE_NAME");
			// String tableCatalog = tables.getString("TABLE_CAT");
			// String tableSchema = tables.getString("TABLE_SCHEM");
			
			Table newTable = discoverColumns(newSchema, tableName);
			newSchema.getTables().add(newTable);
		}
	}

	private Table discoverColumns(DBSchema schema, String tableName) throws SQLException {
		Table newTable = DbschemaFactory.eINSTANCE.createTable();
		newTable.setName(tableName);

		ResultSet columns = getColumns(schema.getName(), tableName);
		while (columns.next()) {
			// COLUMN_NAME String => column name 
			String columnName = columns.getString("COLUMN_NAME");
			
			// TABLE_CAT String => table catalog (may be null) 
			// TABLE_SCHEM String => table schema (may be null) 
			// TABLE_NAME String => table name 
			// DATA_TYPE int => SQL type from java.sql.Types
			int dataType = columns.getInt("DATA_TYPE");
			String dataTypeName = getJdbcType(dataType);
			// TYPE_NAME String => Data source dependent type name, for a UDT the type name is fully qualified 
			// COLUMN_SIZE int => column size. 
			int size = columns.getInt("COLUMN_SIZE");
			// BUFFER_LENGTH is not used. 
			// DECIMAL_DIGITS int => the number of fractional digits. Null is returned for data types where DECIMAL_DIGITS is not applicable. 
			// NUM_PREC_RADIX int => Radix (typically either 10 or 2) 
			// NULLABLE int => is NULL allowed. 
			//                 columnNoNulls - might not allow NULL values 
			//                 columnNullable - definitely allows NULL values 
			//                 columnNullableUnknown - nullability unknown 
			// REMARKS String => comment describing column (may be null) 
			// COLUMN_DEF String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null) 
			// SQL_DATA_TYPE int => unused 
			// SQL_DATETIME_SUB int => unused 
			// CHAR_OCTET_LENGTH int => for char types the maximum number of bytes in the column 
			// ORDINAL_POSITION int => index of column in table (starting at 1) 
			// IS_NULLABLE String => ISO rules are used to determine the nullability for a column. 
			//                       YES --- if the parameter can include NULLs 
			//                       NO --- if the parameter cannot include NULLs 
			//                       empty string --- if the nullability for the parameter is unknown 
			// SCOPE_CATLOG String => catalog of table that is the scope of a reference attribute (null if DATA_TYPE isn't REF) 
			// SCOPE_SCHEMA String => schema of table that is the scope of a reference attribute (null if the DATA_TYPE isn't REF) 
			// SCOPE_TABLE String => table name that this the scope of a reference attribure (null if the DATA_TYPE isn't REF) 
			// SOURCE_DATA_TYPE short => source type of a distinct type or user-generated Ref type, SQL type from java.sql.Types (null if DATA_TYPE isn't DISTINCT or user-generated REF) 
			// IS_AUTOINCREMENT String => Indicates whether this column is auto incremented 
			//                            YES --- if the column is auto incremented 
			//                            NO --- if the column is not auto incremented 
			//                            empty string --- if it cannot be determined whether the column is auto incremented parameter is unknown 
			Collection<String> primaryKeys = getPrimaryKeys(schema.getName(), tableName);
			boolean isPrimary = primaryKeys.contains(columnName);
			//System.out.println("  Column: " + columnName + " " + dataTypeName + "(" + size + ")" + (isPrimary ? " - PRIMARY KEY" : ""));
			
			AttributeColumn newColumn = DbschemaFactory.eINSTANCE.createAttributeColumn();
			newColumn.setName(columnName);
			newColumn.setPrimary(isPrimary);
			newColumn.setSize(size);
			ColumnType newType = findType(dataTypeName);
			newColumn.setType(newType);
			newTable.getColumns().add(newColumn);
		}
		return newTable;
	}

	private void connectReferencingTables(DBSchema schema) throws SQLException {
		for (Table table : schema.getTables()) {
			String tableName = table.getName();
			ResultSet importedKeys = getImportedKeys(schema.getName(), tableName);
			while (importedKeys.next()) {
				// PKTABLE_CAT String => primary key table catalog being imported (may be null) 
				// PKTABLE_SCHEM String => primary key table schema being imported (may be null) 
				// PKTABLE_NAME String => primary key table name being imported 
				// PKCOLUMN_NAME String => primary key column name being imported 
				// FKTABLE_CAT String => foreign key table catalog (may be null) 
				// FKTABLE_SCHEM String => foreign key table schema (may be null) 
				// FKTABLE_NAME String => foreign key table name 
				// FKCOLUMN_NAME String => foreign key column name 
				// KEY_SEQ short => sequence number within a foreign key( a value of 1 represents the first column of the foreign key, a value of 2 would represent the second column within the foreign key). 
				// UPDATE_RULE short => What happens to a foreign key when the primary key is updated: 
				//                      importedNoAction - do not allow update of primary key if it has been imported 
				//                      importedKeyCascade - change imported key to agree with primary key update 
				//                      importedKeySetNull - change imported key to NULL if its primary key has been updated 
				//                      importedKeySetDefault - change imported key to default values if its primary key has been updated 
				//                      importedKeyRestrict - same as importedKeyNoAction (for ODBC 2.x compatibility) 
				// DELETE_RULE short => What happens to the foreign key when primary is deleted. 
				//                      importedKeyNoAction - do not allow delete of primary key if it has been imported 
				//                      importedKeyCascade - delete rows that import a deleted key 
				//                      importedKeySetNull - change imported key to NULL if its primary key has been deleted 
				//                      importedKeyRestrict - same as importedKeyNoAction (for ODBC 2.x compatibility) 
				//                      importedKeySetDefault - change imported key to default if its primary key has been deleted 
				// FK_NAME String => foreign key name (may be null) 
				// PK_NAME String => primary key name (may be null) 
				// DEFERRABILITY short => can the evaluation of foreign key constraints be deferred until commit 
				//                        importedKeyInitiallyDeferred - see SQL92 for definition 
				//                        importedKeyInitiallyImmediate - see SQL92 for definition 
				//                        importedKeyNotDeferrable - see SQL92 for definition 
				//
				String referencedTableName = importedKeys.getString("PKTABLE_NAME");
				String referencedColumnName = importedKeys.getString("PKCOLUMN_NAME");
				String foreignTableName = importedKeys.getString("FKTABLE_NAME");
				String foreignColumnName = importedKeys.getString("FKCOLUMN_NAME");
				
				DBSchemaUtil util = new DBSchemaUtil();
				//System.out.println("  Foreign key: " + foreignTableName + "." + foreignColumnName + " REFERENCES " + referencedTableName + "." + referencedColumnName);
				Column referencedColumn = util.findColumn(schema, referencedTableName, referencedColumnName);
				Column foreignKeyColumn = util.findColumn(schema, foreignTableName, foreignColumnName);
				
				ForeignKeyColumn fkColumn = DbschemaFactory.eINSTANCE.createForeignKeyColumn();
				fkColumn.setName(foreignKeyColumn.getName());
				fkColumn.setType(foreignKeyColumn.getType());
				fkColumn.setSize(foreignKeyColumn.getSize());
				fkColumn.setReferencedColumn((AttributeColumn) referencedColumn);
				EcoreUtil.replace(foreignKeyColumn, fkColumn);
			}
		}
	}

	private static ColumnType findType(String dataTypeName) {
		for (ColumnType value : ColumnType.values()) {
			if (value.getName().equals(dataTypeName)) {
				return value;
			}
		}
		return null;
	}

	private ResultSet getTables(String schema) throws SQLException {
		return metaData.getTables(null, schema, null, new String[] { "TABLE" });
	}
	
	private ResultSet getColumns(String schema, String tableName) throws SQLException {
		return metaData.getColumns(null, schema, tableName, null);
	}
	
	private ResultSet getImportedKeys(String schema, String tableName) throws SQLException {
		return metaData.getImportedKeys(null, schema, tableName);
	}

	private Collection<String> getPrimaryKeys(String schema, String tableName) throws SQLException {
		Collection<String> result = new HashSet<String>();
		ResultSet resultSet = metaData.getPrimaryKeys(null, schema, tableName);
		while (resultSet.next()) {
			result.add(resultSet.getString("COLUMN_NAME"));
		}
		resultSet.close();
		return result;
	}

	
	public String getJdbcType(int jdbcType) {
		return typeMap.get(jdbcType);
	}
}
