package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RolesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ro_id")
    private Long id;

    @Column(name = "ro_name")
    private String name;

    @Column(name = "ro_description")
    private String description;
}
