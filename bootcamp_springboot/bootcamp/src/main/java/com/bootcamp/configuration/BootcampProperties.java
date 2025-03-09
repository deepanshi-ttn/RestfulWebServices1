package com.bootcamp.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import io.micrometer.common.lang.NonNull;

@Configuration
@ConfigurationProperties(prefix = "bootcamp")
public class BootcampProperties {

    @NonNull
    private String myProperty;

    public String getMyProperty() {
        return myProperty;
    }

    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }

}
