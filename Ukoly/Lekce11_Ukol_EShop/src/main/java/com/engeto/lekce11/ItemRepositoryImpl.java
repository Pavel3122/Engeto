package com.engeto.lekce11;


import javax.persistence.EntityManager;

public class ItemRepositoryImpl implements ItemRepository{
    private EntityManager em;

    public ItemRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Item loadItemById(int id){
        return em.find(Item.class, id);
    }
}
