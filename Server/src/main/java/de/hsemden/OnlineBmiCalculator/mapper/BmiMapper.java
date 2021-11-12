package de.hsemden.OnlineBmiCalculator.mapper;

import de.hsemden.OnlineBmiCalculator.api.BmiApiModel;
import de.hsemden.OnlineBmiCalculator.domain.BmiDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface BmiMapper {

    /**
     * Creates a domain bmi object of the given api bmi object.
     * @param bmiApiModel api measurement object
     * @return bmi object
     */
    BmiDomainModel mapToDomain(BmiApiModel bmiApiModel);


    /**
     * Creates an api bmi object of the given domain bmi object.
     * @param bmiDomainModel domain measurement object
     * @return bmi object
     */
    BmiApiModel mapToApi(BmiDomainModel bmiDomainModel);
}
