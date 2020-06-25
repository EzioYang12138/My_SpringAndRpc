package cn.yangjian.spring.beans.config;

import cn.yangjian.spring.enums.ConfigurableBeanFactory;

import java.util.List;

public interface BeanDefinition {

    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON.getBeanScope();
    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE.getBeanScope();

    //获得依赖BeanDefinition的名字
    List<String> getDepends();

    void addDepend(String depend);

    String getScope();

    void setScope(String scope);

    boolean isSingleton();

    String getDescription();

    Class<?> getBeanClass();

    void setBeanClass(Class<?> beanClass);
}
