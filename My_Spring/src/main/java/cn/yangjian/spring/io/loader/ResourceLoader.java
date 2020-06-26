package cn.yangjian.spring.io.loader;

import cn.yangjian.spring.io.resource.Resource;

public interface ResourceLoader {

    Resource getResource(String location);
}
