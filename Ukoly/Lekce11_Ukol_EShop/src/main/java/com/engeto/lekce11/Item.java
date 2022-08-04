package com.engeto.lekce11;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;

    @Column
    private String partNo;
    @Column
    private String serialNo;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Integer numberInStock;
    @Column
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberInStock() {
        return numberInStock;
    }

    public void setNumberInStock(Integer numberInStock) {
        this.numberInStock = numberInStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
