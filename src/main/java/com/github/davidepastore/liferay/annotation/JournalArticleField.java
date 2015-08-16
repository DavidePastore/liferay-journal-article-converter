package com.github.davidepastore.liferay.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specific attribute properties of a structure field.
 * @author Davide Pastore
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JournalArticleField {
	
	/**
	 * The name of the field in the structure.
	 * @return Returns the name of the field in the structure.
	 */
	public String name() default "";
	
	/**
	 * Check if the value of the given object should contain the title.
	 * @return Returns true if the given object should contain the title,
	 * false otherwise.
	 */
	public boolean title() default false;
	
	/**
	 * This variable contains the base object property.
	 * This has sense only if the given object is nested.
	 * Liferay organizes nested structures using a pre-existing dynamic-element
	 * as base element and contains all the child in the same level, including
	 * a dynamic-content.
	 * @return Returns true if the given object is nested.
	 */
	public boolean base() default false;
}
