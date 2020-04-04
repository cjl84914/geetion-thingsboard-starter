package com.geetion.thingsboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thingsboard.rest.client.RestClient;

@Configuration
@EnableConfigurationProperties(ThingsboardProperties.class)
public class ThingsBoardConfig {

    @Autowired
    private ThingsboardProperties tb;

    @Bean
    public RestClient restClient() {
        RestClient client = new RestClient(tb.getUrl());
        client.login(tb.getUsername(), tb.getPassword());
        return client;
    }
}
