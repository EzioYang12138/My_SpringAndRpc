package cn.yangjian.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public abstract class AbstractAOPHandler implements InvocationHandler {

    protected Object object;

    public AbstractAOPHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        return method.invoke(object, args);
    }

}
