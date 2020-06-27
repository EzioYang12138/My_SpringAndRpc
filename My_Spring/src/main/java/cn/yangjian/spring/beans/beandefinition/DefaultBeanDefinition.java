package cn.yangjian.spring.beans.beandefinition;

public class DefaultBeanDefinition extends AbstractBeanDefinition {

    @Override
    public String getDescription() {
        return getBeanClass().getName();
    }

}
