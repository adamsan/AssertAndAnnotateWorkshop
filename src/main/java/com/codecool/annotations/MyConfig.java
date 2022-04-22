package com.codecool.annotations;

import com.codecool.annotations.simplespring.Bean;
import com.codecool.annotations.simplespring.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public MyObject createMyObject() {
        return new MyObject();
    }

    @Bean
    public String createStringBean() {
        return "I'm just a string, but I'm also a Bean!";
    }
}
