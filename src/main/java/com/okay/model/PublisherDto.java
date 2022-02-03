package com.okay.model;

import com.okay.core.BaseModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PublisherDto extends BaseModel {

    private String name;
}