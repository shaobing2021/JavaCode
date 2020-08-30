package com.shaobing.spring.di;

//import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTest {
//    @Test
    public void test() throws Exception{
        UserController controller = new UserController();
        Class<? extends UserController> clazz = controller.getClass();
//        提前创建好userService
        UserService service = new UserService();
//        获取类中属性值,需要抛出异常
        Field serviceFiled = clazz.getDeclaredField("userService");
//        访问的时候如果是私有的访问类型，可以直接进行访问。
        serviceFiled.setAccessible(true);
//        获取属性名称
        String serviceName = serviceFiled.getName();
//        System.out.println(serviceName);  这里输出的为Userservice xxxx
        serviceName = serviceName.substring(0,1).toUpperCase()+serviceName.substring(1,serviceName.length());
//        获取到setUserService
        String methodName = "set"+serviceName;
//        获取有参方法，需要传入参数类，这里可以理解重载有多个函数
        Method method = clazz.getMethod(methodName,UserService.class);
//        将自己new好的service通过setService注入
        method.invoke(controller,service);
//        System.out.println(service);  com.shaobing.spring.di.UserService@506e6d5e
        System.out.println(controller.getUserService());//com.shaobing.spring.di.UserService@506e6d5e
    }

//    @Test
    public void testA() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        UserController controller = new UserController();
        Class<? extends UserController> clazz = controller.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
//            对于某个域都要让其可见
            field.setAccessible(true);
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation!=null){
                Class<?> type = field.getType();
//                System.out.println(type);//class com.shaobing.spring.di.UserService
                Object o = type.getDeclaredConstructor().newInstance();
//                通过set给controller实例field域中注入o这个值
                field.set(controller,o);
            }
        }
        System.out.println(controller.getUserService());
    }
}
