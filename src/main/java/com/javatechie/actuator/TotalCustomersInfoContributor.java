package com.javatechie.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TotalCustomersInfoContributor implements InfoContributor {

    public static final String ACTIVE = "active";
    public static final String IN_ACTIVE = "inActive";
    @Autowired
    private EkartDataBase dataBase;

    //same way you can get login status user
    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Long> customerStatusMap = new HashMap<>();
        customerStatusMap.put(ACTIVE, dataBase.getStatusCount(ACTIVE));
        customerStatusMap.put(IN_ACTIVE, dataBase.getStatusCount(IN_ACTIVE));
        builder.withDetail("status", customerStatusMap);
    }
}
