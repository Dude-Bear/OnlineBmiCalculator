package de.hsemden.OnlineBmiCalculator.domain;

import lombok.Builder;
import lombok.Data;

/***
 * The BMI Domain Model class containes the attributes for the BMI calculation.
 */
@Data
@Builder
public class BmiDomainModel {
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
