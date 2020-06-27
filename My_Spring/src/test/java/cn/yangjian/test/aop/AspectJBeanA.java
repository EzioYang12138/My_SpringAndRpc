package cn.yangjian.test.aop;

import cn.yangjian.spring.aop.Aop;
import cn.yangjian.test.bean.inter_face;

import java.lang.reflect.Method;

public class AspectJBeanA implements inter_face, Aop {

    @Override
    public void after(Object proxy, Method method, Object[] args) {
        System.out.println("after");
    }

    @Override
    public void before(Object proxy, Method method, Object[] args) {
        System.out.println("before");
    }

    @Override
    public String test_interface_method() {
        return null;
    }
}
