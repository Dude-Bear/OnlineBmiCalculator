package de.hsemden.onlinebmicalculator.controller;

import de.hsemden.onlinebmicalculator.api.MeasurementApiModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 * REST Controller for the measurement API.
 *
 * Offers the following REST Endpoints:
 * GET /measurement -> returns a json that includes the bmi and the nutritional status.
 */
@RestController
@RequestMapping(value = "measurement")
public class MeasurementController {

    /**
     * Returns a measurement that includes the bmi.
     *  TODO: Implementierung eines Servicesaufrufes.
     *
     * @param height Height in cm
     * @param weight Weight in kg
     * @return Calculation result
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<MeasurementApiModel> getMeasurement(@RequestParam("height") int height,
                                                              @RequestParam("weight") int weight) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
