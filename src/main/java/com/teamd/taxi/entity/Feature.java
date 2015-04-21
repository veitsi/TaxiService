package com.teamd.taxi.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Slava on 21.04.2015.
 */
@Entity
public class Feature {
    private long id;
    private String name;
    private float price;
    private Collection<Car> cars;
    private Collection<Driver> drivers;
    private Collection<TaxiOrder> orders;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feature feature = (Feature) o;

        if (id != feature.id) return false;
        if (Float.compare(feature.price, price) != 0) return false;
        if (name != null ? !name.equals(feature.name) : feature.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        return result;
    }

    @ManyToMany(mappedBy = "features")
    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }

    @ManyToMany(mappedBy = "features")
    public Collection<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Collection<Driver> drivers) {
        this.drivers = drivers;
    }

    @ManyToMany(mappedBy = "features")
    public Collection<TaxiOrder> getOrders() {
        return orders;
    }

    public void setOrders(Collection<TaxiOrder> orders) {
        this.orders = orders;
    }
}
