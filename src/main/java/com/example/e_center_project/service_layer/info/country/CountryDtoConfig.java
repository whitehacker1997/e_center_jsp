package com.example.e_center_project.service_layer.info.country;

import com.example.e_center_project.data_layer.entity_classes.Country;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryDtoConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Country, CountryDto>() {
            @Override
            protected void configure() {
                map().setStateName(source.getState().getShortName());
            }
        });

        return modelMapper;
    }
}
