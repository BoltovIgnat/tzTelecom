package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="id_car")
    private Cars car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="id_pointofsale")
    private PointOfSale pointofsale;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    //@OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="id_tanant")
    private Tenants tenant;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalDateOn;

    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalDateOff;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    private Long amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }

    public PointOfSale getPointofsale() {
        return pointofsale;
    }

    public void setPointofsale(PointOfSale pointofsale) {
        this.pointofsale = pointofsale;
    }

    public Tenants getTenant() {
        return tenant;
    }

    public void setTenant(Tenants tenant) {
        this.tenant = tenant;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getRentalDateOn() {
        return rentalDateOn;
    }

    public void setRentalDateOn(Date rentalDateOn) {
        this.rentalDateOn = rentalDateOn;
    }

    public Date getRentalDateOff() {
        return rentalDateOff;
    }

    public void setRentalDateOff(Date rentalDateOff) {
        this.rentalDateOff = rentalDateOff;
    }
}
