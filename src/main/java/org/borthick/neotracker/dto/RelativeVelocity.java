package org.borthick.neotracker.dto;

import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "kilometers_per_second",
        "miles_per_hour"
})
public class RelativeVelocity implements Serializable
{

    @JsonProperty("kilometers_per_second")
    private String kilometersPerSecond;
    @JsonProperty("miles_per_hour")
    private String milesPerHour;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    private final static long serialVersionUID = -4607853683715694934L;

    /**
     * No args constructor for use in serialization
     *
     */
    public RelativeVelocity() {
    }

    public RelativeVelocity(String kilometersPerSecond, String milesPerHour) {
        super();
        this.kilometersPerSecond = kilometersPerSecond;
        this.milesPerHour = milesPerHour;
    }

    @JsonProperty("kilometers_per_second")
    public String getKilometersPerSecond() {
        return kilometersPerSecond;
    }

    @JsonProperty("kilometers_per_second")
    public void setKilometersPerSecond(String kilometersPerSecond) {
        this.kilometersPerSecond = kilometersPerSecond;
    }

    @JsonProperty("miles_per_hour")
    public String getMilesPerHour() {
        return milesPerHour;
    }

    @JsonProperty("miles_per_hour")
    public void setMilesPerHour(String milesPerHour) {
        this.milesPerHour = milesPerHour;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
