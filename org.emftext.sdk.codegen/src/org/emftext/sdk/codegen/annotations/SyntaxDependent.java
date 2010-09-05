package org.emftext.sdk.codegen.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * This annotation is used to tag generator classes, which produce output that
 * depends on the concrete syntax. It is used to include this information in
 * the generated documentation.
 */
@Target(ElementType.TYPE)
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface SyntaxDependent {

}
