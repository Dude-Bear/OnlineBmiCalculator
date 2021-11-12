package de.hsemden.OnlineBmiCalculator.api;

import lombok.Data;

import java.time.LocalDate;

/***
 * The measurement api model class represents a measurement with its base attributes.
 */
@Data
public class MeasurementApiModel {
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
