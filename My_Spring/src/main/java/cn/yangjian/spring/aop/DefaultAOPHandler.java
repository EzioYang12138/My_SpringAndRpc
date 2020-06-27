package cn.yangjian.spring.aop;

import java.lang.reflect.Method;

public class DefaultAOPHandler extends AbstractAOPHandler {

    private final Aop aop;

    public DefaultAOPHandler(Object object, Aop aop) {
        super(object);
        this.aop = aop;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object ret = null;
        //修改的地方在这里
        this.aop.before(proxy, method, args);
        ret = method.invoke(object, args);
        //修改的地方在这里
        this.aop.after(proxy, method, args);
        return ret;
    }

}
