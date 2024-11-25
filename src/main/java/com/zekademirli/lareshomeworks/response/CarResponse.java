package com.zekademirli.lareshomeworks.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponse {

    private String brand;
    private String model;
    private Integer carYear;
    private String color;
    private Boolean used;
    private Double motor;
}
