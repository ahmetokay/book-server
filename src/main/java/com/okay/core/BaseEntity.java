package com.okay.core;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "created", updatable = false)
    private Date created;

    @Column(name = "updated")
    private Date updated;

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        this.created = now;
        this.updated = now;
    }

    @PreUpdate
    public void setUpdateDate() {
        this.updated = new Date();
    }
}