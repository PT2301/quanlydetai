package com.mta.topic_manager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public enum TopicStatusEnum {
    CHUA_DUYET("Chưa duyệt"),
    DA_PHE_DUYET("Đã phê duyệt"),
    DANG_THUC_HIEN("Đang thực hiện"),
    DA_NGHIEM_THU("Đã nghiệm thu");
    private final String value;
}
