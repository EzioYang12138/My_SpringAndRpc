package cn.yangjian.spring.io.resource;

import java.io.File;

public class DocumentResource extends FileSystemResource {

    public DocumentResource(File file) {
        super(file);

    }

    public DocumentResource(String path) {
        super(path);

    }

    @Override
    public String getDescription() {
        //重寫下getDescription()方法
        return "这是一个稳定的Resource：" + super.getDescription();
    }


}
