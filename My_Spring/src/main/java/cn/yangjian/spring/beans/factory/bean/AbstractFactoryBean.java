package cn.yangjian.spring.beans.factory.bean;

public abstract class AbstractFactoryBean<T> implements FactoryBean<T> {

    @Override
    public boolean isSingleton() {
        return true;
    }

}
