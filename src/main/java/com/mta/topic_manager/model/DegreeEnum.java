    package com.mta.topic_manager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public enum DegreeEnum {
    TIEN_SI("TS"),
    THAC_SI("ThS"),
    GIAO_SU("GS"),
    PHO_GIAO_SU("PGS"),
    CU_NHAN("CN");
    private final String value;

}
