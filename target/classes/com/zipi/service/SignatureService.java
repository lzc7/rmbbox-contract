package com.zipi.service;

import com.zipi.entity.Signature;
import com.zipi.enums.core.FundRecordStatus;

import java.util.Date;

public interface SignatureService {

    void insert(Signature signature);

    Signature selectSignatureRecoredByFileId(String fileId);

    int updateSignatureStatus(FundRecordStatus beforeTradeStatus, FundRecordStatus afterTradeStatus, Date updateTime,
                              String timeStamp, String signKeyword, int sealNo, String transactionId);

    int deleteByFileId(String fileId);
}
