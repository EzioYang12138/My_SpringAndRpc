package cn.yangjian.rpc.test.bean_service;

import java.util.List;


public interface PersonService {
    List<Person> GetTestPerson(String name, int num);
}
