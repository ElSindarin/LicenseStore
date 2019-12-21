package com.internship.licensestore.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "license")
public class LicenseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "create_date")
    private LocalDate create_date;

    @Column (name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn (name = "client_id")
    private ClientEntity clientEntity;

    public LicenseEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDate create_date) {
        this.create_date = create_date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    @Override
    public String toString() {
        return "LicenseEntity{" +
                "id=" + id +
                ", create_date=" + create_date +
                ", price=" + price +
                ", clientEntity=" + clientEntity +
                '}';
    }
}
