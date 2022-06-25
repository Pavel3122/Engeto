package com.engeto.lekce12.repository;

import com.engeto.lekce12.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    Optional<Item> findFirstByName(String name);

    Iterable<Item> findAll();

    void deleteItemById(Long id);
}