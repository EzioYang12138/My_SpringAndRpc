package cn.yangjian.rpc.test.bean_service;

import cn.yangjian.rpc.server.RpcService;

import java.util.ArrayList;
import java.util.List;


@RpcService(PersonService.class)
public class PersonServiceImpl implements PersonService {

    @Override
    public List<Person> GetTestPerson(String name, int num) {
        List<Person> persons = new ArrayList<>(num);
        for (int i = 0; i < num; ++i) {
            persons.add(new Person(Integer.toString(i), name));
        }
        return persons;
    }
}
