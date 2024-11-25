package com.zekademirli.lareshomeworks.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCustomerRequest {
    private String firstName;
    private String lastName;
    private Integer age;
}
