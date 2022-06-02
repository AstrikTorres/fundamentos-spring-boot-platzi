package com.springboot.fundamentos.configuration;

import com.springboot.fundamentos.caseuse.GetUser;
import com.springboot.fundamentos.caseuse.GetUserImpl;
import com.springboot.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfig {

    @Bean
    GetUser getUser(UserService userService) {
        return new GetUserImpl(userService);
    }
}
