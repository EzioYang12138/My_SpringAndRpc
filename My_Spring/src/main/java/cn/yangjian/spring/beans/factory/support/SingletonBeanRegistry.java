package cn.yangjian.spring.beans.factory.support;

//单例注册表接口
public interface SingletonBeanRegistry {

    /**
     * Register the given existing object as singleton in the bean registry,
     * under the given bean name.
     */
    void registerSingleton(String beanName, Object singletonObject);

    /**
     * Return the (raw) singleton object registered under the given name.
     */
    Object getSingleton(String beanName);

    /**
     * Check if this registry contains a singleton instance with the given name.
     */
    boolean containsSingleton(String beanName);

    /**
     * Return the number of singleton beans registered in this registry.
     */
    int getSingletonCount();
}
