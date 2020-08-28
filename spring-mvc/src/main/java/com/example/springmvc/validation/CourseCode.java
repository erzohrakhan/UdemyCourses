package com.example.springmvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//helper class that contains business logic / validation logic
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
//can apply annotation to method or field
@Target( {ElementType.METHOD, ElementType.FIELD})
//Retain this policy it at run time
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	//define the attributes
	//define default course code
	public String value() default "LUV";
	
	//define default error message
	public String message() default "must start with LUV";
	
	//define default grps
	public Class<?>[]groups() default {};
	
	//define default payloads
	public Class<? extends Payload>[] payload() default {};
	
}
