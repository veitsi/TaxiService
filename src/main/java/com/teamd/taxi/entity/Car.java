package com.teamd.taxi.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Slava on 21.04.2015.
 */
@Entity
public class Car {
    private long carId;
    private String model;
    private Driver driver;
    private Collection<Feature> features;
    private License licence;

    @Id
    @Column(name = "car_id")
    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (carId != car.carId) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (carId ^ (carId >>> 32));
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @ManyToMany
    @JoinTable(name = "feature_car_list", catalog = "taxiservice", schema = "taxi", joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "car_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "feature_id", referencedColumnName = "id", nullable = false))
    public Collection<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Collection<Feature> features) {
        this.features = features;
    }

    @OneToOne(mappedBy = "driver")
    public License getLicence() {
        return licence;
    }

    public void setLicence(License licence) {
        this.licence = licence;
    }
}
