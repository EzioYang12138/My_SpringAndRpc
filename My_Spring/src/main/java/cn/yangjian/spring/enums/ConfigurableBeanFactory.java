package cn.yangjian.spring.enums;

public enum ConfigurableBeanFactory {

    SCOPE_SINGLETON("singleton"),
    SCOPE_PROTOTYPE("prototype");

    private final String BeanScope;

    ConfigurableBeanFactory(String BeanScope) {
        this.BeanScope = BeanScope;
    }

    public String getBeanScope() {
        return BeanScope;
    }

}
