package com.engeto.projekt2;


import com.engeto.projekt2.entity.Country;
import com.engeto.projekt2.service.CountryService;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/country/{id}")
    public void deleteCountryById(@PathVariable Long id) {
        countryService.deleteCountryById(id);
    }
}
