package com.zipi.modules.contract.service;

import com.zipi.modules.base.enums.FundRecordStatus;
import com.zipi.modules.contract.entity.Signature;

import java.util.Date;

public interface SignatureService {

    void insert(Signature signature);

    Signature selectSignatureRecoredByFileId(String fileId);

    int updateSignatureStatus(FundRecordStatus beforeTradeStatus, FundRecordStatus afterTradeStatus, Date updateTime,
                              String timeStamp, String signKeyword, int sealNo, String transactionId);

    int deleteByFileId(String fileId);
}
