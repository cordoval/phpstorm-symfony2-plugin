package com.xenji.php.symfony2.services.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Mario
 * Date: 03/06/12
 * Time: 09:06
 * To change this template use File | Settings | File Templates.
 */
public class Argument {

    private String value;

    private Boolean isService;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean isService() {
        return isService;
    }

    public void isService(Boolean service) {
        isService = service;
    }
}
