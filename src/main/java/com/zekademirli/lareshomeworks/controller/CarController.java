package com.zekademirli.lareshomeworks.controller;

import com.zekademirli.lareshomeworks.request.CreateCarRequest;
import com.zekademirli.lareshomeworks.request.UpdateCarRequest;
import com.zekademirli.lareshomeworks.response.CarResponse;
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
    public List<CarResponse> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public CarResponse getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping
    public void createCar(@RequestBody CreateCarRequest car) {
        carService.createCar(car);
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody UpdateCarRequest car) {
        carService.updateCar(id, car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}

