package com.shaobing.spring.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
//    返回值就是要导入容器中的组件全类名
//    AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.shaobing.spring.bean.Blue","com.shaobing.spring.bean.Red"};
    }
}
