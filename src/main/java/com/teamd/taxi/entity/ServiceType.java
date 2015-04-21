package com.teamd.taxi.entity;

import javax.persistence.*;

/**
 * Created by Slava on 21.04.2015.
 */
@Entity
@Table(name = "service_type", schema = "taxi", catalog = "taxiservice")
public class ServiceType {
    private long id;
    private Tariff tariff;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceType that = (ServiceType) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @ManyToOne
    @JoinColumn(name = "tariff_type", referencedColumnName = "id", nullable = false)
    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }
}
