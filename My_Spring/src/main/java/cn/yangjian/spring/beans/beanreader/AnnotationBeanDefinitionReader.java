package cn.yangjian.spring.beans.beanreader;

import cn.yangjian.spring.beans.beandefinition.BeanDefinition;
import cn.yangjian.spring.beans.beandefinition.DefaultBeanDefinition;
import cn.yangjian.spring.beans.factory.support.BeanDefinitionRegistry;
import cn.yangjian.spring.beans.factory.support.XmlParser;
import cn.yangjian.spring.io.resource.Resource;
import cn.yangjian.spring.ioc_annotation.Autowired;
import cn.yangjian.spring.ioc_annotation.Component;
import cn.yangjian.spring.util.Assert;
import cn.yangjian.spring.util.PackageUtil;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 直接继承XmlBeanDefinitionReader类实现，不仅能读取xml配置，
 * 还能自动将注解类注入IOC容器,从注解中获取beanDefinition
 */
public class AnnotationBeanDefinitionReader extends XmlBeanDefinitionReader {

    public AnnotationBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public int loadBeanDefinitions(Resource resource) throws Exception {
        return doLoadBeanDefinitionsFromAnnotation(resource);
    }

    // 扫描所有的包
    public int loadBeanDefinitions() throws Exception {
        return doLoadBeanDefinitions(null);
    }

    // 通过注解生成beanDefinition
    public int doLoadBeanDefinitionsFromAnnotation(Resource resource) throws Exception {
        // 加载xml中定义的beanDefinition
        int count = super.doLoadBeanDefinitions(resource);
        // 获得包名，将包下的类进行解析
        List<String> PackageNames = XmlParser.getComponentPackageNames();
        // 读取
        if (Assert.isNotEmpty(PackageNames)) {
            for (String PackageName : PackageNames) {
                // 获得包下的所有类名
                List<String> ClassNames = PackageUtil.getClassName(PackageName);
                if (Assert.isNotEmpty(ClassNames)) {
                    for (String ClassName : ClassNames) {
                        BeanDefinition beanDefinition = new DefaultBeanDefinition();
                        // 获得beanDefinition的beanClass
                        Class<?> beanClass = Class.forName(ClassName);
                        // 验证是否有Component注解
                        Component com = beanClass.getAnnotation(Component.class);
                        if (com != null) {
                            beanDefinition.setBeanClass(beanClass);
                            // 还要获取它的依赖
                            Field[] fields = beanClass.getDeclaredFields();
                            if (fields.length > 0) {
                                for (Field f : fields) {
                                    Autowired autowired = f.getAnnotation(Autowired.class);
                                    if (autowired != null) {
                                        //
                                        beanDefinition.addDepend(autowired.value());
                                    }
                                }
                            }
                            // 默认使用全部小写的方式
                            String beanDefinitionName =
                                    (ClassName.substring(ClassName.lastIndexOf(".") + 1)).toLowerCase();
                            beanDefinitions.put(beanDefinitionName, beanDefinition);
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
