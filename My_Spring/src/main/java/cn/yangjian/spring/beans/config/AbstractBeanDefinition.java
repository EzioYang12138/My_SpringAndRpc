package cn.yangjian.spring.beans.config;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBeanDefinition implements BeanDefinition {

    private final String SCOPE_DEFAULT = "single";
    private String scope = SCOPE_DEFAULT;
    private Object beanClass;

    List<String> dependentBeanDefinitions = new ArrayList<>();

    public List<String> getDepends() {
        return null;
    }

    public void addDepend(String depend) {

    }

    public String getScope() {
        return null;
    }

    public void setScope(String scope) {

    }

    public boolean isSingleton() {
        return false;
    }

    public String getDescription() {
        return null;
    }

    public Class<?> getBeanClass() {
        return null;
    }

    public void setBeanClass(Class<?> beanClass) {

    }
}
