package com.teamd.taxi.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Slava on 21.04.2015.
 */
@Entity
@Table(name = "taxi_order", schema = "taxi", catalog = "taxiservice")
public class TaxiOrder {
    private long trackingNum;
    private Date execDate;
    private String comments;
    private Collection<Route> routes;
    private PaymentType paymentType;
    private ServiceType serviceType;
    private User user;
    private Collection<Feature> features;

    @Id
    @Column(name = "tracking_num")
    public long getTrackingNum() {
        return trackingNum;
    }

    public void setTrackingNum(long trackingNum) {
        this.trackingNum = trackingNum;
    }

    @Basic
    @Column(name = "exec_date")
    public Date getExecDate() {
        return execDate;
    }

    public void setExecDate(Date execDate) {
        this.execDate = execDate;
    }

    @Basic
    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxiOrder taxiOrder = (TaxiOrder) o;

        if (trackingNum != taxiOrder.trackingNum) return false;
        if (execDate != null ? !execDate.equals(taxiOrder.execDate) : taxiOrder.execDate != null) return false;
        if (comments != null ? !comments.equals(taxiOrder.comments) : taxiOrder.comments != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (trackingNum ^ (trackingNum >>> 32));
        result = 31 * result + (execDate != null ? execDate.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "taxiOrder")
    public Collection<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Collection<Route> routes) {
        this.routes = routes;
    }

    @ManyToOne
    @JoinColumn(name = "payment", referencedColumnName = "id", nullable = false)
    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @ManyToOne
    @JoinColumn(name = "service_type", referencedColumnName = "id", nullable = false)
    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany
    @JoinTable(name = "feature_order_list", catalog = "taxiservice", schema = "taxi", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "tracking_num", nullable = false), inverseJoinColumns = @JoinColumn(name = "feature_id", referencedColumnName = "id", nullable = false))
    public Collection<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(Collection<Feature> features) {
        this.features = features;
    }
}
