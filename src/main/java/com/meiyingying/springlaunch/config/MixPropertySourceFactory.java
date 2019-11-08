package com.meiyingying.springlaunch.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.Properties;

public class MixPropertySourceFactory extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException{
        String sourceName = name != null ? name : resource.getResource().getFilename();
        if(!resource.getResource().exists()){
            return new PropertiesPropertySource(sourceName, new Properties());
        }else if(sourceName.endsWith(".yml") || sourceName.endsWith(".yaml")){
            Properties propertiesFromYml = loadYml(resource);
            return new PropertiesPropertySource(sourceName, propertiesFromYml);
        }else {
            return super.createPropertySource(name, resource);
        }

    }

    public Properties loadYml(EncodedResource resource) throws IOException{
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(resource.getResource());
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }
}
