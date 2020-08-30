package com.shaobing.spring.di;

import java.lang.annotation.*;
//运行范围
@Retention(RetentionPolicy.RUNTIME)
//可以注入的地方
@Target(ElementType.FIELD)
//可否继承
@Inherited
//生成文档
@Documented
public @interface Autowired {

}
