package cn.yangjian.spring.context;

import cn.yangjian.spring.beans.factory.AutowireCapableBeanFactory;
import cn.yangjian.spring.io.loader.DefaultResourceLoader;

public abstract class AbstractApplicationContext extends DefaultResourceLoader
        implements ApplicationContext, AutowireCapableBeanFactory {

}
