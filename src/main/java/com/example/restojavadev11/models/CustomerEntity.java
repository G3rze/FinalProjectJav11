package com.example.restojavadev11.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "customer", schema = "project", catalog = "")
public class CustomerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_customer", nullable = false)
    @Getter @Setter
    private int idCustomer;

    @Basic
    @Column(name = "c_name", nullable = false, length = 100)
    @Getter @Setter
    private String cName;

    @Basic
    @Column(name = "c_lastName", nullable = false, length = 100)
    @Getter @Setter
    private String cLastName;

    @Basic
    @Column(name = "c_address", nullable = false, length = 100)
    @Getter @Setter
    private String cAddress;

    @Basic
    @Column(name = "c_phone", nullable = false, length = 9)
    @Getter @Setter
    private String cPhone;

    @Basic
    @Column(name = "c_email", nullable = false, length = 100)
    @Getter @Setter
    private String cEmail;

    @OneToMany(mappedBy = "customerByRIdCustomer")
    @Getter @Setter
    private Collection<ReservationEntity> reservationsByIdCustomer;
}
