package com.engeto.projekt2.repository;

import com.engeto.projekt2.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
    Optional<Country> findFirstByNameShort(String nameShort);

    Iterable<Country> findAll();

    void deleteCountryById(Long id);
}
