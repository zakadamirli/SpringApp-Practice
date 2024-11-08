package com.zekademirli.lareshomeworks.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {

    private String brand;
    private String model;
    private Integer carYear;
    private String color;
    private boolean used;
    private double motor;
}
