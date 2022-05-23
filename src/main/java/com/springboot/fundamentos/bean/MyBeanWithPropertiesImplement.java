package com.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {

    private String nombre;
    private String apellido;

    public MyBeanWithPropertiesImplement(String nombre, String apellido) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    @Override
    public String function() {
        return nombre + "-" + apellido;
    }
}
