package com.zekademirli.lareshomeworks.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {

    private String firstName;
    private String lastName;
    private Integer age;
}
