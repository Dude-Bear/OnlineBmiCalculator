package de.hsemden.onlinebmicalculator;

import de.hsemden.onlinebmicalculator.controller.MeasurementController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MeasurementControllerTests {

	@Autowired
	private MeasurementController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	void calculateBmi() {
		var measurement = controller.getMeasurementList(1, LocalDate.MIN, LocalDate.MAX);
		var statusCode = measurement.getStatusCode();
		assertThat(statusCode).isEqualTo(HttpStatus.OK);

		var body = measurement.getBody();
		assertThat(body).isNotNull();

		assertThat(body.size()).isEqualTo(4);
	}
}
