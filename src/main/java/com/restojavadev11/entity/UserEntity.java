package com.restojavadev11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "u_id", nullable = false)
    private Long uId;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "u_password", nullable = false)
    private String password;
}
