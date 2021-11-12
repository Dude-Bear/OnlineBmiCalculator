package de.hsemden.OnlineBmiCalculator.types;

public class NutritionalStatusConverter {
    public static int ToInteger(NutritionalStatus value) {
        return switch (value) {
            case UnderWeight -> 0;
            case NormalWeight -> 1;
            case PreObesity -> 2;
            case ObesityClassI -> 3;
            case ObesityClassII -> 4;
            case ObesityClassIII -> 5;
        };
    }

    public static NutritionalStatus ToNutritionalStatus(int value) {
        return switch (value) {
            case 0 -> NutritionalStatus.UnderWeight;
            case 1 -> NutritionalStatus.NormalWeight;
            case 2 -> NutritionalStatus.PreObesity;
            case 3 -> NutritionalStatus.ObesityClassI;
            case 4 -> NutritionalStatus.ObesityClassII;
            case 5 -> NutritionalStatus.ObesityClassIII;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }
}