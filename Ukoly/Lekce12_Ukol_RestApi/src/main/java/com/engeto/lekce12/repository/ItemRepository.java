package com.engeto.lekce12.repository;

import com.engeto.lekce12.entity.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {

    Optional<Item> findFirstByName(String name);
}