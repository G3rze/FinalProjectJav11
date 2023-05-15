package com.restojavadev11.entity;

import com.restojavadev11.entity.embeddable.ReservationTableId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_role", schema = "project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRoleEntity {
    @EmbeddedId
    private ReservationTableId urID;
}
