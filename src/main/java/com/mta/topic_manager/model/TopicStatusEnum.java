package com.mta.topic_manager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public enum TopicStatusEnum {
    CHUA_PHE_DUYET("CPD"),
    DA_PHE_DUYET("DPD"),
    DANG_THUC_HIEN("DTH"),
    DA_HOAN_THANH("DHT"),
    DA_NGHIEM_THU("DNT");
    private final String value;
}
