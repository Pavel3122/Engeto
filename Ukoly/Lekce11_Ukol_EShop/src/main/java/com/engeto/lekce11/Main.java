package com.engeto.lekce11;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    static Item itemObj;

    public static void main(String[] args) {
        System.out.println(".......App Start.......\n");

        // Create Entity Manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.engeto.lekce11.eshop");
        EntityManager em = emf.createEntityManager();

        ItemRepositoryImpl itemRepositoryImpl = new ItemRepositoryImpl(em);

        // Load Item by Id
        Item item = itemRepositoryImpl.loadItemById(3);
        System.out.println(item.getName());

        // Delete All Out of Stock Items
        itemRepositoryImpl.deleteAllOutOfStockItems();

        // Load All Available Items
        List<Item> itemList = itemRepositoryImpl.loadAllAvailableItems();
        for (Item listItem : itemList) {
            System.out.println("List Item:" + listItem.getId());
        }

        // Save Item
        itemObj = new Item();
        itemObj.setName("Test Item3");
        itemRepositoryImpl.saveItem(itemObj);
        System.out.println("Item " + itemObj.getName() + " saved");

        // Update Price
        itemRepositoryImpl.updatePrice(3, BigDecimal.valueOf(40));
        System.out.println("Item price updated");
    }
}
