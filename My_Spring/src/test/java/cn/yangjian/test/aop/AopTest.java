package cn.yangjian.test.aop;

import cn.yangjian.spring.aop.Aop;
import cn.yangjian.spring.aop.DefaultProxyObject;
import cn.yangjian.spring.beans.factory.DefaultListableBeanFactory;
import cn.yangjian.spring.io.resource.FileSystemResource;
import cn.yangjian.test.bean.BeanA;
import cn.yangjian.test.bean.inter_face;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public class AopTest {

    private static final Logger log = LoggerFactory.getLogger(DefaultListableBeanFactory.class);
    DefaultListableBeanFactory defaultListableBeanFactory;

    @Test
    public void testDefaultListableBeanFactoryResource() {
        PropertyConfigurator.configure("log4j.properties");
        //注入一个resource
        FileSystemResource fsr = new FileSystemResource("./resource/application.xml");
        try {
            defaultListableBeanFactory =
                    new DefaultListableBeanFactory(fsr);
            BeanA a = (BeanA) defaultListableBeanFactory.getBean("beana");
            log.debug(a.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void OriginalAopTest() {
        inter_face inface = new DefaultProxyObject().getProxyObjectByType(BeanA.class, new Aop() {
            @Override
            public void before(Object proxy, Method method, Object[] args) {
                System.out.println("before");
            }

            @Override
            public void after(Object proxy, Method method, Object[] args) {
                System.out.println("after");
            }
        });
        inface.test_interface_method();
    }

    @Test
    public void AopAndIoc() throws Exception {
        PropertyConfigurator.configure("log4j.properties");
        //注入一个resource
        FileSystemResource fsr = new FileSystemResource("./resource/application.xml");
        try {
            defaultListableBeanFactory =
                    new DefaultListableBeanFactory(fsr);
        } catch (Exception e) {

            e.printStackTrace();
        }

        DefaultProxyObject dpo =
                defaultListableBeanFactory.getBean("DefaultProxyObject", DefaultProxyObject.class);
        AspectJBeanA ajb = defaultListableBeanFactory.getBean("aspectbeana", AspectJBeanA.class);
        inter_face j = dpo.getProxyObjectByType(BeanA.class, ajb);
        j.test_interface_method();
    }


}
