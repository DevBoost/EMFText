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
package org.emftext.language.hedl.codegen;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.commons.jdt.JDTJavaClassifier;
import org.emftext.language.hedl.Constraint;
import org.emftext.language.hedl.Entity;
import org.emftext.language.hedl.EntityModel;
import org.emftext.language.hedl.Enum;
import org.emftext.language.hedl.EnumLiteral;
import org.emftext.language.hedl.JavaType;
import org.emftext.language.hedl.NamedElement;
import org.emftext.language.hedl.Option;
import org.emftext.language.hedl.OptionType;
import org.emftext.language.hedl.Property;
import org.emftext.language.hedl.Type;
import org.emftext.language.hedl.UniqueConstraint;
import org.emftext.language.hedl.types.HedlBuiltinTypes;

import de.devboost.commenttemplate.CommentTemplate;
import de.devboost.commenttemplate.LineBreak;
import de.devboost.commenttemplate.ReplacementRule;
import de.devboost.commenttemplate.VariableAntiQuotation;

@SuppressWarnings("unused")
@ReplacementRule(pattern="#/", replacement="*/")
@VariableAntiQuotation("#%s#")
@LineBreak("\r\n")
public class HEDLCodeGeneratorSource {

	private String DAO_PACKAGE_NAME = HEDLCodegenConstants.DAO_PACKAGE_NAME;
	private String CUSTOM_PACKAGE_NAME = HEDLCodegenConstants.CUSTOM_PACKAGE_NAME;
	private String ENTITY_PACKAGE_NAME = HEDLCodegenConstants.ENTITY_PACKAGE_NAME;

	@CommentTemplate
	public String generateICommand(String packageName) {
		/*package #packageName#.#DAO_PACKAGE_NAME#;
		
		import #packageName#.#CUSTOM_PACKAGE_NAME#.IDBOperations;

		// this class is generated. any change will be overridden.
		public interface ICommand {
			
			public void execute(IDBOperations operations);
		}
		*/
		return "";
	}

	@CommentTemplate
	public String generateOngoingShutdownException(String packageName) {
		/*package #packageName#.#DAO_PACKAGE_NAME#;

		// this class is generated. any change will be overridden.
		public class OngoingShutdownException extends RuntimeException {
			
			private static final long serialVersionUID = 997906627613716196L;
		}
		*/
		return "";
	}

	@CommentTemplate
	public String generateIDBOperations(String packageName) {
		/*package #packageName#.#CUSTOM_PACKAGE_NAME#;
		
		import #packageName#.#DAO_PACKAGE_NAME#.IDBOperationsBase;

		// this class is only generated once. it can be customized and all changes
		// will be preserved.
		public interface IDBOperations extends IDBOperationsBase {
			
		}
		*/
		return "";
	}
	
	@CommentTemplate
	public String generateIDBOperationsBase(String packageName, EntityModel entityModel) {
		String entityOperations = getAllEntitityOperations(entityModel);
		/*package #packageName#.#DAO_PACKAGE_NAME#;

		import java.util.List;
		
		*/
		for (Entity otherEntity : entityModel.getEntities()) {
			String name = otherEntity.getName();
		/*	import #packageName#.#ENTITY_PACKAGE_NAME#.#name#;
			*/
		}
		
		for (org.emftext.language.hedl.Enum otherEnum : entityModel.getEnums()) {
			String name = otherEnum.getName();
		/*	import #packageName#.#ENTITY_PACKAGE_NAME#.#name#;
			*/
		}

		/*
		// this class is generated. any change will be overridden.
		public interface IDBOperationsBase {
			
			#entityOperations#
		}
		*/
		return "";
	}

	@CommentTemplate
	private String getAllEntitityOperations(EntityModel entityModel) {
		for (Entity entity : entityModel.getEntities()) {
			String operations = getEntityOperations(entity);
			/*#operations#
			*/
		}
		return "";
	}

	@CommentTemplate
	private String getEntityOperations(Entity entity) {
		List<Property> uniqueProperties = getUniqueProperties(entity);
		List<Property> enumProperties = getEnumProperties(entity);
		List<Property> toOneProperties = getToOneProperties(entity);
		List<Property> dateProperties = getDateProperties(entity);
		List<Property> toOneReferences = getToOneReferences(entity);
		List<Property> constructorProperties = entity.getConstructorProperties();
		
		String entityName = entity.getName();

		/*/**
		 * Creates a new #entityName# using all read-only and all non-null properties.
		 #/
		public #entityName# create#entityName#(*/
		for (Property property : constructorProperties) {
			String propertyTypeClass = property.getType().getJavaClassname();
			String propertyName = property.getName();
			/*#propertyTypeClass# #propertyName#*/
			if (!isLast(constructorProperties, property)) {
				/*, */
			}
		}
		/*);
		
		/**
		 * Returns the #entityName# with the given id.
		 #/
		public #entityName# get#entityName#(int id);
			
		*/
		for (Property property : uniqueProperties) {
			String propertyName = property.getName();
			String toFirstUpper = toFirstUpper(propertyName);
			String typeClassname = property.getType().getJavaClassname();
		/*	/**
			 * Returns the #entityName# with the given #propertyName#.
			 #/
			public #entityName# get#entityName#By#toFirstUpper#(#typeClassname# #propertyName#);
			
			*/
		}
		for (Property property : toOneProperties) {
			String propertyName = property.getName();
			String firstUpper = toFirstUpper(property.getName());
			String typeClassname = property.getType().getJavaClassname();
		/*	/**
			 * Returns the #entityName#s with the given #propertyName#.
			 #/
			public List<#entityName#> get#entityName#sBy#firstUpper#(#typeClassname# #propertyName#);
			
			*/
		}
		for (Constraint constraint : entity.getConstraints()) {
			if (constraint instanceof UniqueConstraint) {
				UniqueConstraint uniqueConstraint = (UniqueConstraint) constraint;
		/*		/**
				 * Returns the #entityName# with the given properties.
				 #/
				public #entityName# get#entityName#By*/
				for (Property property : uniqueConstraint.getProperties()) {
					String firstUpper = toFirstUpper(property.getName());
					/*#firstUpper#*/
				}
				/*(*/
				for (Property property : uniqueConstraint.getProperties()) {
					String propertyName = property.getName();
					String typeClassname = property.getType().getJavaClassname();
					/*#typeClassname# #propertyName#*/
					if (!isLast(uniqueConstraint.getProperties(), property)) {
						/*, */
					}
				}
				/*);
				
				*/
			}
		}
		for (Property property : enumProperties) {
			String propertyName = property.getName();
			String firstUpper = toFirstUpper(property.getName());
			String typeClassname = property.getType().getJavaClassname();
		/*	/**
			 * Returns all #entityName#s with the given #propertyName#.
			 #/
			public List<#entityName#> get#entityName#sBy#firstUpper#(#typeClassname# #propertyName#);
			
			*/
		}
		for (Property property : dateProperties) {
			String propertyName = property.getName();
			String firstUpper = toFirstUpper(property.getName());
			String typeClassname = property.getType().getJavaClassname();
		/*	/**
			 * Returns all #entityName#s where #propertyName# is set to a value before '_maxDate'.
			 #/
			public List<#entityName#> get#entityName#sWith#firstUpper#Before(#typeClassname# _maxDate);
			
			*/
		}
		for (Property property : dateProperties) {
			String propertyName = property.getName();
			String firstUpper = toFirstUpper(property.getName());
			String typeClassname = property.getType().getJavaClassname();
/*			/**
			 * Returns all #entityName#s where #propertyName# is set to a value after '_minDate'.
			 #/
			public List<#entityName#> get#entityName#sWith#firstUpper#After(#typeClassname# _minDate);
			
			*/
		}
		/*/**
		 * Returns all entities of type #entityName#.
		 #/
		public List<#entityName#> getAll#entityName#s();
			
		/**
		 * Searches for entities of type #entityName#.
		 #/
		public List<#entityName#> search#entityName#s(String _searchString, int _maxResults);
		
		*/
		for (Property property : toOneReferences) {
			String toOneReferenceName = property.getName();
			String firstUpper = toFirstUpper(property.getName());
			String typeClassname = property.getType().getJavaClassname();
/*			/**
			 * Searches for entities of type #entityName#.
			 #/
			public List<#entityName#> search#entityName#With#firstUpper#(final #typeClassname# #toOneReferenceName#, String _searchString, int _maxResults);
			
			*/
		}
		/*/**
		 * Deletes a #entityName#.
		 #/
		public void delete(#entityName# entity);
		
		*/
		
		for (Property property : dateProperties) {
			String propertyName = property.getName();
			String firstUpper = toFirstUpper(property.getName());
			String typeClassname = property.getType().getJavaClassname();
/*			/**
			 * Deletes all #entityName#s where #propertyName# is set to a value before '_maxDate'.
			 #/
			public void delete#entityName#sWith#firstUpper#Before(#typeClassname# _maxDate);
			
			/**
			 * Deletes all #entityName#s where #propertyName# is set to a value after '_minDate'.
			 #/
			public void delete#entityName#sWith#firstUpper#After(#typeClassname# _minDate);
			
			*/
		}
		
		/*/**
		 * Counts the number of #entityName# entities.
		 #/
		public int count#entityName#s();
		
		*/
		return "";
	}

	private List<Property> getToOneReferences(Entity entity) {
		return filter(entity.getProperties(), new IFilter() {
			@Override
			public boolean accept(Property p) {
				return p.isToOneReference();
			}
		});
	}

	private List<Property> getDateProperties(Entity entity) {
		return filter(entity.getProperties(), new IFilter() {
			@Override
			public boolean accept(Property p) {
				Type type = p.getType();
				String typeName = null;
				if (type != null) {
					typeName = type.getJavaClassname();
				}
				return java.util.Date.class.getName().equals(typeName) && !p.isUnique();
			}
		});
	}

	private List<Property> getToOneProperties(Entity entity) {
		return filter(entity.getProperties(), new IFilter() {
			@Override
			public boolean accept(Property p) {
				return p.getType() instanceof Entity && !p.isToMultiplicity() && !p.isUnique();
			}
		});
	}

	private List<Property> getEnumProperties(Entity entity) {
		return filter(entity.getProperties(), new IFilter() {
			@Override
			public boolean accept(Property p) {
				return p.getType() instanceof org.emftext.language.hedl.Enum && !p.isUnique();
			}
		});
	}

	private List<Property> getUniqueProperties(Entity entity) {
		return filter(entity.getProperties(), new IFilter() {
			@Override
			public boolean accept(Property p) {
				return p.isUnique();
			}
		});
	}
	
	@CommentTemplate
	public String generateMainDAO(String packageName, String className) {
		/*package #packageName#.#CUSTOM_PACKAGE_NAME#;
		
		import #packageName#.#DAO_PACKAGE_NAME#.#className#Base;
		
		// this class is only generated once. it can be customized and all changes
		// will be preserved.
		public class #className# extends #className#Base {
		
			public #className#(Class<?> contextClass) {
				super(contextClass);
			}
			
			public void handleException(Exception e, boolean retry) {
				e.printStackTrace();
			}
		}
		*/;
		return "";
	}

	@CommentTemplate
	public String generateMainDAOBase(String packageName, String className, EntityModel entityModel) {
		String entityMethods = getEntityOperationsBodies(entityModel);
		/*package #packageName#.#DAO_PACKAGE_NAME#;

		import java.util.ArrayList;
		import java.util.List;
		import java.util.Properties;
		import java.io.IOException;
		
		import java.util.logging.Level;
		import java.util.logging.Logger;

		import org.hibernate.TransactionException;
		import org.hibernate.HibernateException;
		import org.hibernate.SessionFactory;
		import org.hibernate.Transaction;
		import org.hibernate.cfg.Configuration;
		import org.hibernate.classic.Session;
		import org.hibernate.stat.Statistics;

		import org.hibernate.tool.hbm2ddl.SchemaExport;
		import org.hibernate.tool.hbm2ddl.SchemaUpdate;

		import #packageName#.#CUSTOM_PACKAGE_NAME#.OperationProvider;
		import #packageName#.#CUSTOM_PACKAGE_NAME#.IDBOperations;
		
		*/
		for (Entity otherEntity : entityModel.getEntities()) {
			String otherEntityName = otherEntity.getName();
		/*	import #packageName#.#ENTITY_PACKAGE_NAME#.#otherEntityName#;
		*/
		}

		for (Enum otherEnum : entityModel.getEnums()) {
			String otherEnumName = otherEnum.getName();
		/*	import #packageName#.#ENTITY_PACKAGE_NAME#.#otherEnumName#;
		*/
		}

		/*
		// this class is generated. any change will be overridden.
		public abstract class #className# implements IDBOperationsBase {
			
			private static SessionFactory sessionFactory;
			
			private Class<?> contextClass;
		
			public #className#() {
				this(null);
			}
			
			/**
			 * Creates a new DAO that uses the given context class to load the
			 * Hibernate configuration 'hibernate.properties' using 
			 * Class.getResourceAsStream().
			 #/
			public #className#(Class<?> contextClass) {
				this.contextClass = contextClass;
			}
			
			private void configure() throws HibernateException {
				Configuration configuration = getConfiguration();
				//configuration.setProperty("hibernate.show_sql", "true");
				sessionFactory = configuration.buildSessionFactory();
			}

			private Configuration getConfiguration() {
				Configuration configuration = new Configuration();
*/
				for (Entity otherEntity : entityModel.getEntities()) {
					String otherEntityName = otherEntity.getName();
/*					configuration = configuration.addAnnotatedClass(#otherEntityName#.class);
*/
				}
/*				if (contextClass != null) {
					Properties properties = new Properties();
					try {
						properties.load(contextClass.getResourceAsStream("hibernate.properties"));
					} catch(IOException ioe) {
						throw new RuntimeException("Can't find hibernate.properties next to context class.");
					}
					configuration.setProperties(properties);
				}
				return configuration;
			}
			
			protected SessionFactory getSessionFactory() {
				synchronized (#className#.class) {
					if (sessionFactory == null) {
						configure();
					}
					return sessionFactory;
				}
			}
			
			public void createSchema() throws HibernateException {
				SchemaExport schemaExport = new SchemaExport(getConfiguration());
				schemaExport.setFormat(true);
				schemaExport.create(false, false);
			}
		
			public void updateSchema() {
				SchemaUpdate update = new SchemaUpdate(getConfiguration());
				update.execute(true, true);
				List<?> exceptions = update.getExceptions();
				for (Object object : exceptions) {
					System.err.println("Exception while updating schema " + object);
				}
			}
			
			public void executeInTransaction(ICommand command) {
				executeInTransaction(command, true);
			}
			
			private void executeInTransaction(ICommand command, boolean retry) {
				boolean successful = false;
				boolean closed = false;
				
				Session session = getSessionFactory().openSession();
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					command.execute(new OperationProvider(session));
					tx.commit();
					successful = true;
				} catch (Exception e) {
					handleException(e, retry);
					if (tx != null) {
						try {
							tx.rollback();
						} catch (TransactionException te) {
							handleException(te, retry);
						}
					}
				} finally {
					try {
						session.close();
						closed = true;
					} catch (HibernateException he) {
						handleException(he, retry);
					}
				}
				
				if ((!successful || !closed) && retry) {
					// retry once
					executeInTransaction(command, false);
				}
			}
			
			public abstract void handleException(Exception e, boolean retry);
			
			public Statistics getStatistics() {
				Statistics statistics = sessionFactory.getStatistics();
				return statistics;
			}
			
			public void tearDown() {
				synchronized (#className#.class) {
					if (sessionFactory != null) {
						sessionFactory.close();
						sessionFactory = null;
					}
				}
			}
		
			#entityMethods#
		}
		*/
		return "";
	}

	@CommentTemplate
	private String getEntityOperationsBodies(EntityModel entityModel) {
		for (Entity entity : entityModel.getEntities()) {
			String operationBodies = getEntityOperationsBodies(entity);
			/*#operationBodies#
			*/
		}
		return "";
	}

	@CommentTemplate
	private String getEntityOperationsBodies(Entity entity) {
		String entityName = entity.getName();
		String entityNameToFirstUpper = toFirstUpper(entityName);
		List<Property> uniqueProperties = getUniqueProperties(entity);
		List<Property> enumProperties = getEnumProperties(entity);
		List<Property> toOneProperties = getToOneProperties(entity);
		List<Property> dateProperties = getDateProperties(entity);
		List<Property> constructorProperties = entity.getConstructorProperties();
		List<Property> toOneReferences = getToOneReferences(entity);
		
		/*/**
		 * Creates a new #entityName# using all read-only and all non-null properties.
		 #/
		public #entityName# create#entityName#(*/
			for (Property property : constructorProperties) {
				String typeClassname = property.getType().getJavaClassname();
				String toFirstLower = toFirstLower(property.getName());
				/*final #typeClassname# #toFirstLower#*/
				if (!isLast(constructorProperties, property)) {
					/*, */
				}
			}
		/*) {
			final #entityName#[] entity = new #entityName#[1];
			executeInTransaction(new ICommand() {
				
				public void execute(IDBOperations operations) {
					entity[0] = operations.create#entityName#(*/
					for (Property property : constructorProperties) {
						String toFirstLower = toFirstLower(property.getName());
						/*#toFirstLower#*/
						if (!isLast(constructorProperties, property)) {
							/*, */
						}
					}
				/*);
				}
			});
			return entity[0];
		}
		
		/**
		 * Returns the #entityName# with the given id.
		 #/
		public #entityName# get#entityName#(final int id) {
			final #entityName#[] entity = new #entityName#[1];
			executeInTransaction(new ICommand() {
				
				public void execute(IDBOperations operations) {
					entity[0] = operations.get#entityName#(id);
				}
			});
			return entity[0];
		}
		
		*/
		for (Property property : uniqueProperties) {
			String propertyName = property.getName();
			String toFirstUpper = toFirstUpper(propertyName);
			String typeClassname = property.getType().getJavaClassname();
		/*	/**
			 * Returns the #entityName# with the given #propertyName#.
			 #/
			public #entityName# get#entityName#By#toFirstUpper#(final #typeClassname# #propertyName#) {
				final #entityName#[] entity = new #entityName#[1];
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entity[0] = operations.get#entityName#By#toFirstUpper#(#propertyName#);
					}
				});
				return entity[0];
			}
			
			*/
		}

		for (Property property : toOneProperties) {
			String propertyName = property.getName();
			String toFirstUpper = toFirstUpper(propertyName);
			String typeClassname = property.getType().getJavaClassname();
			/*/**
			 * Returns the #entityName#s with the given #propertyName#.
			 #/
			public List<#entityName#> get#entityName#sBy#toFirstUpper#(final #typeClassname# #propertyName#) {
				final List<#entityName#> entities = new ArrayList<#entityName#>();
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entities.addAll(operations.get#entityName#sBy#toFirstUpper#(#propertyName#));
					}
				});
				return entities;
			}
			
		*/
		}
		for (Property property : enumProperties) {
			String propertyName = property.getName();
			String toFirstUpper = toFirstUpper(propertyName);
			String typeClassname = property.getType().getJavaClassname();
			/*/**
			 * Returns all #entityName#s with the given #propertyName#.
			 #/
			public List<#entityName#> get#entityName#sBy#toFirstUpper#(final #typeClassname# #propertyName#) {
				final List<#entityName#> entities = new ArrayList<#entityName#>();
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entities.addAll(operations.get#entityName#sBy#toFirstUpper#(#propertyName#));
					}
				});
				return entities;
			}
			
			*/
		}
			
		for (Constraint constraint : entity.getConstraints()) {
			if (constraint instanceof UniqueConstraint) {
				UniqueConstraint uniqueConstraint = (UniqueConstraint) constraint;
				/*/**
				 * Returns the #entityName# with the given properties.
				 #/
				public #entityName# get#entityName#By*/
				for (Property property : uniqueConstraint.getProperties()) {
					String toFirstUpper = toFirstUpper(property.getName());
					/*#toFirstUpper#*/
				}
				/*(*/
				for (Property property : uniqueConstraint.getProperties()) {
					String propertyName = property.getName();
					String toFirstUpper = toFirstUpper(propertyName);
					String typeClassname = property.getType().getJavaClassname();
					/*final #typeClassname# #propertyName#*/
					if (!isLast(uniqueConstraint.getProperties(), property)) {
						/*, */
					}
				}
				/*) {
					final #entityName#[] entity = new #entityName#[1];
					executeInTransaction(new ICommand() {
						
						public void execute(IDBOperations operations) {
							entity[0] = operations.get#entityName#By*/
							for (Property property : uniqueConstraint.getProperties()) {
								String toFirstUpper = toFirstUpper(property.getName());
								/*#toFirstUpper#*/
							}
							/*(*/
							for (Property property : uniqueConstraint.getProperties()) {
								String propertyName = property.getName();
								/*#propertyName#*/
								if (!isLast(uniqueConstraint.getProperties(), property)) {
									/*, */
								}
							}
						/*);
						}
					});
					return entity[0];
				}
		
				*/
			}
		}
		
		for (Property property : dateProperties) {
			String propertyName = property.getName();
			String toFirstUpper = toFirstUpper(propertyName);
			String typeClassname = property.getType().getJavaClassname();
			/*/**
			 * Returns all #entityName#s where #propertyName# is set to a value before '_maxDate'.
			 #/
			public List<#entityName#> get#entityName#sWith#toFirstUpper#Before(final #typeClassname# _maxDate) {
				final List<#entityName#> entities = new ArrayList<#entityName#>();
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entities.addAll(operations.get#entityName#sWith#toFirstUpper#Before(_maxDate));
					}
				});
				return entities;
			}
			
			*/
		}
		for (Property property : dateProperties) {
			String propertyName = property.getName();
			String toFirstUpper = toFirstUpper(propertyName);
			String typeClassname = property.getType().getJavaClassname();
/*			/**
			 * Returns all #entityName#s where #propertyName# is set to a value after '_minDate'.
			 #/
			public List<#entityName#> get#entityName#sWith#toFirstUpper#After(final #typeClassname# _minDate) {
				final List<#entityName#> entities = new ArrayList<#entityName#>();
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entities.addAll(operations.get#entityName#sWith#toFirstUpper#After(_minDate));
					}
				});
				return entities;
			}
			
			*/
		}
		/*/**
		 * Returns all entities of type #entityName#.
		 #/
		public List<#entityName#> getAll#entityName#s() {
			final List<#entityName#> entities = new ArrayList<#entityName#>();
			executeInTransaction(new ICommand() {
				
				public void execute(IDBOperations operations) {
					entities.addAll(operations.getAll#entityName#s());
				}
			});
			return entities;
		}
		
		/**
		 * Searches for entities of type #entityName#.
		 #/
		public List<#entityName#> search#entityName#s(final String _searchString, final int _maxResults) {
			final List<#entityName#> entities = new ArrayList<#entityName#>();
			executeInTransaction(new ICommand() {
				
				public void execute(IDBOperations operations) {
					entities.addAll(operations.search#entityName#s(_searchString, _maxResults));
				}
			});
			return entities;
		}
		
		*/
		for (Property toOneReference : toOneReferences) {
			String toOneReferenceName = toOneReference.getName();
			String toFirstUpper = toFirstUpper(toOneReferenceName);
			String typeClassname = toOneReference.getType().getJavaClassname();
			/*/**
			 * Searches for entities of type #entityName#.
			 #/
			public List<#entityName#> search#entityName#With#toFirstUpper#(final #typeClassname# #toOneReferenceName#, final String _searchString, final int _maxResults) {
				final List<#entityName#> entities = new ArrayList<#entityName#>();
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						entities.addAll(operations.search#entityName#With#toFirstUpper#(#toOneReferenceName#, _searchString, _maxResults));
					}
				});
				return entities;
			}
			
			*/
		}
		/*/**
		 * Deletes a #entityName#.
		 #/
		public void delete(final #entityName# entity) {
			executeInTransaction(new ICommand() {
				
				public void execute(IDBOperations operations) {
					operations.delete(entity);
				}
			});
		}
		
		*/
		for (Property property : dateProperties) {
			String propertyName = property.getName();
			String firstUpper = toFirstUpper(property.getName());
			String typeClassname = property.getType().getJavaClassname();
			String fieldName = getFieldName(property);
/*			/**
			 * Deletes all #entityName#s where #propertyName# is set to a value before '_maxDate'.
			 #/
			public void delete#entityName#sWith#firstUpper#Before(final #typeClassname# _maxDate) {
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						operations.delete#entityName#sWith#firstUpper#Before(_maxDate);
					}
				});
			}
			
			/**
			 * Deletes all #entityName#s where #propertyName# is set to a value after '_minDate'.
			 #/
			public void delete#entityName#sWith#firstUpper#After(final #typeClassname# _minDate) {
				executeInTransaction(new ICommand() {
					
					public void execute(IDBOperations operations) {
						operations.delete#entityName#sWith#firstUpper#Before(_minDate);
					}
				});
			}
			
			*/
		}

/*		/**
		 * Counts the number of #entityName# entities.
		 #/
		public int count#entityNameToFirstUpper#s() {
			final int[] count = new int[1];
			executeInTransaction(new ICommand() {
				
				public void execute(IDBOperations operations) {
					count[0] = operations.count#entityNameToFirstUpper#s();
				}
			});
			return count[0];
		}
		
		*/
		return "";
	}

	@CommentTemplate
	public String generateOperationProvider(String packageName) {
		/*package #packageName#.#CUSTOM_PACKAGE_NAME#;

		import org.hibernate.classic.Session;
		import #packageName#.#DAO_PACKAGE_NAME#.OperationProviderBase;

		// this class is only generated once. it can be customized and all changes
		// will be preserved.
		public class OperationProvider extends OperationProviderBase implements IDBOperations {

			public OperationProvider(Session session) {
				super(session);
			}

		}
		*/
		return "";
	}
				
	@CommentTemplate
	public String generateOperationProviderBase(String packageName, EntityModel entityModel) {
		/*package #packageName#.#DAO_PACKAGE_NAME#;

		import java.util.List;

		import org.hibernate.Criteria;
		import org.hibernate.HibernateException;
		import org.hibernate.SessionFactory;
		import org.hibernate.Transaction;
		import org.hibernate.Query;
		import org.hibernate.cfg.Configuration;
		import org.hibernate.classic.Session;
		import org.hibernate.criterion.MatchMode;
		import org.hibernate.criterion.Order;
		import org.hibernate.criterion.Restrictions;
		import org.hibernate.metadata.ClassMetadata;
		import org.hibernate.persister.entity.AbstractEntityPersister;
		
		*/
		for (Entity otherEntity : entityModel.getEntities()) {
			String otherEntityName = otherEntity.getName();
/*			import #packageName#.#ENTITY_PACKAGE_NAME#.#otherEntityName#;
*/
		}
		for (Enum otherEnum : entityModel.getEnums()) {
			String otherEnumName = otherEnum.getName();
/*			import #packageName#.#ENTITY_PACKAGE_NAME#.#otherEnumName#;
*/
		}
		
/*		
		/**
		 * This class provides all default operations that are derived from the HEDL entity model.
		 *
		 * Note: This class is generated. Any change will be overridden.
		 #/
		public abstract class OperationProviderBase implements IDBOperationsBase {
				
			private Session session;
			
*/			for (Entity entity : entityModel.getEntities()) {
				String entityName = entity.getName();
				String toFirstLower = toFirstLower(entityName);
/*				private #entityName#DAO #toFirstLower#DAO = new #entityName#DAO();
*/			}
/*		
			public OperationProviderBase(Session session) {
				this.session = session;
			}
			
			public Session getSession() {
				return session;
			}
			
*/
			for (Entity entity : entityModel.getEntities()) {
				String entityName = entity.getName();
				String entityNameToFirstLower = toFirstLower(entityName);
				String entityNameToFirstUpper = toFirstUpper(entityName);
				List<Property> uniqueProperties = getUniqueProperties(entity);
				List<Property> enumProperties = getEnumProperties(entity);
				List<Property> toOneProperties = getToOneProperties(entity);
				List<Property> dateProperties = getDateProperties(entity);
				List<Property> constructorProperties = entity.getConstructorProperties();
				List<Property> toOneReferences = getToOneReferences(entity);
/*				/** 
				 * Creates an instance of type #entityName# using all read-only and all non-null properties.
				 #/
				public #entityName# create#entityName#(*/
					for (Property property : constructorProperties) {
						String propertyType = property.getType().getJavaClassname();
						String propertyToFirstLower = toFirstLower(property.getName());
						/*#propertyType# #propertyToFirstLower#*/
						if (!isLast(constructorProperties, property)) {
							/*, */
						}
					}
/*				) {
					return #entityNameToFirstLower#DAO.create(session*/
					for (Property property : constructorProperties) {
						String propertyToFirstLower = toFirstLower(property.getName());
						/*, #propertyToFirstLower#*/
					}
/*					);
				}
				
				/**
				 * Returns the #entityName# with the given id.
				 #/
				public #entityName# get#entityName#(int id) {
					#entityName# entity = #entityNameToFirstLower#DAO.get(session, id);
					return entity;
				}
				
*/
				for (Property property : uniqueProperties) {
					String propertyName = property.getName();
					String propertyNameToFirstUpper = toFirstUpper(propertyName);
					String propertyTypeClassname = property.getType().getJavaClassname();
/*					/** Returns the #entityName# with the given #propertyName#. #/
					public #entityName# get#entityName#By#propertyNameToFirstUpper#(#propertyTypeClassname# #propertyName#) {
						#entityName# entity = #entityNameToFirstLower#DAO.getBy#propertyNameToFirstUpper#(session, #propertyName#);
						return entity;
					}
						
*/
				}
				
				for (Property property : toOneProperties) {
					String propertyName = property.getName();
					String propertyNameToFirstUpper = toFirstUpper(propertyName);
					String propertyTypeClassname = property.getType().getJavaClassname();
/*					/** Returns the #entityName#s with the given #propertyName#. #/
					public List<#entityName#> get#entityName#sBy#propertyNameToFirstUpper#(#propertyTypeClassname# #propertyName#) {
						List<#entityName#> entities = #entityNameToFirstLower#DAO.getBy#propertyNameToFirstUpper#(session, #propertyName#);
						return entities;
					}
						
*/
				}
			
				for (Property property : enumProperties) {
					String propertyName = property.getName();
					String propertyNameToFirstUpper = toFirstUpper(propertyName);
					String propertyTypeClassname = property.getType().getJavaClassname();
/*					/**
					 * Returns all #entityName#s with the given #propertyName#.
					 #/
					public List<#entityName#> get#entityName#sBy#propertyNameToFirstUpper#(#propertyTypeClassname# #propertyName#) {
						return #entityNameToFirstLower#DAO.getBy#propertyNameToFirstUpper#(session, #propertyName#);
					}
					
*/
				}
				
				for (Constraint constraint : entity.getConstraints()) {
					if (constraint instanceof UniqueConstraint) {
						UniqueConstraint uniqueConstraint = (UniqueConstraint) constraint;
/*						/**
						 * Returns the #entityName# with the given properties.
						 #/
						public #entityName# get#entityName#By*/
						for (Property property : uniqueConstraint.getProperties()) {
							String propertyNameToFirstUpper = toFirstUpper(property.getName());
							/*#propertyNameToFirstUpper#*/
						}
/*						(*/
						for (Property property : uniqueConstraint.getProperties()) {
							String propertyName = property.getName();
							String propertyTypeClassname = property.getTypeClassname();
							/*#propertyTypeClassname# #propertyName#*/
							if (!isLast(uniqueConstraint.getProperties(), property)) {
								/*, */
							}
						}
/*						) {
							#entityName# entity = #entityNameToFirstLower#DAO.getBy*/
							for (Property property : uniqueConstraint.getProperties()) {
								String propertyNameToFirstUpper = toFirstUpper(property.getName());
								/*#propertyNameToFirstUpper#*/
							}
/*							(session, */
							for (Property property : uniqueConstraint.getProperties()) {
								String propertyName = property.getName();
								/*#propertyName#*/
								if (!isLast(uniqueConstraint.getProperties(), property)) {
									/*, */
								}
							}
							/*);
							return entity;
						}
						
*/
					}
				}
			
				for (Property property : dateProperties) {
					String propertyName = property.getName();
					String propertyNameToFirstUpper = toFirstUpper(propertyName);
					String propertyTypeClassname = property.getType().getJavaClassname();
/*					/**
					 * Returns all #entityName#s where #propertyName# is set to a value before '_maxDate'.
					 #/
					public List<#entityName#> get#entityName#sWith#propertyNameToFirstUpper#Before(#propertyTypeClassname# _maxDate) {
						final List<#entityName#> entities = #entityNameToFirstLower#DAO.get#propertyNameToFirstUpper#Before(session, _maxDate);
						return entities;
					}
					
*/
				}
				
				for (Property property : dateProperties) {
					String propertyName = property.getName();
					String propertyNameToFirstUpper = toFirstUpper(propertyName);
					String propertyTypeClassname = property.getType().getJavaClassname();
/*					/**
					 * Returns all #entityName#s where #propertyName# is set to a value after '_minDate'.
					 #/
					public List<#entityName#> get#entityName#sWith#propertyNameToFirstUpper#After(#propertyTypeClassname# _minDate) {
						final List<#entityName#> entities = #entityNameToFirstLower#DAO.get#propertyNameToFirstUpper#After(session, _minDate);
						return entities;
					}
					
*/
				}
/*				/**
				 * Returns all entities of type #entityName#.
				 #/
				public List<#entityName#> getAll#entityName#s() {
					final List<#entityName#> entities = #entityNameToFirstLower#DAO.getAll(session);
					return entities;
				}
				
				/**
				 * Searches for entities of type #entityName#.
				 #/
				public List<#entityName#> search#entityName#s(String _searchString, int _maxResults) {
					return #entityNameToFirstLower#DAO.search(session, _searchString, _maxResults);
				}
				
*/
				for (Property property : toOneReferences) {
					String propertyName = property.getName();
					String propertyNameToFirstUpper = toFirstUpper(propertyName);
					String propertyTypeClassname = property.getTypeClassname();
/*					/**
					 * Searches for entities of type #entityName#.
					 #/
					public List<#entityName#> search#entityName#With#propertyNameToFirstUpper#(#propertyTypeClassname# #propertyName#, String _searchString, int _maxResults) {
						return #entityNameToFirstLower#DAO.searchWith#propertyNameToFirstUpper#(session, #propertyName#, _searchString, _maxResults);
					}
					
*/
				}
/*				/**
				 * Deletes a #entityName#.
				 #/
				public void delete(#entityName# entity) {
					#entityNameToFirstLower#DAO.delete(session, entity);
				}
				
				*/
				
				for (Property property : dateProperties) {
					String propertyName = property.getName();
					String firstUpper = toFirstUpper(property.getName());
					String typeClassname = property.getType().getJavaClassname();
					String fieldName = getFieldName(property);
/*					/**
					 * Deletes all #entityName#s where #propertyName# is set to a value before '_maxDate'.
					 #/
					public void delete#entityName#sWith#firstUpper#Before(#typeClassname# _maxDate) {
						Query query = getSession().createQuery(
							"DELETE FROM " + #entityName#.class.getName() + " " +
							"WHERE " + #entityName#DAO.#fieldName# + " < ?"
						);
						query.setParameter(0, _maxDate);
						query.executeUpdate();
					}
					
					/**
					 * Deletes all #entityName#s where #propertyName# is set to a value after '_minDate'.
					 #/
					public void delete#entityName#sWith#firstUpper#After(#typeClassname# _minDate) {
						Query query = getSession().createQuery(
							"DELETE FROM " + #entityName#.class.getName() + " " +
							"WHERE " + #entityName#DAO.#fieldName# + " > ?"
						);
						query.setParameter(0, _minDate);
						query.executeUpdate();
					}
					
					*/
				}
				
/*				/**
				 * Counts the number of #entityName# entities.
				 #/
				public int count#entityNameToFirstUpper#s() {
					return #entityNameToFirstLower#DAO.count(session);
				}
				
*/
			}
/*			/**
			 * Returns the name of the table that contains entities of the given type.
			 #/
			public String getTableName(Class<?> clazz) {
				ClassMetadata hibernateMetadata = getSession().getSessionFactory().getClassMetadata(clazz);
				if (hibernateMetadata == null) {
				    return null;
				}
				if (hibernateMetadata instanceof AbstractEntityPersister) {
				     AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;
				     return persister.getTableName();
				}
				return null;
			}
		}
*/
		return "";
	}

	@CommentTemplate
	public String generateEntityDAO(String packageName, Entity entity) {
		String entityName = entity.getName();
		
		List<Property> uniqueProperties = getUniqueProperties(entity);
		List<Property> enumProperties = getEnumProperties(entity);
		List<Property> toOneProperties = getToOneProperties(entity);
		List<Property> dateProperties = getDateProperties(entity);
		List<Property> constructorProperties = entity.getConstructorProperties();
		List<Property> toOneReferences = getToOneReferences(entity);

		/*package #packageName#.#DAO_PACKAGE_NAME#;
		
		import java.util.List;
		
		import org.hibernate.classic.Session;
		import org.hibernate.Criteria;
		import org.hibernate.HibernateException;
		import org.hibernate.criterion.Disjunction;
		import org.hibernate.criterion.MatchMode;
		import org.hibernate.criterion.Order;
		import org.hibernate.criterion.Restrictions;

*/		for (Entity otherEntity : entity.getEntityModel().getEntities()) {
			String otherEntityName = otherEntity.getName();
/*			import #packageName#.#ENTITY_PACKAGE_NAME#.#otherEntityName#;
*/
		}
		
		for (Enum otherEnum : entity.getEntityModel().getEnums()) {
			String otherEnumName = otherEnum.getName();
/*			import #packageName#.#ENTITY_PACKAGE_NAME#.#otherEnumName#;
*/
		}
/*		
		import java.util.List;

		/**
		 * This class provides all default operations that are derived from the HEDL entity model
		 * for type #entityName#.
		 *
		 * Note: This class is generated. Any change will be overridden.
		 #/
		public class #entityName#DAO {
			
*/			if (entity.getSuperType() == null) {
/*				public final static String FIELD__ID = getField(#entityName#.class, "id");
*/			}
			for (Property property : entity.getProperties()) {
				String propertyName = property.getName();
				String fieldName = getFieldName(property);
/*				public final static String #fieldName# = getField(#entityName#.class, "#propertyName#");
*/			}
			
/*			
			/**
 			 * Creates a #entityName# using all read-only and all non-null properties.
			 #/
			public #entityName# create(Session session*/
				for (Property property : constructorProperties) {
					String propertyTypeClassname = property.getType().getJavaClassname();
					String propertyToFirstLower = toFirstLower(property.getName());
					/*, #propertyTypeClassname# #propertyToFirstLower#*/
				}
				/*) {
				#entityName# newEntity = new #entityName#(*/
				for (Property property : constructorProperties) {
					String propertyToFirstLower = toFirstLower(property.getName());
					/*#propertyToFirstLower#*/
					if (!isLast(constructorProperties, property)) {
						/*, */
					}
				}
/*				);
				session.save(newEntity);
				return newEntity;
			}
			
			/**
			 * Returns the #entityName# with the given id.
			 #/
			public #entityName# get(Session session, int id) {
				#entityName# entity = (#entityName#) session.get(#entityName#.class, id);
				return entity;
			}
			
*/			for (Property property : uniqueProperties) {
				String propertyName = property.getName();
				String propertyNameToUpperCase = propertyName.toUpperCase();
				String propertyNameToFirstUpper = toFirstUpper(propertyName);
				String propertyTypeClassname = property.getType().getJavaClassname();
/*				/**
				 * Returns the #entityName# with the given #propertyName#.
				 #/
				public #entityName# getBy#propertyNameToFirstUpper#(Session session, #propertyTypeClassname# #propertyName#) {
					Criteria criteria = session.createCriteria(#entityName#.class);
					criteria = criteria.add(Restrictions.eq(FIELD__#propertyNameToUpperCase#, #propertyName#));
					List<?> list = criteria.list();
					if (list != null && !list.isEmpty()) {
						return (#entityName#) list.get(0);
					}
					return null;
				}
				
*/			}
			for (Property property : toOneProperties) {
				String propertyName = property.getName();
				String propertyNameToUpperCase = propertyName.toUpperCase();
				String propertyNameToFirstUpper = toFirstUpper(propertyName);
				String propertyTypeClassname = property.getType().getJavaClassname();
/*				/**
				 * Returns the #entityName#s with the given #propertyName#.
				 #/
				public List<#entityName#> getBy#propertyNameToFirstUpper#(Session session, #propertyTypeClassname# #propertyName#) {
					Criteria criteria = session.createCriteria(#entityName#.class);
					criteria = criteria.add(Restrictions.eq(FIELD__#propertyNameToUpperCase#, #propertyName#));
					@SuppressWarnings("unchecked")
					List<#entityName#> list = (List<#entityName#>) criteria.list();
					return list;
				}
				
*/			}
			for (Constraint constraint : entity.getConstraints()) {
				if (constraint instanceof UniqueConstraint) {
					UniqueConstraint uniqueConstraint = (UniqueConstraint) constraint;
/*					/**
					 * Returns the #entityName# with the given properties.
					 #/
					public #entityName# getBy*/
					for (Property property : uniqueConstraint.getProperties()) {
						String propertyNameToFirstUpper = toFirstUpper(property.getName());
						/*#propertyNameToFirstUpper#*/
					}
					/*(Session session, */
					for (Property property : uniqueConstraint.getProperties()) {
						String propertyName = property.getName();
						String propertyTypeJavaClassname = property.getType().getJavaClassname();
						/*#propertyTypeJavaClassname# #propertyName#*/
						if (!isLast(uniqueConstraint.getProperties(), property)) {
							/*, */
						}
					}
/*					) {
						Criteria criteria = session.createCriteria(#entityName#.class);
*/						for (Property property : uniqueConstraint.getProperties()) {
							String propertyName = property.getName();
							String upperCasePropertyName = propertyName.toUpperCase();
/*							criteria = criteria.add(Restrictions.eq(FIELD__#upperCasePropertyName#, #propertyName#));
*/						}
/*						List<?> list = criteria.list();
						if (list != null && !list.isEmpty()) {
							return (#entityName#) list.get(0);
						}
						return null;
					}
					
*/				}
			}
			
			for (Property property : enumProperties) {
				String propertyName = property.getName();
				String typeJavaClassname = property.getType().getJavaClassname();
				String upperCasePropertyName = propertyName.toUpperCase();
				String propertyNameToFirstUpper = toFirstUpper(propertyName);
/*				/**
				 * Returns all #entityName#s with the given #propertyName#.
				 #/
				public List<#entityName#> getBy#propertyNameToFirstUpper#(Session session, #typeJavaClassname# #propertyName#) {
					Criteria criteria = session.createCriteria(#entityName#.class);
					criteria = criteria.add(Restrictions.eq(FIELD__#upperCasePropertyName#, #propertyName#));
					List<?> list = criteria.list();
					@SuppressWarnings("unchecked")
					List<#entityName#> entities = (List<#entityName#>) list;
					return entities;
				}
				
*/			}
			for (Property property : dateProperties) {
				String typeJavaClassname = property.getType().getJavaClassname();
				String propertyName = property.getName();
				String upperCasePropertyName = propertyName.toUpperCase();
				String propertyNameToFirstUpper = toFirstUpper(propertyName);
/*				/**
				 * Returns all #entityName#s where #propertyName# is set to a value before '_maxDate'.
				 #/
				public List<#entityName#> get#propertyNameToFirstUpper#Before(Session session, #typeJavaClassname# _maxDate) {
					Criteria criteria = session.createCriteria(#entityName#.class);
					criteria = criteria.add(Restrictions.le(FIELD__#upperCasePropertyName#, _maxDate));
					List<?> list = criteria.list();
					@SuppressWarnings("unchecked")
					List<#entityName#> entities = (List<#entityName#>) list;
					return entities;
				}
				
*/			}
			for (Property property : dateProperties) {
				String typeJavaClassname = property.getType().getJavaClassname();
				String propertyName = property.getName();
				String upperCasePropertyName = propertyName.toUpperCase();
				String propertyNameToFirstUpper = toFirstUpper(propertyName);
/*				/**
				 * Returns all #entityName#s where #propertyName# is set to a value after '_minDate'.
				 #/
				public List<#entityName#> get#propertyNameToFirstUpper#After(Session session, #typeJavaClassname# _minDate) {
					Criteria criteria = session.createCriteria(#entityName#.class);
					criteria = criteria.add(Restrictions.ge(FIELD__#upperCasePropertyName#, _minDate));
					List<?> list = criteria.list();
					@SuppressWarnings("unchecked")
					List<#entityName#> entities = (List<#entityName#>) list;
					return entities;
				}
				
*/			}
/*			/**
			 * Returns all entities of type #entityName#.
			 #/
			public List<#entityName#> getAll(Session session) {
				Criteria criteria = session.createCriteria(#entityName#.class);
				@SuppressWarnings("unchecked")
				List<#entityName#> entities = (List<#entityName#>) criteria.list();
				return entities;
			}
			
			/**
			 * Searches for entities of type #entityName#.
			 #/
			public List<#entityName#> search(Session _session, String _searchString, int _maxResults) {
				Criteria criteria = _session.createCriteria(#entityName#.class);
				Disjunction disjunction = Restrictions.disjunction();
*/				for (Property property : entity.getProperties()) {
					if (property.getType().getJavaClassname().equals(String.class.getName())) {
						String propertyNameToUpperCase = property.getName().toUpperCase();
/*						disjunction.add(Restrictions.like(FIELD__#propertyNameToUpperCase#, _searchString.trim(), MatchMode.ANYWHERE));
*/					}
				}
/*				criteria = criteria.add(disjunction);
				criteria = criteria.setMaxResults(_maxResults);
				@SuppressWarnings("unchecked")
				List<#entityName#> entities = (List<#entityName#>) criteria.list();
				return entities;
			}
			
*/			for (Property toOneReference : toOneReferences) {
				String toOneReferenceName = toOneReference.getName();
				String toOneReferenceNameToFirstUpper = toFirstUpper(toOneReferenceName);
				String toOneReferenceNameToUpperCase = toOneReferenceName.toUpperCase();
				String toOneReferenceTypeClassname = toOneReference.getType().getJavaClassname();
/*				/**
				 * Searches for entities of type #entityName#.
				 #/
				public List<#entityName#> searchWith#toOneReferenceNameToFirstUpper#(Session _session, #toOneReferenceTypeClassname# #toOneReferenceName#, String _searchString, int _maxResults) {
					Criteria criteria = _session.createCriteria(#entityName#.class);
					// restrict by the value of the unique property
					criteria = criteria.add(Restrictions.eq(FIELD__#toOneReferenceNameToUpperCase#, #toOneReferenceName#));
					Disjunction disjunction = Restrictions.disjunction();
*/					for (Property property : entity.getProperties()) {
						String propertyNameToUpperCase = property.getName().toUpperCase();
						if (property.getType().getJavaClassname().equals(String.class.getName())) {
/*							disjunction.add(Restrictions.like(FIELD__#propertyNameToUpperCase#, _searchString.trim(), MatchMode.ANYWHERE));
*/						}
					}
/*					criteria = criteria.add(disjunction);
					criteria = criteria.setMaxResults(_maxResults);
					@SuppressWarnings("unchecked")
					List<#entityName#> entities = (List<#entityName#>) criteria.list();
					return entities;
				}
				
*/			}
/*			/**
			 * Deletes a #entityName#.
			 #/
			public void delete(Session session, #entityName# entity) {
				session.delete(entity);
			}
			
			/**
			 * Counts the number of #entityName# entities.
			 #/
			public int count(Session session) {
				return ((Long) session.createQuery("select count(*) from #entityName#").uniqueResult()).intValue();
			}
				
			private static String getField(Class<?> clazz, String fieldName) {
				try {
					return clazz.getDeclaredField(fieldName).getName();
				} catch (SecurityException e) {
					throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
				} catch (NoSuchFieldException e) {
					throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
				}
			}
		}
*/
		return "";
	}

	private String getFieldName(Property property) {
		return "FIELD__" + property.getName().toUpperCase();
	}

	@CommentTemplate
	public String generateEntityBaseClass(String packageName, Entity entity) {
		String entityName = entity.getName();
		String tableName = getTableName(entity);
		List<Property> constructorProperties = entity.getConstructorProperties();
		String propertyDeclarations = getPropertyDeclarations(entity);

		/*package #packageName#.#ENTITY_PACKAGE_NAME#;
		
		import java.util.List;
		
		import javax.persistence.Entity;
		import javax.persistence.GeneratedValue;
		import javax.persistence.GenerationType;
		import javax.persistence.Id;
		import javax.persistence.JoinColumn;
		import javax.persistence.ManyToOne;
		import javax.persistence.OneToOne;
		import javax.persistence.Table;
		import javax.persistence.Temporal;
		import javax.persistence.TemporalType;
		import javax.persistence.UniqueConstraint;
		import javax.persistence.EnumType;
		import javax.persistence.FetchType;
		import javax.persistence.Enumerated;
		import javax.persistence.CascadeType;
		import javax.persistence.OneToMany;
		import javax.persistence.ManyToMany;
		import javax.persistence.Column;

		import org.hibernate.annotations.GenericGenerator;
		import org.hibernate.annotations.Parameter;
		
		@Entity
		@Table(name = "#tableName#"
		*/
		for (Constraint constraint : entity.getConstraints()) {
			if (constraint instanceof UniqueConstraint) {
				UniqueConstraint uniqueConstraint = (UniqueConstraint) constraint;
				/*, uniqueConstraints=@UniqueConstraint(columnNames={*/
				for (Property property : uniqueConstraint.getProperties()) {
					String columnName = getColumnName(property);
					/*"#columnName#"*/
					if (!isLast(uniqueConstraint.getProperties(), property)) {
						/*, */
					}
				}
				/*})
*/
			}
		}/*)
*/		if (entity.getComment() != null) {
			String comment = entity.getComment().replace("\t", "");
			/*#comment#
			*/
		}
/*		/*
		 * This class is generated from the entity '#entityName#' defined in the HEDL model.
		 * Note: Any change made to this class will be overridden.
		 #/
		public class #entityName# */
		if (entity.getSuperType() != null) {
			String superTypeName = entity.getSuperType().getName();
			/*extends #superTypeName# */
		}
		for (JDTJavaClassifier javaInterface : entity.getImplementedInterfaces()) {
			if (isFirst(entity.getImplementedInterfaces(), javaInterface)) {
				/*implements */
			}
			String interfaceName = javaInterface.getQualifiedName();
			/*#interfaceName# */
			if (!isLast(entity.getImplementedInterfaces(), javaInterface)) {
				/*, */
			}
		}
		/*{
			
*/			if (entity.getSuperType() == null) {
/*				@GenericGenerator(name="#entityName#IdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
				  parameters = {
				    @Parameter(name="table", value="IdentityGenerator"),
				    @Parameter(name="primary_key_column", value="sequence_name"),
				    @Parameter(name="primary_key_value", value="#entityName#"),
				    @Parameter(name="value_column", value="next_hi_value"),
				    @Parameter(name="primary_key_length", value="100"),
				    @Parameter(name="max_lo", value="1000")
				  }
				)
				@Id 
				@GeneratedValue(strategy=GenerationType.TABLE, generator="#entityName#IdGenerator")
				private int id;
			
*/			}
/*			#propertyDeclarations#
			/**
			 * Default constructor. Only used by Hibernate.
			 #/
			public #entityName#() {
				super();
			}
		
*/			if (!constructorProperties.isEmpty()) {
/*				/**
				 * Constructor using all read-only and all non-nullable properties.
				 #/
				public #entityName#(*/
					for (Property property : constructorProperties) {
						String typeClassName = property.getType().getJavaClassname();
						String toFirstLower = toFirstLower(property.getName());
						/*#typeClassName# #toFirstLower#*/
						if (!isLast(constructorProperties, property)) {
							/*, */
						}
					}
				/*) {
					super();
*/
					for (Property property : constructorProperties) {
						String toFirstLower = toFirstLower(property.getName());
/*						this.#toFirstLower# = #toFirstLower#;
*/					}
/*				}
				
*/			}
			if (entity.getSuperType() == null) {
/*				/**
				 * Returns the automatically generated id that identifies this entity object.
				 #/
				public int getId() {
					return id;
				}
			
				/**
				 * The property 'id' is read-only. 
				 * This setter is only provided for Hibernate. 
				 * It must not be used directly.
				 #/
				@Deprecated
				public void setId(int id) {
					this.id = id;
				}
			
*/			}
			for (Property property : entity.getProperties()) {
				String propertyName = property.getName();
				String toFirstUpper = toFirstUpper(propertyName);
				String typeClassName = property.getTypeClassname();
/*				/**
				 * Returns the value of property '#propertyName#'.
				 #/
				public #typeClassName# get#toFirstUpper#() {
					return #propertyName#;
				}
				
*/				if (property.isReadonly()) {
/*					/**
					 * The property '#propertyName#' is read-only. 
					 * This setter is only provided for Hibernate. 
					 * It must not be used directly.
					 #/
					@Deprecated
*/				} else {
/*					/**
					 * Sets the value of property '#propertyName#'.
					 #/
*/				}
/*				public void set#toFirstUpper#(#typeClassName# newValue) {
					this.#propertyName# = newValue;
				}
				
*/			}
/*		}
*/
		return "";
	}

	private String getTableName(Entity element) {
		OptionType optionType = OptionType.PRESERVE_TABLE_NAMES;
		return getName(element, optionType, false);
	}

	private String getColumnName(Property element) {
		OptionType optionType = OptionType.PRESERVE_COLUMN_NAMES;
		return getName(element, optionType, false);
	}

	private String getName(NamedElement element, OptionType optionType, boolean defaultValue) {
		EntityModel model = null;
		EObject next = element;
		while (true) {
			if (next instanceof EntityModel) {
				model = (EntityModel) next;
				break;
			}
			next = next.eContainer();
		}
		List<Option> options = model.getOptions();
		boolean preserveTableNames = isTrue(optionType, options, defaultValue);
		String name = element.getName();
		if (preserveTableNames) {
			return name;
		} else {
			return name.toLowerCase();
		}
	}

	private boolean isTrue(OptionType type, List<Option> options, boolean defaultValue) {
		for (Option option : options) {
			if (option.getKey() == type) {
				String value = option.getValue();
				if ("true".equals(value)) {
					return true;
				}
			}
		}
		return defaultValue;
	}

	@CommentTemplate
	private String getPropertyDeclarations(Entity entity) {
		/**/
		for (Property property : entity.getProperties()) {
			String propertyName = property.getName();
			String columnName = getColumnName(property);
			String propertyTypeClassname = property.getTypeClassname();
			String nullable = Boolean.toString(property.isNullable());
			if (property.getType() instanceof JavaType) {
				JavaType javaType = (JavaType) property.getType();
				if (javaType.getJavaClass().equals(java.util.Date.class)) {
/*					@Temporal(TemporalType.TIMESTAMP)
*/				}
			}
			if (property.getType() instanceof org.emftext.language.hedl.Enum) {
/*				@Enumerated(EnumType.STRING)
*/			}
			if (property.getType() instanceof Entity) {
				if (!property.isFromMultiplicity() && !property.isToMultiplicity()) {
/*					@OneToOne(cascade={*/
					if (property.isPersist()) {
						/*CascadeType.PERSIST, */
					}
					if (property.isRefresh()) {
						/*CascadeType.REFRESH*/
					}
					if (!property.isPersist() && !property.isRefresh()) {
						/*CascadeType.ALL*/
					}
					/*})
					@JoinColumn(name="#columnName#"*/
					if (property.isReadonly()) {
						/*, updatable=false*/
					}
					/*, nullable=#nullable#)
					*/
				}
				if (property.isFromMultiplicity() && !property.isToMultiplicity()) {
/*					@ManyToOne(cascade={*/
					if (property.isPersist()) {
						/*CascadeType.PERSIST, */
					}
					if (property.isRefresh()) {
						/*CascadeType.REFRESH*/
					}
					if (!property.isPersist() && !property.isRefresh()) {
						/*CascadeType.ALL*/
					}
					/*})
					@JoinColumn(name="#columnName#"*/
					if (property.isReadonly()) {
						/*, updatable=false*/
					}
					/*, nullable=#nullable#)
					*/
				}
				if (!property.isFromMultiplicity() && property.isToMultiplicity()) {
/*					@OneToMany(cascade={*/
					if (property.isPersist()) {
						/*CascadeType.PERSIST, */
					}
					if (property.isRefresh()) {
						/*CascadeType.REFRESH*/
					}
					if (!property.isPersist() && !property.isRefresh()) {
						/*CascadeType.ALL*/
					}
					/*}*/
					if (property.getMappedBy() != null) {
						// TODO is this correct?
						String mappedByName = property.getMappedBy().getName();
						/*, mappedBy="#mappedByName#"*/
					}
					/*)
					*/
				}
				if (property.isFromMultiplicity() && property.isToMultiplicity()) {
					String target = property.getType().getJavaClassname();
					String fetchType = property.isEager() ? "EAGER" : "LAZY";
					// TODO do we need to set the name for the join table?
/*					@ManyToMany(targetEntity=#target#.class, fetch=FetchType.#fetchType#, cascade={*/
					if (property.isPersist()) {
						/*CascadeType.PERSIST, */
					}
					if (property.isRefresh()) {
						/*CascadeType.REFRESH*/
					}
					if (!property.isPersist() && !property.isRefresh()) {
						/*CascadeType.ALL*/
					}
					/*})
					*/
				}
			}
			if (property.getComment() != null) {
				String comment = property.getComment().replace("\t", "");
				/*#comment#
				*/
			}
			if (!(property.getType() instanceof Entity)) {
				// add annotation to specify column name
/*				@Column(name="#columnName#"*/
				if (property.getType() == HedlBuiltinTypes.LONGSTRING) {
					/*, length=100000*/
				}
				/*)
*/			
			}
/*			private #propertyTypeClassname# #propertyName#;
			
		*/
		}
		return "";
	}

	@CommentTemplate
	public String generateEnum(String packageName, org.emftext.language.hedl.Enum enumeration) {
		String enumerationName = enumeration.getName();
		/*package #packageName#.#ENTITY_PACKAGE_NAME#;
		
*/		if (enumeration.getComment() != null) {
			String comment = enumeration.getComment().replace("\t", "");
			/*#comment#
			*/
		}
/*		// this class is generated. any change will be overridden.
		public enum #enumerationName# {
 			
*/
			for (EnumLiteral literal : enumeration.getLiterals()) {
/*				*/
				String literalName = literal.getName();
				if (literal.getComment() != null) {
					String comment = literal.getComment().replace("\t", "");
					/*#comment#
					*/
				}
			/*#literalName#,
*/
			}
/*		}
		*/
		return "";
	}

	private String toFirstUpper(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	private String toFirstLower(String name) {
		return name.substring(0, 1).toLowerCase() + name.substring(1);
	}

	private <T> boolean isFirst(List<T> list, T element) {
		if (list == null || list.isEmpty()) {
			return false;
		}
		return list.get(0) == element;
	}

	private <T> boolean isLast(List<T> list, T element) {
		return getLast(list) == element;
	}

	private <T> T getLast(List<T> list) {
		if (list.isEmpty()) {
			return null;
		}
		return list.get(list.size() - 1);
	}

	private List<Property> filter(List<Property> properties, IFilter filter) {
		List<Property> matching = new ArrayList<Property>();
		for (Property property : properties) {
			if (filter.accept(property)) {
				matching.add(property);
			}
		}
		return matching;
	}
}
