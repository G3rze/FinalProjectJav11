package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_customer", nullable = false)
    private Long idCustomer;

    @Basic
    @Column(name = "c_name", nullable = false, length = 100)
    private String cName;

    @Basic
    @Column(name = "c_lastname", nullable = false, length = 100)
    private String cLastName;

    @Basic
    @Column(name = "c_address", nullable = false, length = 100)
    private String cAddress;

    @Basic
    @Column(name = "c_phone", nullable = false, length = 9)
    private String cPhone;

    @Basic
    @Column(name = "c_email", nullable = false, length = 100)
    private String cEmail;
}
