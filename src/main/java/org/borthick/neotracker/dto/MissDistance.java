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
        "miles"
})
public class MissDistance implements Serializable
{

    @JsonProperty("kilometers")
    private String kilometers;
    @JsonProperty("miles")
    private String miles;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    private final static long serialVersionUID = -7306346204982640150L;

    /**
     * No args constructor for use in serialization
     *
     */
    public MissDistance() {
    }

    public MissDistance(String kilometers, String miles) {
        super();
        this.kilometers = kilometers;
        this.miles = miles;
    }

    @JsonProperty("kilometers")
    public String getKilometers() {
        return kilometers;
    }

    @JsonProperty("kilometers")
    public void setKilometers(String kilometers) {
        this.kilometers = kilometers;
    }

    @JsonProperty("miles")
    public String getMiles() {
        return miles;
    }

    @JsonProperty("miles")
    public void setMiles(String miles) {
        this.miles = miles;
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