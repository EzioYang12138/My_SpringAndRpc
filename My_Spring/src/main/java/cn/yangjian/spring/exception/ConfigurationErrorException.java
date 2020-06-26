package cn.yangjian.spring.exception;

public class ConfigurationErrorException extends Exception {
    private static final long serialVersionUID = 1L;

    public ConfigurationErrorException(String message) {
        super(message);
    }

}
