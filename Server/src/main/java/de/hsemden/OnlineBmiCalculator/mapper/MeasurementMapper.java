package de.hsemden.OnlineBmiCalculator.mapper;

import de.hsemden.OnlineBmiCalculator.domain.Measurement;
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
     * @param measurement api measurement object
     * @return domain measurement object
     */
    Measurement mapToDomain(de.hsemden.OnlineBmiCalculator.api.Measurement measurement);


    /**
     * Creates an api measurement object of the given domain measurement object.
     * @param measurement domain measurement object
     * @return api measurement object
     */
    de.hsemden.OnlineBmiCalculator.api.Measurement mapToApi(Measurement measurement);
}