package com.engeto.lekce12.service;

import com.engeto.lekce12.entity.Item;

import com.engeto.lekce12.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    final ItemRepository itemRepository;

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow();
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
}
