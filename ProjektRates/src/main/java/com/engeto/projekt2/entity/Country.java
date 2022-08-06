package com.engeto.projekt2.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Comparator;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nameShort;

    @Column
    private String nameLong;

    @Column
    private String comment;

    @Column
    private String isoDuplicateOf;

    @Column
    private BigDecimal standardRate;

    @Column
    private BigDecimal reducedRate;

    @Column
    private BigDecimal reducedRateAlt;

    @Column
    private BigDecimal superReducedRate;

    @Column
    private BigDecimal parkingRate;

    public Country(){
    }

    public Country(String nameShort, String nameLong, String comment, String isoDuplicateOf, BigDecimal standardRate, BigDecimal reducedRate, BigDecimal reducedRateAlt, BigDecimal superReducedRate, BigDecimal parkingRate) {
        this.nameShort = nameShort;
        this.nameLong = nameLong;
        this.comment = comment;
        this.isoDuplicateOf = isoDuplicateOf;
        this.standardRate = standardRate;
        this.reducedRate = reducedRate;
        this.reducedRateAlt = reducedRateAlt;
        this.superReducedRate = superReducedRate;
        this.parkingRate = parkingRate;
    }

    public static Comparator<Country> StandardRateComparator = new Comparator<Country>() {

        public int compare(Country c1, Country c2) {
            BigDecimal countryStandardRate1 = c1.getStandardRate();
            BigDecimal countryStandardRate2 = c2.getStandardRate();

            //ascending order
            return countryStandardRate1.compareTo(countryStandardRate2);
            //descending order
            //return countryStandardRate2.compareTo(countryStandardRate1);
        }};

    public Long getId() {
        return id;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getNameLong() {
        return nameLong;
    }

    public void setNameLong(String nameLong) {
        this.nameLong = nameLong;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIsoDuplicateOf() {
        return isoDuplicateOf;
    }

    public void setIsoDuplicateOf(String isoDuplicateOf) {
        this.isoDuplicateOf = isoDuplicateOf;
    }

    public BigDecimal getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(BigDecimal standardRate) {
        this.standardRate = standardRate;
    }

    public BigDecimal getReducedRate() {
        return reducedRate;
    }

    public void setReducedRate(BigDecimal reducedRate) {
        this.reducedRate = reducedRate;
    }

    public BigDecimal getReducedRateAlt() {
        return reducedRateAlt;
    }

    public void setReducedRateAlt(BigDecimal reducedRateAlt) {
        this.reducedRateAlt = reducedRateAlt;
    }

    public BigDecimal getSuperReducedRate() {
        return superReducedRate;
    }

    public void setSuperReducedRate(BigDecimal superReducedRate) {
        this.superReducedRate = superReducedRate;
    }

    public BigDecimal getParkingRate() {
        return parkingRate;
    }

    public void setParkingRate(BigDecimal parkingRate) {
        this.parkingRate = parkingRate;
    }
}
