package com.meiyingying.springlaunch.model.yaml;


import com.meiyingying.springlaunch.config.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@Component
@Validated
@ConfigurationProperties(prefix = "family")
// yml/yaml文件需要配置类
@PropertySource(value = {"classpath:family.yml"}, factory = MixPropertySourceFactory.class)
//properties文件，直接加载进来
//@PropertySource(value = {"classpath:family.properties"})
public class Family {
//    @Value("${family.family-name}")
    @NotEmpty
    private String familyName;

    private Father father;

    private Mother mother;

    private Child child;
}
