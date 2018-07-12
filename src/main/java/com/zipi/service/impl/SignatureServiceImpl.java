package com.zipi.service.impl;

import com.zipi.entity.Signature;
import com.zipi.enums.core.FundRecordStatus;
import com.zipi.mapper.SignatureMapper;
import com.zipi.service.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SignatureServiceImpl implements SignatureService {
    @Autowired
    private SignatureMapper signatureMapper;

    public void insert(Signature signature){
        signatureMapper.insert(signature);
    }

    @Override
    public Signature selectSignatureRecoredByFileId(String fileId) {
        return signatureMapper.selectSignatureRecoredByFileId(fileId);
    }

    @Override
    public int updateSignatureStatus(FundRecordStatus beforeTradeStatus, FundRecordStatus afterTradeStatus, Date updateTime,
                                     String timeStamp, String signKeyword, int sealNo, String transactionId) {
        return signatureMapper.updateSignatureStatus(beforeTradeStatus, afterTradeStatus, updateTime, timeStamp, signKeyword, sealNo, transactionId);
    }

    @Override
    public int deleteByFileId(String fileId) {
        return signatureMapper.deleteByFileId(fileId);
    }
}
