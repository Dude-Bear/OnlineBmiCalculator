package de.hsemden.onlinebmicalculator;

import de.hsemden.onlinebmicalculator.controller.BmiController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BmiControllerTests {

	@Autowired
	private BmiController bmiController;

	@Test
	void contextLoads() {
		assertThat(bmiController).isNotNull();
	}

	@Test
	void calculateBmi() {
		var measurement = bmiController.getMeasurement(190, 88);
		var statusCode = measurement.getStatusCode();
		assertThat(statusCode).isEqualTo(HttpStatus.OK);

		var body = measurement.getBody();
		assertThat(body).isNotNull();
		var bmi = body.getBmi();
		assertThat(bmi).isEqualTo(24.37673130193906);
	}
}
