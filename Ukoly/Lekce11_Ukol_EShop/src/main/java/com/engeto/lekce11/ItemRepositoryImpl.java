package com.engeto.lekce11;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

public class ItemRepositoryImpl implements ItemRepository{
    private EntityManager em;
    private Session session;

    public ItemRepositoryImpl(EntityManager em) {
        this.em = em;
        this.session = em.unwrap(Session.class);
    }

    public Item loadItemById(int id) {
        return em.find(Item.class, id);
    }

    @Transactional
    public void deleteAllOutOfStockItems() {
        org.hibernate.Transaction txn = session.beginTransaction();
        session.createNativeQuery("DELETE FROM `item` WHERE (`numberInStock` = 0);")
                .executeUpdate();
        txn.commit();
    }


    public List<Item> loadAllAvailableItems(){
        return em.createQuery("SELECT i FROM Item i WHERE i.numberInStock > 0")
                .getResultList();
    }

    @Transactional
    public void saveItem(Item item) {
        org.hibernate.Transaction txn = session.beginTransaction();
        session.persist(item);
        txn.commit();
    }

    @Transactional
    public void updatePrice(Integer id, BigDecimal newPrice) {
        org.hibernate.Transaction txn = session.beginTransaction();
        session.createQuery("update Item i set i.price = :price where i.id = :id")
                .setParameter("price", newPrice)
                .setParameter("id", id)
                .executeUpdate();
        txn.commit();
    }
}
