package com.okay.core;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BaseModel implements Serializable {

    private Long id;

    private Date created;

    private Date updated;
}