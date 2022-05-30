package com.springboot.fundamentos.configuration;

import com.springboot.fundamentos.bean.MyBeanWithProperties;
import com.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}") private String name;
    @Value("${value.apellido}") private String apellido;
    @Value("${value.random}") private String random;

    // Esto solo es un ejemplo de como usar la anotacion value para apuntar a properties
    // En este caso lo recomendable seria trabajar con variables de entorno
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${driver}")
    private String driver;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Bean
    public MyBeanWithProperties function() {
        return new MyBeanWithPropertiesImplement(name, apellido);
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName(driver);
            dataSourceBuilder.url(jdbcUrl);
            dataSourceBuilder.username(username);
            dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
