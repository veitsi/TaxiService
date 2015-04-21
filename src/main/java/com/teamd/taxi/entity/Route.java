package com.teamd.taxi.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by Slava on 21.04.2015.
 */
@Entity
public class Route {
    private long id;
    private String sourceAdd;
    private String destAdd;
    private Time timeOfTrip;
    private String status;
    private Driver driver;
    private TaxiOrder taxiOrder;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "source_add")
    public String getSourceAdd() {
        return sourceAdd;
    }

    public void setSourceAdd(String sourceAdd) {
        this.sourceAdd = sourceAdd;
    }

    @Basic
    @Column(name = "dest_add")
    public String getDestAdd() {
        return destAdd;
    }

    public void setDestAdd(String destAdd) {
        this.destAdd = destAdd;
    }

    @Basic
    @Column(name = "time_of_trip")
    public Time getTimeOfTrip() {
        return timeOfTrip;
    }

    public void setTimeOfTrip(Time timeOfTrip) {
        this.timeOfTrip = timeOfTrip;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (id != route.id) return false;
        if (sourceAdd != null ? !sourceAdd.equals(route.sourceAdd) : route.sourceAdd != null) return false;
        if (destAdd != null ? !destAdd.equals(route.destAdd) : route.destAdd != null) return false;
        if (timeOfTrip != null ? !timeOfTrip.equals(route.timeOfTrip) : route.timeOfTrip != null) return false;
        if (status != null ? !status.equals(route.status) : route.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (sourceAdd != null ? sourceAdd.hashCode() : 0);
        result = 31 * result + (destAdd != null ? destAdd.hashCode() : 0);
        result = 31 * result + (timeOfTrip != null ? timeOfTrip.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "tracking_num", nullable = false)
    public TaxiOrder getTaxiOrder() {
        return taxiOrder;
    }

    public void setTaxiOrder(TaxiOrder taxiOrder) {
        this.taxiOrder = taxiOrder;
    }
}
