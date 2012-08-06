package org.emftext.commons.jsglr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import lpg.runtime.IAst;
import lpg.runtime.IAstVisitor;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.strategoxt.imp.runtime.parser.ast.AstNode;
import org.strategoxt.imp.runtime.parser.ast.ListAstNode;
import org.strategoxt.imp.runtime.parser.ast.StringAstNode;

public class AbstractSyntaxTreeVisitor implements IAstVisitor {

	EObject model;
	EObject node;
	EFactory factory;
	java.lang.String pkg;
	java.lang.String attributeName;
	java.lang.String attributeInterface;

	public AbstractSyntaxTreeVisitor(EFactory factory, EObject model,
			java.lang.String pkg, java.lang.String attributeName,
			String attributeInterface) {
		this.model = model;
		this.factory = factory;
		this.pkg = pkg;
		this.attributeName = attributeName;
		this.attributeInterface = attributeInterface;
		node = null;
	}

	public EObject getNode() {
		return node;
	}

	public void postVisit(IAst element) {

		if (element instanceof StringAstNode) {

			Method setter;
			Method getter;

			if (model != null && attributeName != null) {
				try {
					System.out.println(model.getClass().getSimpleName() + "."
							+ getSetterName() + " ( "
							+ ((StringAstNode) element).getValue() + ")");
					setter = model.getClass().getMethod(getSetterName(),
							java.lang.String.class);
					setter.invoke(model, ((StringAstNode) element).getValue());
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		} else if (element instanceof ListAstNode) {

		} else if (element instanceof AstNode) {

			Method setter;
			Method getter;
			java.lang.String name = ((AstNode) element).getConstructor();
			boolean attribute = false;
			boolean abstrct = false;

			try {
				getter = factory.getClass().getMethod("create" + name, null);
				node = (EObject) getter.invoke(factory, new Object[0]);
			} catch (SecurityException e3) {
				e3.printStackTrace();
			} catch (NoSuchMethodException e3) {
				node = model;
				if (name.toLowerCase().equals(name)) {
					attributeName = name;
					attribute = true;
				} else {
					// class is abstract
					attributeInterface = name;
					abstrct = true;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			try {
				if (model != null && attributeName != null && !attribute
						&& !abstrct) {
					getter = model.getClass().getMethod(getGetterName(), null);
					Object result = getter.invoke(model, null);
					// System.out.println(result);

					if (result == null) {
						if (attributeInterface != null) {
							name = attributeInterface;
							attributeInterface = null;
						}

						System.out.println(model.getClass().getSimpleName()
								+ "." + getSetterName() + " ( " + name + ")");
						setter = model.getClass().getMethod(getSetterName(),
								Class.forName(pkg + "." + name));
						setter.invoke(model, node);
					} else {
						// System.out.println(getGetterName());
						((List) result).add(node);
					}

					attributeName = null;
				}

			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				// The class is either abstract or the name references an
				// attribute
				e1.printStackTrace();
			} catch (ClassNotFoundException e2) {
				// e2.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		if (node != null) {
			System.out.println(node.getClass().getCanonicalName());

			for (Object elem : element.getChildren()) {
				((IAst) elem).accept(new AbstractSyntaxTreeVisitor(factory,
						node, pkg, attributeName, attributeInterface));
			}
		}
	}

	private java.lang.String getGetterName() {
		return "get" + attributeName.substring(0, 1).toUpperCase()
				+ attributeName.substring(1);
	}

	private java.lang.String getSetterName() {
		return "set" + attributeName.substring(0, 1).toUpperCase()
				+ attributeName.substring(1);
	}

	public boolean preVisit(IAst element) {
		return false;
	}
}
