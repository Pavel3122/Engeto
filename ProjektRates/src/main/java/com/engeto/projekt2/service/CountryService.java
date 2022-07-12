package com.engeto.projekt2.service;

import com.engeto.projekt2.entity.Country;
import com.engeto.projekt2.repository.CountryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CountryService {
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    final CountryRepository countryRepository;

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElseThrow();
    }

    public Country getFirstCountryByNameShort(String nameShort) {
        return countryRepository.findFirstByNameShort(nameShort).orElseThrow();
    }

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public Iterable<Country> getAllCountries() {return countryRepository.findAll(); }

    @Transactional
    public void deleteCountryById(Long id) {countryRepository.deleteCountryById(id);}
}
