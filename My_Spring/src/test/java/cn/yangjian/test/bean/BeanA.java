package cn.yangjian.test.bean;

import cn.yangjian.test.bean.testclass.Food;
import cn.yangjian.test.bean.testclass.People;
import lombok.Data;

@Data
public class BeanA implements inter_face {

    private People people;

    private Food food;

    public String name;

    public String toString() {
        return "BeanA测试成功" + "属性名：" + name;
    }

    @Override
    public String test_interface_method() {
        System.out.println("动态代理");
        return "动态代理";
    }
}
