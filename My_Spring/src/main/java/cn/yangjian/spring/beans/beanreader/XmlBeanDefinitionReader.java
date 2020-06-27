package cn.yangjian.spring.beans.beanreader;

import cn.yangjian.spring.beans.beandefinition.BeanDefinition;
import cn.yangjian.spring.beans.beandefinition.DefaultBeanDefinition;
import cn.yangjian.spring.beans.factory.support.BeanDefinitionRegistry;
import cn.yangjian.spring.beans.factory.support.XmlParser;
import cn.yangjian.spring.io.resource.Resource;
import cn.yangjian.spring.io.resource.XmlDocumentResource;
import org.jdom.Document;

import java.util.HashMap;
import java.util.Map;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    //暂时保存beanDefinition，稍后在doLoadBeanDefinitions方法中注册到beanFactory
    protected Map<String, BeanDefinition> beanDefinitions = new HashMap<>();

    // 默认使用DefaultBeanDefinition
    @SuppressWarnings("unused")
    private final BeanDefinition beanDefinition;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
        beanDefinition = new DefaultBeanDefinition();
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, BeanDefinition beanDefinition) {
        super(registry);
        this.beanDefinition = beanDefinition;
    }

    // spring有四个加载bean定义的方法，这里只实现一个
    @Override
    public int loadBeanDefinitions(Resource resource) throws Exception {
        return doLoadBeanDefinitions(resource);
    }

    public int doLoadBeanDefinitions(Resource resource) throws Exception {
        // 在加载beandefinition之前，先getxml资源的Document对象
        Document doc = doLoadDocument(resource);
        // 在这里将doc进行解析
        beanDefinitions = XmlParser.parser(doc);
        // 再次可以选择注入一个什么类型的bean
        for (Map.Entry<String, BeanDefinition> beanDefinition : beanDefinitions.entrySet()) {
            // 将这个bean进行注册,这是一个接口方法，当某个容器需要注册功能的时候，再继承这个类
            // key is the name of bean,value is the beanDefinition
            registry.registerBeanDefinition(beanDefinition.getKey(), beanDefinition.getValue());
        }
        return beanDefinitions.size();
    }

    protected Document doLoadDocument(Resource resource) throws Exception {
        return new XmlDocumentResource(resource.getFile()).getDocument();
    }

}

