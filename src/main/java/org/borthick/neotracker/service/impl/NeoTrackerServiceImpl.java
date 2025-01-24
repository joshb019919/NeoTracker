package org.borthick.neotracker.service.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.borthick.neotracker.model.NearEarthObject;
import org.borthick.neotracker.service.NeoTrackerService;
import org.borthick.neotracker.util.NeoDeserializer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeoTrackerServiceImpl implements NeoTrackerService {

    public List<NearEarthObject> processResponse(String response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(JsonParser.Feature.INCLUDE_SOURCE_IN_LOCATION);
        SimpleModule module = new SimpleModule("NeoDeserializer");
        module.addDeserializer(List.class, new NeoDeserializer());
        mapper.registerModule(module);
        return mapper.readValue(response, new TypeReference<>() {});
    }
}
