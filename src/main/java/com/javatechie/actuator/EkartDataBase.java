package com.javatechie.actuator;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Repository
public class EkartDataBase {


    public  List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725"),"active"),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947"),"inActive"),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236"),"active"),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"),"active")
        ).collect(Collectors.toList());
    }

    public long getStatusCount(String status){
        return getAll().stream().filter(customer -> customer.getStatus().equals(status)).count();
    }

}
