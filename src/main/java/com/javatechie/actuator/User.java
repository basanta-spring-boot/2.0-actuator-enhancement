package com.javatechie.actuator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private int id;
    private String name;
    private String email;
    private String status;


}
