package de.hsemden.onlinebmicalculator.api;

import de.hsemden.onlinebmicalculator.types.NutritionalStatus;
import de.hsemden.onlinebmicalculator.types.NutritionalStatusConverter;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/***
 * The BMI api model class represents a BMI object with its attributes.
 */
@Data
public class BmiApiModel {
    /**
     * The height in cm.
     */
    @NotNull
    @Positive
    @Min(10)
    @Max(500)
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

    /**
     * A constructor for the BMI API model.
     * Only to parameters are needed, the others will be calculated.
     *
     * @param height - the height in cm
     * @param weight - the weight in kg
     */
    public BmiApiModel(int height, int weight) {
        this.height = height;
        this.weight = weight;
        this.bmi = calculateBodyMassIndex();
        this.nutritionalStatus = NutritionalStatusConverter.ToInteger(calculateNutritionalStatus());
    }

    /**
     * Calculates a nutritional status which is based on the WHO.
     * Source: https://www.euro.who.int/en/health-topics/disease-prevention/nutrition/a-healthy-lifestyle/body-mass-index-bmi
     * @return The Nutritional status defined by the WHO.
     */
    private NutritionalStatus calculateNutritionalStatus() {
        if (bmi < 18.5) {
            return NutritionalStatus.UnderWeight;
        } else if (bmi <= 24.9) {
            return NutritionalStatus.NormalWeight;
        } else if (bmi <= 29.9) {
            return NutritionalStatus.PreObesity;
        } else if (bmi <= 34.9) {
            return NutritionalStatus.ObesityClassI;
        } else if (bmi <= 39.9) {
            return NutritionalStatus.ObesityClassII;
        } else {
            return NutritionalStatus.ObesityClassIII;
        }
    }

    /***
     * Calculates the BMI out of the height and weight.
     *
     * @return the BMI
     */
    private double calculateBodyMassIndex() {
        return (double) weight / ((double) height * (double) height) * 10000; /* * 10000 to turn cm into m*/
    }

}
