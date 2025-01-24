package org.borthick.neotracker.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.borthick.neotracker.model.NearEarthObject;

import java.util.List;

public interface NeoTrackerService {

    List<NearEarthObject> processResponse(String response) throws JsonProcessingException;
}
