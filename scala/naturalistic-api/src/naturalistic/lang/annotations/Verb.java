package naturalistic.lang.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
@author Oscar Pulido Prieto.
*/

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface Verb {
	String name();
	String signature();
	String preposition() default "";
	String returnType();
	String container();
}