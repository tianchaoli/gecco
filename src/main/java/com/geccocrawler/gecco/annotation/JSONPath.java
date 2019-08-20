package com.geccocrawler.gecco.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * fastjson,jsonpath语法
 * 
 * @author huchengyi
 *
 */
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONPath {
	
	/**
	 * jsonpath
	 * 
	 * @return jsonpath
	 */
	String value();
	
	/**
	 * 表示是否为可选值
	 * 
	 * @return 是否可以为可选值
	 */
	boolean optional() default true;
	
}
