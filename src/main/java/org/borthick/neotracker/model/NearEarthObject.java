package org.borthick.neotracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "near_earth_object")
public class NearEarthObject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(31)")
    private String name;
    @Column(name = "kilo_diam_max", columnDefinition = "NUMERIC(13,10)")
    private BigDecimal kiloDiamMax;
    @Column(name = "kilo_diam_min", columnDefinition = "NUMERIC(13,10)")
    private BigDecimal kiloDiamMin;
    @Column(name = "feet_diam_max", columnDefinition = "NUMERIC(17,10)")
    private BigDecimal feetDiamMax;
    @Column(name = "feet_diam_min", columnDefinition = "NUMERIC(17,10)")
    private BigDecimal feetDiamMin;
    @Column(name = "is_hazard", columnDefinition = "BOOLEAN")
    private Boolean isHazard;
    @Column(name = "close_approach_date", columnDefinition = "TIMESTAMP")
    private Timestamp closeApproachDate;
    @Column(name = "kilometers_per_second", columnDefinition = "NUMERIC(13,10)")
    private BigDecimal kilometersPerSecond;
    @Column(name = "miles_per_hour", columnDefinition = "NUMERIC(17,10)")
    private BigDecimal milesPerHour;
    @Column(name = "kilo_miss_dist", columnDefinition = "NUMERIC(20,10)")
    private BigDecimal kiloMissDist;
    @Column(name = "miles_miss_dist", columnDefinition = "NUMERIC(20,10)")
    private BigDecimal milesMissDist;
    @Column(name = "orbiting", columnDefinition = "VARCHAR(31)")
    private String orbiting;
    @Column(name = "is_sentry", columnDefinition = "BOOLEAN")
    private Boolean isSentry;
}
