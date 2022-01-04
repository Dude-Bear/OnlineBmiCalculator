package de.hsemden.onlinebmicalculator.service.measurement;

import de.hsemden.onlinebmicalculator.domain.MeasurementDomainModel;

import java.time.LocalDate;
import java.util.List;

public interface MeasurementService {
    /**
     * Speichert einen neuen Messwert.
     *
     * @param userId Identität des Benutzers
     * @param measurement der zu speichernde Messwert
     */
    void createMeasurement(long userId, MeasurementDomainModel measurement);

    /**
     * Gibt eine Liste aller Messwerte für einen bestimmten Benutzer
     * in einem bestimmten Zeitraum zurück.
     *
     * @param userId Benutzeridentität
     * @param fromDate Start-Datum
     * @param toDate End-Datum
     * @return List alle Messwerte
     */
    List<MeasurementDomainModel> getMeasurementList(long userId, LocalDate fromDate, LocalDate toDate);
}