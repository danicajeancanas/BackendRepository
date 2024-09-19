package com.accenture.ws.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CafeClerk {

    private String name;

    public CafeClerk(@Value("${cafe.clerk.name}") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
