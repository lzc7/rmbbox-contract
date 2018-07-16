package com.zipi.modules.contract.enums;

import com.zipi.modules.base.enums.BaseEnum;

/**
 * Created by linzhicheng on 2017/2/8.
 */
public enum ReplyStatus implements BaseEnum {
    REPLIED("已处理"),
    REPLYING("处理中"),
    TOBEREPLIED("待处理");

    private final String key;

    ReplyStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
