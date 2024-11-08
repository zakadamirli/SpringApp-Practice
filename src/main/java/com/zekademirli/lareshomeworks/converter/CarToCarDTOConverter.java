package com.zekademirli.lareshomeworks.converter;

import com.zekademirli.lareshomeworks.dto.CarDTO;
import com.zekademirli.lareshomeworks.entity.Car;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class CarToCarDTOConverter implements Converter<Car, CarDTO> {

    @Override
    public CarDTO convert(MappingContext<Car, CarDTO> context) {
        Car source = context.getSource();
        CarDTO destination = new CarDTO();

        destination.setBrand(source.getBrand());
        destination.setModel(source.getModel());
        destination.setCarYear(source.getCarYear());
        destination.setColor(source.getColor());
        destination.setMotor(source.getMotor());

        destination.setUsed(source.getUsed() != null && source.getUsed());

        return destination;
    }
}