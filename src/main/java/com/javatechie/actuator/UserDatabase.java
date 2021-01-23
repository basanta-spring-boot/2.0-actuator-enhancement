package com.javatechie.actuator;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Repository
public class UserDatabase {


    public  List<User> getAll() {
        return Stream.of(
                new User(101, "john", "john@gmail.com","active"),
                new User(102, "smith", "smith@gmail.com","inActive"),
                new User(103, "peter", "peter@gmail.com", "active"),
                new User(104, "kely", "kely@gmail.com","active")
        ).collect(Collectors.toList());
    }

    public long getUserCountByStatus(String status){
        return getAll().stream().filter(customer -> customer.getStatus().equals(status)).count();
    }

}
