package com.shaobing.spring.condition;

import com.shaobing.spring.bean.Rain;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * importingClassMetadata：当前类的注解信息
     * BeanDefinitionRegistry：BeanDefiinition注册类
     * 把所需要添加到容器的bean，调用beandefinitionRegistry.registerBeanDefinition手工注册
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.shaobing.spring.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.shaobing.spring.bean.Blue");
        if (red&&blue){
            RootBeanDefinition definition = new RootBeanDefinition(Rain.class);
            registry.registerBeanDefinition("rainBow",definition);
        }
    }
}
