package com.zekademirli.lareshomeworks.service;

import com.zekademirli.lareshomeworks.entity.Car;
import com.zekademirli.lareshomeworks.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CarService {
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car Not Found by  id : " + id));
    }

    public void createCar(Car car) {
        carRepository.save(car);
        log.info("Create one car");
    }

    public void updateCar(Long id, Car car) {
        Car updatedCar = carRepository.findById(id).orElseThrow(null);
        updatedCar.setBrand(car.getBrand());
        updatedCar.setModel(car.getModel());
        updatedCar.setColor(car.getColor());
        updatedCar.setMotor(car.getMotor());
        updatedCar.setCarYear(car.getCarYear());
        updatedCar.setUsed(car.getUsed());
        carRepository.save(updatedCar);
        log.info("Update one car");
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

}
