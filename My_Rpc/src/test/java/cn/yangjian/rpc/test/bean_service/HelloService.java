package cn.yangjian.rpc.test.bean_service;

public interface HelloService {
    String hello(String name);

    String hello(Person person);
}
