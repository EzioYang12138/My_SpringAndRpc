package cn.yangjian.spring.annotation_handle;

import cn.yangjian.spring.beans.factory.BeanFactory;
import cn.yangjian.spring.ioc_annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class AutowiredHandle {
    /*
     * @param AutowiredClasss:注解的类类型
     * @BeanName 带有@Autowired注解的类的名字
     */
    private static final Logger logger = LoggerFactory.getLogger(AutowiredHandle.class);

    public static void AutowiredHandleMethod(Class<?> AutowiredClass, BeanFactory beanFactory, String beanName)
            throws Exception {
        // 遍历AutowiredClass的方法
        for (Method m : AutowiredClass.getDeclaredMethods()) {
            Autowired t = m.getAnnotation(Autowired.class);
            if (t != null) {
                // 有的话我们就将bean进行注入
                String proName = t.value();
                // 获取注入bean
                Object bean = beanFactory.getBean(t.value());
                System.out.println(t.value() + bean);
                String methodName = "set" + proName.substring(0, 1).toUpperCase() + proName.substring(1);
                // System.out.println("methodName:" + methodName);
                Class<?> cl = beanFactory.getBean(beanName).getClass();
                // 通过反射获取方法
                Method method = cl.getMethod(methodName, bean.getClass());
                method.invoke(beanFactory.getBean(beanName), bean);
            }
        }
    }

}
