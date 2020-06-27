package cn.yangjian.test.beans_factory;

import cn.yangjian.spring.beans.factory.DefaultListableBeanFactory;
import cn.yangjian.spring.exception.BeansException;
import cn.yangjian.spring.io.resource.FileSystemResource;
import cn.yangjian.test.bean.BeanA;
import cn.yangjian.test.bean.testclass.Food;
import cn.yangjian.test.bean.testclass.People;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultListableBeanFactoryTest {

    private static final Logger log = LoggerFactory.getLogger(DefaultListableBeanFactoryTest.class);

    DefaultListableBeanFactory defaultListableBeanFactory;

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    @Before
    public void testDefaultListableBeanFactoryResource() {
        // 注入一个resource
        FileSystemResource fsr = new FileSystemResource("./resource/application.xml");
        try {
            defaultListableBeanFactory = new DefaultListableBeanFactory(fsr);
        } catch (Exception e) {
            log.error("defaultListableBeanFactory异常");
        }
    }

    @Test
    public void testDefaultListableBeanFactoryString() {
        try {
            BeanA a = (BeanA) defaultListableBeanFactory.getBean("beana");
            log.info("the  same  food?   " + (a.getFood() == a.getPeople().getFood()));
            log.info(a.getFood().getFoodName());
            Food f = (Food) defaultListableBeanFactory.getBean("food");
            log.info(f.getFoodName() + f.getNumber());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRemoveBeanDefinition() throws Exception {
        defaultListableBeanFactory.removeBeanDefinition("beana");
        BeanA a = defaultListableBeanFactory.getBean("beana", BeanA.class);
        log.info("beanDefinition已经被移除：" + (a == null));
    }

    @Test
    public void testGetBean() {
        People people;

        try {
            people = defaultListableBeanFactory.getBean("people", People.class);
            log.info(people.getFood().say());
        } catch (BeansException e) {
            log.info(String.valueOf(e));
        }

    }
}
