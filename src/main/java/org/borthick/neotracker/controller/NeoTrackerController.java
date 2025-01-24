package org.borthick.neotracker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.borthick.neotracker.model.NearEarthObject;
import org.borthick.neotracker.service.NeoTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class NeoTrackerController {
    private final NeoTrackerService service;

    @Autowired
    public NeoTrackerController(NeoTrackerService service) {
        this.service = service;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping(value = "/nearEarthObject", consumes = "application/json")
    public ResponseEntity<List<NearEarthObject>> saveObject(@RequestBody ObjectNode body)
            throws JsonProcessingException {
        String start = body.get("start").asText();
        String end = body.get("end").asText();
        RestTemplate template = new RestTemplate();
        String response = template
                .getForObject("https://api.nasa.gov/neo/rest/v1/feed?start_date="
                              + start + "&end_date=" + end
                              + "&api_key=ANm0BgYeUvyxpSoKHEFxU41pLBYh3UtNr6cXpu7V", String.class);
        List<NearEarthObject> objects = service.processResponse(response);
        System.out.println(objects.getFirst());
        return ResponseEntity.ok(objects);
    }
}
