package de.hsemden.OnlineBmiCalculator.service;

import de.hsemden.OnlineBmiCalculator.domain.BmiDomainModel;
import de.hsemden.OnlineBmiCalculator.mapper.BmiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BmiService {

    /**
     * Interface für das Mapping zwischen Domain und Entity Model Klassen.
     */
    private final BmiMapper bmiMapper;


    public BmiDomainModel getBmi(int height, int weight) {
        return new BmiDomainModel(height, weight);
    }
}
