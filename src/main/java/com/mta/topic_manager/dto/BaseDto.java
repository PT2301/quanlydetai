package com.mta.topic_manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor

public abstract class BaseDto<T> {
    public Integer id;
    public String name;
    private String createBy;
    private Date createDate;
    private String editBy;
    private Date editDate;
}
