package com.javatechie.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Endpoint(id = "release-notes")
public class CustomEndpoint {

/*
    String version10 = "Version 1.0\n"
            + "Home page created\n"
            + "Adding a new item form added\n"
            + "View the watchlist page added\n\n\n";

    String version11 = "** Version 1.1 \n\n"
            + "* Reading from OMDb API added \n"
            + "* Actuator endpoints added \n";
*/

    Map<String, List<String>> releaseNotesMap = new LinkedHashMap<>();

    @PostConstruct
    public void initNotes() {
        releaseNotesMap.put("version-1.0", Arrays.asList("Home page created", "Adding a new item form added", "View the watchlist page added"));
        releaseNotesMap.put("version-1.1", Arrays.asList("Reading from OMDb API added", "Actuator endpoints added"));
    }

    @WriteOperation
    public String addReleaseNotes(@Selector String version, String releaseNotes) {
        releaseNotesMap.put(version, Arrays.stream(releaseNotes.split(",")).collect(Collectors.toList()));
        return "releaseNotes added ...";
    }

    @ReadOperation
    public Map<String, List<String>> releaseNotes() {
        return releaseNotesMap;
    }

    @ReadOperation
    public List<String> selectReleaseNotes(@Selector String selector) {
        return releaseNotesMap.get(selector);
    }
}

