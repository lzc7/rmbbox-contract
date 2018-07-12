package com.zipi.enums.props;

import java.io.Serializable;

/**
 * Created by zhangyang on 7/28/16.
 */
public enum TelephoneRechargeScheme implements Serializable {
    TelephoneVoice_5("5","VOICE","全国话费5元"),
    TelephoneVoice_10("10","VOICE","全国话费10元"),
    TelephoneVoice_20("20","VOICE","全国话费20元"),
    TelephoneVoice_30("30","VOICE","全国话费30元"),
    TelephoneVoice_50("50","VOICE","全国话费50元"),
    TelephoneVoice_100("100","VOICE","全国话费100元"),

    TelephoneData_50M("50M","DATA","手机流量50M"),
    TelephoneData_100M("100M","DATA","手机流量100M"),
    TelephoneData_200M("200M","DATA","手机流量200M"),
    TelephoneData_500M("500M","DATA","手机流量500M"),
    TelephoneData_1G("1G","DATA","手机流量1G")
    ;

    private String schemeName;
    private String productType;
    private String productDesc;

    private TelephoneRechargeScheme(String schemeName,String productType,String productDesc){
        this.schemeName=schemeName;
        this.productDesc=productDesc;
        this.productType=productType;
    }

    public String getSchemeName(){
        return this.schemeName;
    }

    public String getProductDesc(){
        return this.productDesc;
    }

    public String getProductType(){
        return this.productType;
    }

    /**
     *
     * @param productName
     * @return
     */
    public static TelephoneRechargeScheme getByProductName(String productName){
        for(TelephoneRechargeScheme type : TelephoneRechargeScheme.values()){
            if(productName.equals(type.name()))
                return type;
        }
        return null;
    }

}