package com.mta.topic_manager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TopicResultEnum {
    XUAT_SAC("Xuất sắc"),
    GIOI("Giỏi"),
    KHA("Khá"),
    CHUU_DAT("Chưa đạt");
    private String value;
}
