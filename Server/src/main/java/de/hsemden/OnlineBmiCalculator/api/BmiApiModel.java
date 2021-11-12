package de.hsemden.OnlineBmiCalculator.api;

import lombok.Data;

/***
 * The BMI api model class represents a BMI object with its attributes.
 */
@Data
public class BmiApiModel {
    /**
     * The height in cm.
     */
    private int height;

    /**
     * The weight in kg.
     */
    private int weight;

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
