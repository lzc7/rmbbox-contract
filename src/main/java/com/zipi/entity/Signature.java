package com.zipi.entity;

import com.zipi.enums.core.FundRecordStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Signature {
    /**交易号*/
    private String transactionId;
    /**创建时间*/
    private Date createTime;
    /**修改时间*/
    private Date updateTime;
    /**请求时间*/
    private String timeStamp;
    /**操作描述*/
    private String description;
    /**交易状态*/
    private FundRecordStatus tradeStatus;
    /**投资编号*/
    private String investId;
    /**合同编号*/
    private String contractId;
    /**文件编号*/
    private String fileId;
    /**待签署文档标题*/
    private String docTitle;
    /**自动签约关键字*/
    private String signKeyword;
    /**章编号*/
    private int sealNo;

}
