package com.meiyingying.springlaunch.model.yaml;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "family")
public class Family {
//    @Value("${family.family-name}")
    private String familyName;

    private Father father;

    private Mother mother;

    private Child child;
}
