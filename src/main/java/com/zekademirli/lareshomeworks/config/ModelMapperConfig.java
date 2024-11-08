package com.zekademirli.lareshomeworks.config;

import com.zekademirli.lareshomeworks.converter.CarToCarDTOConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    private final CarToCarDTOConverter carToCarDTOConverter;

    public ModelMapperConfig(CarToCarDTOConverter carToCarDTOConverter) {
        this.carToCarDTOConverter = carToCarDTOConverter;
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(carToCarDTOConverter);
        return modelMapper;
    }
}