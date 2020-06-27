package cn.yangjian.spring.beans.factory;

import cn.yangjian.spring.beans.beandefinition.BeanDefinition;
import cn.yangjian.spring.exception.BeansException;
import cn.yangjian.spring.exception.NoSuchBeanDefinitionException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    boolean containsBeanDefintion(String beanDefinitionName);

    boolean isSingleton(String beanDefinitionName) throws NoSuchBeanDefinitionException;

    BeanDefinition getBeanDefinition(String beanDefinitionName);
}
