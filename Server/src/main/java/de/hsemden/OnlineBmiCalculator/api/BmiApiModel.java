package de.hsemden.OnlineBmiCalculator.api;

import de.hsemden.OnlineBmiCalculator.types.NutritionalStatus;
import de.hsemden.OnlineBmiCalculator.types.NutritionalStatusConverter;
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
