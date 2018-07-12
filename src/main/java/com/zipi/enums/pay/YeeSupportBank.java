package com.zipi.enums.pay;

/**
 * Created by demon.mu on 16/2/1.
 */
public enum YeeSupportBank{
    //工商
    ICBC(LLSupportBank.ICBC.name()),
    //中行
    BOC(LLSupportBank.BOC.name()),
    //建行
    CCB(LLSupportBank.CCB.name()),
    //邮政
    POST(LLSupportBank.PSBC.name()),
    //中信
    ECITIC(LLSupportBank.CNCB.name()),
    //光大
    CEB(LLSupportBank.CEB.name()),
    //华夏
    HXB(LLSupportBank.HXB.name()),
    //招商
    CMBCHINA(LLSupportBank.CMB.name()),
    //兴业
    CIB(LLSupportBank.CIB.name()),
    //浦发
    SPDB(LLSupportBank.SPDB.name()),
    //广发
    GDB(LLSupportBank.CGB.name()),
    //民生
    CMBC(LLSupportBank.CMSB.name()),
    //农行
    ABC(LLSupportBank.ABC.name()),
    //交通
    BOCO(LLSupportBank.COMM.name()),
    //平安
    PINGAN(LLSupportBank.PAB.name()),
    //宁波银行
    NBCB(LLSupportBank.NBCB.name()),
    //北京银行
    BCCB(LLSupportBank.BCCB.name());


    private String value;

    YeeSupportBank(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
