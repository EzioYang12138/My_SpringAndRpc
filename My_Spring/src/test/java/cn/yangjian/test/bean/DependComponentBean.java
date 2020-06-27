package cn.yangjian.test.bean;

import cn.yangjian.spring.ioc_annotation.Autowired;
import cn.yangjian.spring.ioc_annotation.Component;
import lombok.Data;

@Component
@Data
public class DependComponentBean {

    @Autowired(value="componentbean")
    private ComponentBean componentbean;

    @Override
    public String toString() {
        return "DependComponentBean："+componentbean.toString();
    }

}
