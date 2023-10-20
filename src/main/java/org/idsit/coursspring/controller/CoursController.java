package org.idsit.coursspring.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class CoursController {

    @GetMapping
    public String sendHello(){
        return "Hello world";
    }

    @PostMapping(consumes = "text/plain")
    public String receiveHello(@RequestBody String welcomeMsg) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(welcomeMsg);

        // When
        JsonNode jsonNode1 = actualObj.get("mee");
        return "I received your msg " + jsonNode1.asText();
    }

}
