package com.example.mybatis.mybatisdemo.annotation;

import java.lang.annotation.*;

@Repeatable(MyAnnotations.class)
@Target({ElementType.METHOD,ElementType.PARAMETER,ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "ctq";
}
