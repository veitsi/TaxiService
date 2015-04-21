package com.teamd.taxi.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Slava on 21.04.2015.
 */
@Entity
public class Driver {
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String driverPassword;
    private Car car;
    private Collection<Route> routes;
    private Collection<Feature> features;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "driver_password")
    public String getDriverPassword() {
        return driverPassword;
    }

    public void setDriverPassword(String driverPassword) {
        this.driverPassword = driverPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (id != driver.id) return false;
        if (email != null ? !email.equals(driver.email) : driver.email != null) return false;
        if (firstName != null ? !firstName.equals(driver.firstName) : driver.firstName != null) return false;
        if (lastName != null ? !lastName.equals(driver.lastName) : driver.lastName != null) return false;
        if (driverPassword != null ? !driverPassword.equals(driver.driverPassword) : driver.driverPassword != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (driverPassword != null ? driverPassword.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "driver")
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @OneToMany(mappedBy = "driver")
    public Collection<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Collection<Route> routes) {
        this.routes = routes;
    }

    @ManyToMany
    @JoinTable(name = "feature_driver_list", catalog = "taxiservice", schema = "taxi", joinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = false))
    public Collection<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Collection<Feature> features) {
        this.features = features;
    }
}
