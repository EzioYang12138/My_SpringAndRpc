package cn.yangjian.test.bean;

import cn.yangjian.spring.ioc_annotation.Autowired;
import cn.yangjian.spring.ioc_annotation.Component;
import lombok.Data;

@Data
@Component
public class AutowiredBean {

    @Autowired(value = "beana")
    private BeanA beana;

    public String say() {
        return beana.toString();
    }

}
