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
	void calculateBmi_height190_weight88() {
		var measurement = bmiController.getMeasurement(190, 88);
		var statusCode = measurement.getStatusCode();
		assertThat(statusCode).isEqualTo(HttpStatus.OK);

		var body = measurement.getBody();
		assertThat(body).isNotNull();
		assertThat(body.getBmi()).isEqualTo(24.37673130193906);
		assertThat(body.getNutritionalStatus()).isEqualTo(1);
	}

	@Test
	void calculateBmi_height160_weight101() {
		var measurement = bmiController.getMeasurement(160, 101);
		var statusCode = measurement.getStatusCode();
		assertThat(statusCode).isEqualTo(HttpStatus.OK);

		var body = measurement.getBody();
		assertThat(body).isNotNull();
		assertThat(body.getBmi()).isEqualTo(39.453125);
		assertThat(body.getNutritionalStatus()).isEqualTo(4);
	}
}
