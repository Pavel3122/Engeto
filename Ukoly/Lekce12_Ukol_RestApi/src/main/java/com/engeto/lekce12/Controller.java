package com.engeto.lekce12;

import com.engeto.lekce12.entity.Item;
import com.engeto.lekce12.service.ItemService;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/hello")
//    public String helloWord(){
//        return "Hello";
//    }
//
//    @GetMapping("/createItem")
//    public Item createItem(@RequestParam String name, @RequestParam String description){
//        Item item = new Item(name, description);
//        return item;
//    }

//    @GetMapping("/item/{id}")
//    public Item getItemById(@PathVariable String id){
//        Map<String, Item> zakladDb= new HashMap<>();
//        Item item = new Item("Sofa", "Zelene barvy");
//        Item item2 = new Item("Sofa", "Cervene barvy");
//        zakladDb.put("1", item);
//        zakladDb.put("2", item2);
//
//        return zakladDb.get(id);
//    }
}
