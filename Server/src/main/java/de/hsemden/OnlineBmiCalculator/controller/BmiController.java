package de.hsemden.OnlineBmiCalculator.controller;

import de.hsemden.OnlineBmiCalculator.api.BmiApiModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class BmiController {

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
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
