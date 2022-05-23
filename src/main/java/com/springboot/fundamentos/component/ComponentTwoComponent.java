package com.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoComponent implements ComponentDependency {

    @Override
    public void saludar() {
        System.out.println("Hola desde mi componente dos");
    }
}
