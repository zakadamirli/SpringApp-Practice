package com.zekademirli.lareshomeworks.service;

import com.zekademirli.lareshomeworks.dto.CarDTO;
import com.zekademirli.lareshomeworks.entity.Car;
import com.zekademirli.lareshomeworks.repository.CarRepository;
import com.zekademirli.lareshomeworks.request.CreateCarRequest;
import com.zekademirli.lareshomeworks.request.UpdateCarRequest;
import com.zekademirli.lareshomeworks.response.CarResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CarService {
    private CarRepository carRepository;
    private final ModelMapper modelMapper;

    public List<CarResponse> getAllCars() {
        List<Car> car = carRepository.findAll();
        return car.stream().map(m -> modelMapper.map(m, CarResponse.class)).toList();
    }

    public CarResponse getCarById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car Not Found by  id : " + id));
        return modelMapper.map(car, CarResponse.class);
    }

    public void createCar(CreateCarRequest car) {
        carRepository.save(modelMapper.map(car, Car.class));
        log.info("Create one car");
    }

    public void updateCar(Long id, UpdateCarRequest car) {
        Car updatedCar = carRepository.findById(id).orElseThrow(null);

        modelMapper.map(car, updatedCar);
        carRepository.save(updatedCar);
        log.info("Update one car");
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
