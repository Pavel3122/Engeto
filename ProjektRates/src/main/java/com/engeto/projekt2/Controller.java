package com.engeto.projekt2;


import com.engeto.projekt2.entity.Country;
import com.engeto.projekt2.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    public Controller(CountryService countryService) {
        this.countryService = countryService;
    }

    final CountryService countryService;

    @GetMapping("/country/{id}")
    public Country getCountryById(@PathVariable Long id){
        return countryService.getCountryById(id);
    }

    @PostMapping("/saveCountry")
    public Country saveCountry(@RequestBody Country country) {
        countryService.saveCountry(country);
        return country;
    }

    @GetMapping("/countries")
    public Iterable<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/countriesLowestStandardRate")
    public List<Country> find3CountriesWithLowestStandardRates() {
        return countryService.find3CountriesWithLowestStandardRates();
    }

    @GetMapping("/countriesHighestStandardRate")
    public List<Country> find3CountriesWithHighestStandardRates() {
        return countryService.find3CountriesWithHighestStandardRates();
    }

    @DeleteMapping("/country/{id}")
    public void deleteCountryById(@PathVariable Long id) {
        countryService.deleteCountryById(id);
    }
}
