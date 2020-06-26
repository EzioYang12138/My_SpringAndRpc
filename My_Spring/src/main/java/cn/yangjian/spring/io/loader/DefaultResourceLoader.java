package cn.yangjian.spring.io.loader;

import cn.yangjian.spring.io.resource.FileSystemResource;
import cn.yangjian.spring.io.resource.Resource;

public class DefaultResourceLoader implements ResourceLoader{

    /**
     * 默认获取资源的方式：Spring官方返回的是一个ClassPathContextResource，
     * 在这里，使用从文件系统中获取Resource的方式
     */
    @Override
    public Resource getResource(String path){
        return new FileSystemResource(path);
    }

}
