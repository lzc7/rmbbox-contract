package com.zipi.modules.contract.enums;

/**
 * Created by liangyu on 2017/3/15.
 */
public enum CertificateType {
    //身份证
    PRC_ID("01"),
    //护照
    PASSPORT("02"),
    //港澳台通行证
    COMPATRIOTS_CARD("03"),
    //外国人永久居留证
    PERMANENT_RESIDENCE("04");

    private String value;

    CertificateType(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
