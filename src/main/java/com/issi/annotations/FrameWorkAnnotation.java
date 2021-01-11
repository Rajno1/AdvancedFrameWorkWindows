package com.issi.annotations;

import com.issi.enums.CategoryType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.METHOD)
public @interface FrameWorkAnnotation {

    public String[] author();
    public CategoryType[] category();
    public String[] device() default {};

 }
