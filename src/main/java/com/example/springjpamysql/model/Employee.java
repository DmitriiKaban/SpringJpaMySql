package com.example.springjpamysql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// annotations generate getters/setters
@Setter
@Getter
@ToString
public class Employee {
    //@JsonProperty("full_name") // changed name, inside the model class it will be name
    private String name;

    // hiding info in http request
    //@JsonIgnore // will not return in json, age is safe
    private Long age;
    private String location;
    private String email;
    private String department;

}
