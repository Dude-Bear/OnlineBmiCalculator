package de.hsemden.onlinebmicalculator.api;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

/***
 * The measurement api model class represents a measurement with its base attributes.
 */
@Data
@Builder
public class MeasurementApiModel {
    /**
     * The height in cm.
     */
    @NotNull
    @Positive
    @Min(30)
    @Max(300)
    private int height;

    /**
     * The weight in kg.
     */
    @NotNull
    @Positive
    @Min(10)
    @Max(1000)
    private int weight;

    /**
     * The date of the measurement.
     */
    private LocalDate dateOfMeasurement;

    /**
     * The body mass index.
     */
    @NotNull
    @Positive
    @Min(5)
    @Max(500)
    private double bmi;

    /**
     * The Nutritional status defined by the WHO.
     * Source: https://www.euro.who.int/en/health-topics/disease-prevention/nutrition/a-healthy-lifestyle/body-mass-index-bmi
     */
    @NotNull
    @Positive
    @Min(1)
    @Max(5)
    private int nutritionalStatus;
}
