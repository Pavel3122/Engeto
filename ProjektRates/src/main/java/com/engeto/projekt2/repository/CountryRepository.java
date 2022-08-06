package com.engeto.projekt2.repository;

import com.engeto.projekt2.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findFirstByNameShort(String nameShort);

    List<Country> findAll();

    List<Country> findTop3ByOrderByStandardRateDesc();

    List<Country> findTop3ByOrderByStandardRateAsc();

    void deleteCountryById(Long id);
}
