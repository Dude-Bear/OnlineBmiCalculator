package de.hsemden.onlinebmicalculator.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/***
 * The Measurement Domain Model class defines the attributes of a measurement.
 */
@Data
@Builder
public class MeasurementDomainModel {
    /**
     * The height in cm.
     */
    private int height;

    /**
     * The weight in kg.
     */
    private int weight;

    /**
     * The date of the measurement.
     */
    private LocalDate dateOfMeasurement;

    /**
     * The body mass index.
     */
    private double bmi;

    /**
     * The Nutritional status defined by the WHO.
     * Source: https://www.euro.who.int/en/health-topics/disease-prevention/nutrition/a-healthy-lifestyle/body-mass-index-bmi
     */
    private int nutritionalStatus;
}
