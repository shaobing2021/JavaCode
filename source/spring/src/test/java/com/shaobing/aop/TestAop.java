package com.shaobing.aop;

import com.shaobing.aop.aop.MathCalculator;
import com.shaobing.aop.config.MainConfigAOp;
import com.shaobing.spring.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAop {
    BeanFactory context = new AnnotationConfigApplicationContext(MainConfigAOp.class);

    @Test
    public void test1(){
        MathCalculator mathCalculator = context.getBean(MathCalculator.class);
        mathCalculator.div(1,1);
    }
}
