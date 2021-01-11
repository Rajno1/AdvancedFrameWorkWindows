package com.issi.annotations;

import com.issi.enums.CategoryType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.METHOD)
/**
 * This is a Custom annotation class
 * using this class, we can define elements required and assign to our test methods.
 */
public @interface FrameWorkAnnotation {

    public String[] author();
    public CategoryType[] category();
    public String[] device() default {}; // if we wont specify 'default' at the end , it will become like mandatory field.

 }
