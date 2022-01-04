package de.hsemden.onlinebmicalculator.service.measurement;

import de.hsemden.onlinebmicalculator.domain.MeasurementDomainModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Die MeasurementServiceImpl Service Klasse implementiert das MeasurementService Interface. Sie stellt damit Methoden zur
 * Verwaltung von Messpunktinformationen zur Verfügung.<br><br>
 * <p>
 * Die @Service Annotation deklariert diese Klasse als Spring Komponente (Bean). Die Initialisierung kann
 * somit mittels der Spring Dependency Injection erfolgen.
 *
 * @see <a href="https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/using-spring-boot.html#using-boot-spring-beans-and-dependency-injection">Spring Dependency Injection und Services</a>
 */

@Service
public class MeasurementServiceImpl implements MeasurementService {
    @Override
    public void createMeasurement(long userId, MeasurementDomainModel measurement) {
        // TODO: Implementierung dieser Methode, inkl. Datenbankzugriff
    }

    @Override
    public List<MeasurementDomainModel> getMeasurementList(long userId, LocalDate fromDate, LocalDate toDate) {
        // TODO: Implementierung dieser Methode, inkl. Datenbankzugriff

        // Vorübergehende Rückgabe statischer Werte (Mocks) zu Testzwecken
        return Arrays.asList(
                MeasurementDomainModel.builder().dateOfMeasurement(LocalDate.parse("1.1.1999")).bmi(24).height(190).weight(120).build(),
                MeasurementDomainModel.builder().dateOfMeasurement(LocalDate.parse("1.2.1999")).bmi(25).height(190).weight(130).build(),
                MeasurementDomainModel.builder().dateOfMeasurement(LocalDate.parse("1.3.1999")).bmi(26).height(190).weight(140).build(),
                MeasurementDomainModel.builder().dateOfMeasurement(LocalDate.parse("1.4.1999")).bmi(27).height(190).weight(150).build()
        );
    }
}
