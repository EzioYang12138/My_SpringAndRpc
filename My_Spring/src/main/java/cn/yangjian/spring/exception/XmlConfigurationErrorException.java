package cn.yangjian.spring.exception;

public class XmlConfigurationErrorException extends ConfigurationErrorException {

    private static final long serialVersionUID = 1L;

    public XmlConfigurationErrorException(String str) {
        super(str);
    }

}
