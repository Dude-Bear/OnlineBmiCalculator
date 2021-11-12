package de.hsemden.OnlineBmiCalculator.controller;

import de.hsemden.OnlineBmiCalculator.api.BmiApiModel;
import de.hsemden.OnlineBmiCalculator.mapper.BmiMapper;
import de.hsemden.OnlineBmiCalculator.service.BmiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
 * REST Controller for the measurement API.
 *
 * Offers the following REST Endpoints:
 * GET /measurement -> returns a json that includes the bmi and the nutritional status.
 */
@RestController
@RequestMapping(value="bmi")
@Validated
@RequiredArgsConstructor
public class BmiController {

    /**
     * Der BmiService wird für die Verwaltung von BMI-Informationen verwendet.
     *
     * Er wird mittels Spring Dependency Injection (konstruktorbasiert) initialisiert. Der Konstruktor wird
     * mittels "@RequiredArgsConstructor" Annotation für alle als "final" deklarierten Attribute erstellt.
     * Die Spring DI sucht nach einer Spring Komponente (Service), die dieses Interface implementiert und
     * übernimmt die Initialisierung.
     */
    private final BmiService bmiService;

    /**
     * Mapper Interface für das Mapping zwischen API und Domain Klassen.
     */
    private final BmiMapper bmiMapper;

    /**
     * Returns a json object that includes the bmi.
     *  TODO: Implementierung eines Servicesaufrufes.
     *
     * @param height Height in cm
     * @param weight Weight in kg
     * @return Calculation result
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<BmiApiModel> getMeasurement(@RequestParam("height") int height,
                                                      @RequestParam("weight") int weight) {
        final de.hsemden.OnlineBmiCalculator.domain.BmiDomainModel bmiDomainModel = bmiService.getBmi(height, weight);
        final BmiApiModel bmiApiModel = bmiMapper.mapToApi(bmiDomainModel);
        return new ResponseEntity<>(bmiApiModel,HttpStatus.OK);
    }
}
