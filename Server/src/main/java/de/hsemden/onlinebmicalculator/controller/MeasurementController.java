package de.hsemden.onlinebmicalculator.controller;

import de.hsemden.onlinebmicalculator.api.MeasurementApiModel;
import de.hsemden.onlinebmicalculator.mapper.MeasurementMapper;
import de.hsemden.onlinebmicalculator.service.measurement.MeasurementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/***
 * REST Controller for the measurement API.
 *
 * Offers the following REST Endpoints:
 * GET /measurement -> returns a json that includes the bmi and the nutritional status.
 */
@RestController
@RequestMapping(value = "measurement")
@Validated
public class MeasurementController {

    private final MeasurementService measurementService;
    private final MeasurementMapper measurementMapper;

    public MeasurementController(MeasurementService measurementService, MeasurementMapper measurementMapper) {
        this.measurementService = measurementService;
        this.measurementMapper = measurementMapper;
    }

    /**
     * Returns a measurement that includes the bmi.
     *
     * @param userId   user id
     * @param fromDate measurements in timespan from date
     * @param toDate   measurements in timespan to date
     * @return Calculation result
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<MeasurementApiModel>> getMeasurementList(@RequestParam("userId") long userId, @RequestParam("fromDate") LocalDate fromDate, @RequestParam("toDate") LocalDate toDate) {
        final var measurements = measurementService.getMeasurementList(userId, fromDate, toDate);
        final var measurementApiModels = measurements.stream().map(measurementMapper::mapToApi).toList();
        return new ResponseEntity<>(measurementApiModels, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createMeasurement(@RequestParam("userId") long userId, @RequestParam("measurement") MeasurementApiModel measurement) {
        final var measurementDomainModel = measurementMapper.mapToDomain(measurement);
        measurementService.createMeasurement(userId, measurementDomainModel);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
