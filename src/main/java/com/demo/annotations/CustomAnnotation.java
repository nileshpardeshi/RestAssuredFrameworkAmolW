package com.demo.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface CustomAnnotation {

	String[] author() default "";
	int[] TCID() default 0;
	String[] category() default "";
}
