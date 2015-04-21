package com.teamd.taxi.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Slava on 21.04.2015.
 */
@Entity
public class License {
    private long serialNum;
    private Date dueDate;
    private Car driver;

    @Id
    @Column(name = "serial_num")
    public long getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }

    @Basic
    @Column(name = "due_date")
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        License license = (License) o;

        if (serialNum != license.serialNum) return false;
        if (dueDate != null ? !dueDate.equals(license.dueDate) : license.dueDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (serialNum ^ (serialNum >>> 32));
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "driver_id")
    public Car getDriver() {
        return driver;
    }

    public void setDriver(Car driver) {
        this.driver = driver;
    }
}
