package com.spring;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SpringApplicationContext {
    private ConcurrentHashMap<String,BeanDefinition> beanDefinitionConcurrentHashMap= new ConcurrentHashMap<>();
    private ConcurrentHashMap<String,Object> singletonObjectMap= new ConcurrentHashMap<>();
    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    public SpringApplicationContext(Class configClass) {
        //扫描类
        List<Class> classList = scan(configClass);
        for (Class clazz : classList) {
            if (clazz.isAnnotationPresent(SComponent.class)){
                SComponent component = (SComponent) clazz.getAnnotation(SComponent.class);
                String beanName = component.value();
                //System.out.println(beanName);
                //获取单例or多例
                BeanDefinition beanDefinition = new BeanDefinition();
//                判断扫描的类是否有scope注解
               if (clazz.isAnnotationPresent(Scope.class)){
                   Scope scope =(Scope) clazz.getAnnotation(Scope.class);
                   beanDefinition.setScope(scope.value());
               }else {
                   beanDefinition.setScope("singleton");
               }
               //判断当前类是否是BeanPostProcessor的实现类
               if (BeanPostProcessor.class.isAssignableFrom(clazz)){
                   try {
                       BeanPostProcessor bpp = (BeanPostProcessor)clazz.getDeclaredConstructor().newInstance();
                        beanPostProcessors.add(bpp);
                   } catch (InstantiationException e) {
                       e.printStackTrace();
                   } catch (IllegalAccessException e) {
                       e.printStackTrace();
                   } catch (InvocationTargetException e) {
                       e.printStackTrace();
                   } catch (NoSuchMethodException e) {
                       e.printStackTrace();
                   }
               }
                beanDefinition.setBeanClass(clazz);
                beanDefinitionConcurrentHashMap.put(beanName,beanDefinition);
            }
        }
        //扫描类之后，解析这个类，component，beandefinition
        for (String beanName : beanDefinitionConcurrentHashMap.keySet() ) {
            BeanDefinition beanDefinition = beanDefinitionConcurrentHashMap.get(beanName);
            //根据bean信息创建一个bean,要确保这个bean未被创建，万一有个bean依赖这个bean，就会创建，到时候又创建一次
            if (beanDefinition.getScope().equals("singleton")&&singletonObjectMap.get(beanName)==null){
                Object bean = createBean(beanName,beanDefinition);
                singletonObjectMap.put(beanName,bean);
            }
        }
    }

    private Object createBean(String beanName,BeanDefinition beanDefinition) {
        Object instance = null;
//        if (beanDefinition.getScope().equals("singleton")) {
            //生成这个bean，
            Class beanClass = beanDefinition.getBeanClass();
            try {
                //进行实例化(还没有赋值)
                instance = beanClass.getDeclaredConstructor().newInstance();

                //填充属性
                Field[] fields = beanClass.getDeclaredFields();
                for (Field field : fields) {
                    //将有autowired注解的属性进行注入
                   if (field.isAnnotationPresent(SAutowired.class)){
                       //这里需要注入，注入的对象要从容器中拿
                       Object bean = getBean(field.getName());
                       field.setAccessible(true);
                       field.set(instance,bean);
                   }
                }
                //Aware接口逻辑获取bean的名字
                if (instance instanceof BeanNameAware){
                    ((BeanNameAware) instance).setBeanName(beanName);
                }
                //beanpostprocessor执行前的逻辑
                for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                    beanPostProcessor.postProcessBeforeInitialization(instance,beanName);
                }

                //初始化..
                if (instance instanceof InitializingBean){
                    ((InitializingBean) instance).afterPropertiesSet();
                }
                //beanpostprocessor执行后的逻辑
                for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                    beanPostProcessor.postProcessAfterInitialization(instance,beanName);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
//        }
        return instance;
    }

    private List<Class> scan(Class configClass) {
        ArrayList<Class> classList = new ArrayList<>();
        SComponentScan componentScan = (SComponentScan)configClass.getAnnotation(SComponentScan.class);
        //获取扫描路径
        String value = componentScan.value();
        //System.out.println(value);//com.realization.service-->真正的目录根式com/realization/service
        value = value.replace(".", "/");  //能够扫描到的类
        //扫描类
        ClassLoader classLoader = SpringApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(value);
        File file = new File(resource.getFile());
        File[] files = file.listFiles();
        //获取指定目录下的文件列表，可能是class，可能是txt，按道理要递归，万一文件夹下面还有
        for (File f : files) {
            //F:\code\source\spring\target\classes\com\realization\service\OrderService.class
            //F:\code\source\spring\target\classes\com\realization\service\UserService.class
            String absolutePath = f.getAbsolutePath();
            absolutePath = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"));
            absolutePath  = absolutePath.replace("\\", ".");
            try {
                Class<?> clazz = classLoader.loadClass(absolutePath);
                classList.add(clazz);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return classList;
    }

    public Object getBean(String beanName){
        BeanDefinition beanDefinition = beanDefinitionConcurrentHashMap.get(beanName);
        if (beanDefinition.getScope().equals("prototype")){
            return createBean(beanName,beanDefinition);
        }else {
            Object bean = singletonObjectMap.get(beanName);
            if (bean==null){
                bean = createBean(beanName,beanDefinition);
                singletonObjectMap.put(beanName,bean);
            }
            return bean;
        }
    }
}
