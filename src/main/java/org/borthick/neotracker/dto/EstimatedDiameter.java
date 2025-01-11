package org.borthick.neotracker.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "kilometers",
        "feet"
})
public class EstimatedDiameter implements Serializable
{

    @JsonProperty("kilometers")
    private Kilometers kilometers;
    @JsonProperty("feet")
    private Feet feet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    private final static long serialVersionUID = 3703750979776321978L;

    /**
     * No args constructor for use in serialization
     *
     */
    public EstimatedDiameter() {
    }

    public EstimatedDiameter(Kilometers kilometers, Feet feet) {
        super();
        this.kilometers = kilometers;
        this.feet = feet;
    }

    @JsonProperty("kilometers")
    public Kilometers getKilometers() {
        return kilometers;
    }

    @JsonProperty("kilometers")
    public void setKilometers(Kilometers kilometers) {
        this.kilometers = kilometers;
    }

    @JsonProperty("feet")
    public Feet getFeet() {
        return feet;
    }

    @JsonProperty("feet")
    public void setFeet(Feet feet) {
        this.feet = feet;
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