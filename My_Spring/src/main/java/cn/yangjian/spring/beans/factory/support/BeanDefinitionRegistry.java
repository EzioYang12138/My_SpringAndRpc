package cn.yangjian.spring.beans.factory.support;

import cn.yangjian.spring.beans.beandefinition.BeanDefinition;

public interface BeanDefinitionRegistry {

    //注册功能
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    void removeBeanDefinition(String beanName);

}
