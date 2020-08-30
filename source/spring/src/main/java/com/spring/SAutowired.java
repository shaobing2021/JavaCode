package com.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//autowired可以写在set方法上， 构造器上，以及字段上
@Target({ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.METHOD})
public @interface SAutowired {
    String value() default "";
}
