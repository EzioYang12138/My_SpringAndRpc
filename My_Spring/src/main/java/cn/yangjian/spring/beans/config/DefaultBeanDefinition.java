package cn.yangjian.spring.beans.config;

public class DefaultBeanDefinition extends AbstractBeanDefinition {

    @Override
    public String getDescription() {
        return getBeanClass().getName();
    }

}
