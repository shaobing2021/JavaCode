package com.shaobing.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LogAspects {
    //切入点表达式
    @Pointcut("execution(public int com.shaobing.aop.aop.MathCalculator.*(..))")
    public void pointCut(){

    }

    //如果joinpoint加上了，后面还传递结果或者异常，要把joinpoint放第一位
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.print("div运行....方法名："+joinPoint.getSignature().getName());
        System.out.println("....参数是："+ Arrays.toString(args)+".."+Arrays.asList(args));
    }
    @After("com.shaobing.aop.aop.LogAspects.pointCut()")
//    @After("public int com.shaobing.aop.aop.MathCalculator.*(..)")  为啥出问题
    public void logEnd(){
        System.out.println("div结束...");
    }
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result ){
        System.out.println("div正常返回....结果是：{"+result+"}");
    }
    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void logException(Exception e){
        System.out.println("div异常....异常是：{"+e+"}");
    }
}
