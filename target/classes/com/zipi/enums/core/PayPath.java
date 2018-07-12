package com.zipi.enums.core;

import com.zipi.base.BaseEnum;

/**
 * 第三方平台
 * <p/>
 * Created by apple on 15/4/2.
 */
public enum PayPath implements BaseEnum {

    FF_PAY("丰付"),
    OTHER("其他"),
    UMPAY("联动优势"),
    JD_PAY("京东网银在线"),
    JD_ENTERPRISE_PAY("京东网银企业在线"),
    LL_ENTERPRISE_PAY("连连支付网银企业"),
    LL_PAY("连连支付"),
    ZFT_PAY("支付通支付"),
    YEE_PAY("易宝支付"),
    HYL_PAY("好易联"),
	SINGLE("单笔"),
	BATCH("批量"),
    NEWNET_PAY("新网银行"),
    YEEPAY("易宝支付"),
    FUIOU("富友支付"),
    ALLINPAY("通联支付"),
    CHINAGPAY("爱农支付"),
    TFTPAY("腾付通"),
    UCFPAY("先锋支付"),
    BAOFOO("宝付"),
    LIANLIAN("连连存管"),
	NOTHING("无");

    private final String key;

    private PayPath(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    public static PayPath getValue(String key){
        for(PayPath type : PayPath.values()){
            if(key.equals(type.getKey()))
                return type;
        }
        return null;
    }

}
