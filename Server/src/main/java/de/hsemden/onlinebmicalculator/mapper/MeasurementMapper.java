package de.hsemden.onlinebmicalculator.mapper;

import de.hsemden.onlinebmicalculator.api.MeasurementApiModel;
import de.hsemden.onlinebmicalculator.domain.MeasurementDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

/***
 * Mapper Interface for mapping between Measurement API and Domain Model classes.
 *
 * This interface uses the mapstruct library. When you compile an application, the implementation will be generated.
 * Attributes with the same name are automatically assigned. All further mappings are defined using @Mapping Annotation.
 * Since the Spring Component Model is used, a mapper interface can be created via Spring Dependency Injection
 * in any Spring component.
 * "https://mapstruct.org/documentation/stable/reference/html/" MapStruct documentation
 */
@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface MeasurementMapper {


    /**
     * Creates a domain measurement object of the given api measurement object.
     * @param measurementApiModel api measurement object
     * @return domain measurement object
     */
    MeasurementDomainModel mapToDomain(MeasurementApiModel measurementApiModel);


    /**
     * Creates an api measurement object of the given domain measurement object.
     * @param measurementDomainModel domain measurement object
     * @return api measurement object
     */
    MeasurementApiModel mapToApi(MeasurementDomainModel measurementDomainModel);
}
