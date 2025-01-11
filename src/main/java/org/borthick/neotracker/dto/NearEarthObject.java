package org.borthick.neotracker.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "estimated_diameter",
        "is_potentially_hazardous_asteroid",
        "close_approach_data",
        "is_sentry_object"
})
public class NearEarthObject implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("estimated_diameter")
    private EstimatedDiameter estimatedDiameter;
    @JsonProperty("is_potentially_hazardous_asteroid")
    private Boolean isPotentiallyHazardousAsteroid;
    @JsonProperty("close_approach_data")
    private List<CloseApproachDatum> closeApproachData;
    @JsonProperty("is_sentry_object")
    private Boolean isSentryObject;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();
    private final static long serialVersionUID = -1936826518135341419L;

    /**
     * No args constructor for use in serialization
     *
     */
    public NearEarthObject() {
    }

    public NearEarthObject(String id, String name, EstimatedDiameter estimatedDiameter, Boolean isPotentiallyHazardousAsteroid, List<CloseApproachDatum> closeApproachData, Boolean isSentryObject) {
        super();
        this.id = id;
        this.name = name;
        this.estimatedDiameter = estimatedDiameter;
        this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
        this.closeApproachData = closeApproachData;
        this.isSentryObject = isSentryObject;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("estimated_diameter")
    public EstimatedDiameter getEstimatedDiameter() {
        return estimatedDiameter;
    }

    @JsonProperty("estimated_diameter")
    public void setEstimatedDiameter(EstimatedDiameter estimatedDiameter) {
        this.estimatedDiameter = estimatedDiameter;
    }

    @JsonProperty("is_potentially_hazardous_asteroid")
    public Boolean getIsPotentiallyHazardousAsteroid() {
        return isPotentiallyHazardousAsteroid;
    }

    @JsonProperty("is_potentially_hazardous_asteroid")
    public void setIsPotentiallyHazardousAsteroid(Boolean isPotentiallyHazardousAsteroid) {
        this.isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid;
    }

    @JsonProperty("close_approach_data")
    public List<CloseApproachDatum> getCloseApproachData() {
        return closeApproachData;
    }

    @JsonProperty("close_approach_data")
    public void setCloseApproachData(List<CloseApproachDatum> closeApproachData) {
        this.closeApproachData = closeApproachData;
    }

    @JsonProperty("is_sentry_object")
    public Boolean getIsSentryObject() {
        return isSentryObject;
    }

    @JsonProperty("is_sentry_object")
    public void setIsSentryObject(Boolean isSentryObject) {
        this.isSentryObject = isSentryObject;
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