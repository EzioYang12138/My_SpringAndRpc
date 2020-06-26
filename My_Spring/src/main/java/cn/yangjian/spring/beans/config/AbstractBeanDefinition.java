package cn.yangjian.spring.beans.config;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//抽象类实现bean definition接口
public abstract class AbstractBeanDefinition implements BeanDefinition {

    private final String SCOPE_DEFAULT = "single";

    @Getter
    @Setter
    private String scope = SCOPE_DEFAULT;

    private Object beanClass;

    List<String> dependentBeanDefinitions = new ArrayList<>();

    // 获取依赖的beanDefinition
    public List<String> getDepends() {
        return dependentBeanDefinitions;
    }

    // 添加beanDefinition依赖
    public void addDepend(String dependName) {
        dependentBeanDefinitions.add(dependName);
    }

    public boolean isSingleton() {
        return this.scope.equals(SCOPE_DEFAULT);
    }

    public String getDescription() {
        return null;
    }

    public Class<?> getBeanClass() {
        Object beanClassObject = this.beanClass;
        if (beanClassObject == null) {
            throw new IllegalStateException("Bean class name [" +
                    beanClassObject + "] has not been resolved into an actual Class");
        }
        return (Class<?>) beanClassObject;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}
