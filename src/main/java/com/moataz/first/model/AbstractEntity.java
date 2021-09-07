package com.moataz.first.model;


import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
public abstract class AbstractEntity {


    private Date CreationDate;
    private String CreatedBy;
    private Date updateDate;

}
