package com.zekademirli.lareshomeworks.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCarRequest {
    private String brand;
    private String model;
    private Integer carYear;
    private String color;
    private boolean used;
    private double motor;
}