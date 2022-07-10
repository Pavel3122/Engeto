package com.engeto.projekt2.repository;

import com.engeto.projekt2.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    void deleteCountryById(Long id);
}
