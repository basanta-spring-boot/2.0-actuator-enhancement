package com.javatechie.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TotalUserInfoContributor implements InfoContributor {

    public static final String ACTIVE = "active";
    public static final String IN_ACTIVE = "inActive";
    @Autowired
    private UserDatabase dataBase;

    //same way you can get login status user
    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Long> userStatusMap = new HashMap<>();
        userStatusMap.put(ACTIVE, dataBase.getUserCountByStatus(ACTIVE));
        userStatusMap.put(IN_ACTIVE, dataBase.getUserCountByStatus(IN_ACTIVE));
        builder.withDetail("status", userStatusMap);
    }
}
