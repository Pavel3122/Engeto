package com.engeto.projekt2.service;

import com.engeto.projekt2.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    final CountryRepository countryRepository;
}
