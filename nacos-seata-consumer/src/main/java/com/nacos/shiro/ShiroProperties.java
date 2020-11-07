package com.nacos.shiro;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@EnableConfigurationProperties(ShiroProperties.class)
@ConfigurationProperties(prefix = "shiro")
@Component
@Data
public class ShiroProperties {
    private LinkedHashMap<String, String> filterChainDefinitionMap;
    private List<Map<String,String>> perms;
}
