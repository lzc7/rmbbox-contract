package com.zipi.enums.props;

/**
 * Created by zhangyang on 7/28/16.
 */
public enum  TelephoneRechargeStatus {
    /**
     * 0 请求失败
     * 1 请求成功
     * 2 请求关闭，关闭以后将不再重充值
     * 3 订单异常，运营商方案不支持、手机号枚举缺失等等造成不能提交订单到三方充值
     */
    FAILURE(0),
    SUCCESSFUL(1),
    CLOSE(2),
    ERROR(3);

    private int status;

    private TelephoneRechargeStatus(int status){
        this.status=status;
    }
    public int getStatus(){
        return this.status;
    }
}