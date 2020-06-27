package cn.yangjian.spring.beans.beanreader;

import cn.yangjian.spring.beans.factory.support.BeanDefinitionRegistry;
import cn.yangjian.spring.io.loader.ResourceLoader;
import cn.yangjian.spring.io.resource.Resource;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getBeanDefinitionRegistry();

    ResourceLoader getResourceLoader();

    int loadBeanDefinitions(Resource... resources) throws Exception;

    int loadBeanDefinitions(Resource resource) throws Exception;

}
