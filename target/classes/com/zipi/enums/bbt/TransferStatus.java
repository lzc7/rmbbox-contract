package com.zipi.enums.bbt;

import com.zipi.base.BaseEnum;

/**
 * Created by Tony on 2015/1/19.
 * <p/>
 * 交易状态，记录交易在三方支付的状态
 *
 * @author rooseek
 */
public enum TransferStatus implements BaseEnum {


    /**
     * 成功
     */
    S("成功"),
    /**
     * 失败
     */
    F("失败"),
    /**
     * 初始
     */
    I("初始"),
    /**
     * 部分成功
     */
    P("部分成功"),
    /**
     * 经办
     */
    H("经办"),
    /**
     * 拒绝
     */
    R("拒绝"),
    /**
     * 查询对象在三方支付不存在
     */
    NOTEXIST("不存在"),
    /**
     * 无需跟三方支付结算
     */
    NOTRANS("无交易"),
    /**
     * 对汇付表示,查询自动出借状态表示开启!
     */
    N("开启"),
    /**
     * 对汇付表示,查询自动出借状态表示关闭!
     */
    C("关闭"),;

    private final String key;

    private TransferStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}


