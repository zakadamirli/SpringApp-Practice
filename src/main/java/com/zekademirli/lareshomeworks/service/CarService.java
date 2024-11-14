package com.zekademirli.lareshomeworks.service;

import com.zekademirli.lareshomeworks.dto.CarDTO;
import com.zekademirli.lareshomeworks.entity.Car;
import com.zekademirli.lareshomeworks.repository.CarRepository;
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

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car Not Found by  id : " + id));
    }

    public void createCar(CarDTO car) {
        carRepository.save(modelMapper.map(car, Car.class));
        log.info("Create one car");
    }

    public void updateCar(Long id, Car car) {
        Car updatedCar = carRepository.findById(id).orElseThrow(null);

        modelMapper.map(car, updatedCar);
        carRepository.save(updatedCar);
        log.info("Update one car");
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    private CarDTO convertToDTO(Car car) {
        return modelMapper.map(car, CarDTO.class);
    }

    private Car convertToEntity(CarDTO carDTO) {  //unit test problem
        return modelMapper.map(carDTO, Car.class);
    }

}
