package cn.yangjian.spring.context;

import cn.yangjian.spring.beans.factory.AutowireCapableBeanFactory;
import cn.yangjian.spring.beans.factory.DefaultListableBeanFactory;
import cn.yangjian.spring.beans.factory.support.BeanDefinitionRegistry;
import cn.yangjian.spring.beans.beanreader.AnnotationBeanDefinitionReader;
import cn.yangjian.spring.io.resource.Resource;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutowireApplicationContext extends DefaultListableBeanFactory implements
        AutowireCapableBeanFactory {

    private static final Logger log = LoggerFactory.getLogger(AutowireApplicationContext.class);

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    public AutowireApplicationContext(Resource resource) throws Exception {
        super(resource);
        refresh();
    }

    public AutowireApplicationContext(String location) throws Exception {
        super(location);
        refresh();
    }

    /*
     * 继承ComponentHandle，拥有解析@component注解的能力
     */
    private static class AutowireAnnotationBeanDefinition extends AnnotationBeanDefinitionReader {
        public AutowireAnnotationBeanDefinition(BeanDefinitionRegistry registry) {
            super(registry);
        }
    }

    @Override
    protected void refresh() throws Exception {
        int count = new AutowireAnnotationBeanDefinition(this).loadBeanDefinitions(resource);
        log.info("一共初注册了:" + count + "个beanDefinition");
    }

    @Override
    public void AutowireBean() {

    }
}
