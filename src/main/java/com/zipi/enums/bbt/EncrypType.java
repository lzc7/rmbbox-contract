package com.zipi.enums.bbt;

import com.zipi.base.BaseEnum;

/**
 * Created by veryyoung on 2014/12/1.
 * <p/>
 * 解码类别
 */
public enum EncrypType implements BaseEnum {


    IDNUMBER("身份证号") ,

    MOBIE("手机号"),

    TOKEN("移动端令牌"),

    AMOUNT_HASH("余额HASH");

    private final String key;

    private EncrypType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }



}
