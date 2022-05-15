package com.plastichouse.SECRET_DIARY_SPRINGBOOT.config;

import com.plastichouse.SECRET_DIARY_SPRINGBOOT.property.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = {JwtProperties.class})
@Configuration
public class ConfigurationPropertiesConfig {
}
