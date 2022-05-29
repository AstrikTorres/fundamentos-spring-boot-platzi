package com.springboot.fundamentos.configuration;

import com.springboot.fundamentos.bean.MyBeanWithProperties;
import com.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}") private String name;
    @Value("${value.apellido}") private String apellido;
    @Value("${value.random}") private String random;

    @Bean
    public MyBeanWithProperties function() {
        return new MyBeanWithPropertiesImplement(name, apellido);
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName("org.h2.Driver");
            dataSourceBuilder.url("jdbc:h2:testdb");
            dataSourceBuilder.username("SA");
            dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
