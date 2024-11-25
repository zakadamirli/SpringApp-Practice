package com.zekademirli.lareshomeworks.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCarRequest {
    private String brand;
    private String model;
    private Integer carYear;
    private String color;
    private Boolean used;
    private Double motor;
}
