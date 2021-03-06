package cn.yangjian.spring.beans.factory;

/**
 * 带有自动注入功能的beanfactory
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
    //拥有自动注入bean的功能，检查Map集合，如果有@Autowire注解，进行自动注入
    void AutowireBean();
}
