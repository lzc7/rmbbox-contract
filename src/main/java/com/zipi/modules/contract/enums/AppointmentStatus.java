package com.zipi.modules.contract.enums;

/**
 * Created by Administrator on 2017/6/14.
 */
public enum AppointmentStatus {

    INITIALIZED("初始状态"),
    SUBMITTED("预约提交成功,金额已冻结等待匹配"),
//    MATCHING("匹配中"),

    PARTSUCCESS("部分成功"),

    CANCEL("取消自动出借"),

    CANCELLING("取消自动出借处理中"),

    SUCCESS("授权成功"),

    FAILED("预约失败");

    private String key;
    AppointmentStatus(String key) {
        this.key = key;
    }
}
