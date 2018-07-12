package com.zipi.enums.props;

import java.io.Serializable;

/**
 * Created by zhangyang on 7/26/16.
 */
public enum TelephoneVoiceDataProduct implements Serializable {
    TelephoneVoice_100("41","全国话费100元"),
    TelephoneVoice_50("40","全国话费50元"),
    TelephoneVoice_30("39","全国话费30元"),
    TelephoneVoice_20("38","全国话费20元"),
    TelephoneVoice_10("37","全国话费10元"),
    TelephoneVoice_5("36","全国话费5元"),

    TelephoneData_500M_CUCC("35","中国联通流量500M"),
    TelephoneData_200M_CUCC("34","中国联通流量200M"),
    TelephoneData_100M_CUCC("33","中国联通流量100M"),
    TelephoneData_50M_CUCC("32","中国联通流量50M"),

    TelephoneData_500M_CTCC("31","中国电信流量500M"),
    TelephoneData_200M_CTCC("30","中国电信流量200M"),
    TelephoneData_100M_CTCC("29","中国电信流量100M"),
    TelephoneData_50M_CTCC("28","中国电信流量50M"),

    TelephoneData_1G_CMCC("27","中国移动流量1G"),
    TelephoneData_500M_CMCC("26","中国移动流量500M"),
    TelephoneData_100M_CMCC("25","中国移动流量100M"),
    TelephoneData_50M_CMCC("24","中国移动流量50M"),
    ;

    private String productId;
    private String productName;

    private TelephoneVoiceDataProduct(String productId, String productName){
        this.productId=productId;
        this.productName=productName;
    }

    public String getProductId(){
        return this.productId;
    }

    public String getProductName(){
        return this.productName;
    }

    public static TelephoneVoiceDataProduct get(String key){
        for(TelephoneVoiceDataProduct type : TelephoneVoiceDataProduct.values()){
            if(key.equals(type.name()))
                return type;
        }
        return null;
    }
}