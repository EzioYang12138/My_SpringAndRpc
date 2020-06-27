package cn.yangjian.test.bean;

import cn.yangjian.spring.ioc_annotation.Component;

@Component
public class ComponentBean {

    @Override
    public String toString() {
        return "注解注入测试成功";
    }
}
