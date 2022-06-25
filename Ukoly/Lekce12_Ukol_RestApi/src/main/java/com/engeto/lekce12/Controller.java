package com.engeto.lekce12;

import com.engeto.lekce12.entity.Item;
import com.engeto.lekce12.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v2")
public class Controller {

    public Controller(ItemService itemService) {
        this.itemService = itemService;
    }

    final ItemService itemService;

    @GetMapping("/item/{id}")
    public Item getItemById(@PathVariable Long id){
        return itemService.getItemById(id);
    }

    @PostMapping("/items")
    public Item saveItem(@RequestBody Item item) {
        itemService.saveItem(item);
        return item;
    }

    @GetMapping("/items")
    public Iterable<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @DeleteMapping("/item/{id}")
    public void deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
    }
}
