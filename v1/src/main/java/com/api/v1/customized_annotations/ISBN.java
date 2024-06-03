package com.api.v1.customized_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@NotNull
@Size(min = 13, max = 13)
public @interface ISBN {
  String message() default "Invalid ISBN format. Please enter a 13-digit ISBN number.";
} 