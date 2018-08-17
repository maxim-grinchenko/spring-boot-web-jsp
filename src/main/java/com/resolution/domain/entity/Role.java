package com.resolution.domain.entity;

import com.resolution.domain.entity.base.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "ROLE_TABLE")
@Entity
class Role extends AbstractEntity implements Serializable {

    @Column(name = "ROLE")
    private String role;

}
