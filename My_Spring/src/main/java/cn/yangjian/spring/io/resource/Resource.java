package cn.yangjian.spring.io.resource;

import java.io.File;
import java.io.IOException;

public interface Resource extends InputStreamSource {

    boolean exists();

    File getFile() throws IOException;

    /**
     * return a  description for the  resource
     */
    String getDescription();

}
