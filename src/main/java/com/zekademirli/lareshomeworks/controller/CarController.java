package com.zekademirli.lareshomeworks.controller;

import com.zekademirli.lareshomeworks.entity.Car;
import com.zekademirli.lareshomeworks.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping
    public void createCar(@RequestBody Car car) {
        carService.createCar(car);
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody Car car) {
        carService.updateCar(id, car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}

