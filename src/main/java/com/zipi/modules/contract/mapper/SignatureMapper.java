package com.zipi.modules.contract.mapper;

import com.zipi.modules.base.enums.FundRecordStatus;
import com.zipi.modules.contract.entity.Signature;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SignatureMapper {

    void insert(Signature signature);

    Signature selectSignatureRecoredByFileId(@Param("fileId") String fileId);

    int updateSignatureStatus(@Param("beforeTradeStatus") FundRecordStatus beforeTradeStatus, @Param("afterTradeStatus") FundRecordStatus afterTradeStatus,
                              @Param("updateTime") Date updateTime, @Param("timeStamp") String timeStamp, @Param("signKeyword") String signKeyword,
                              @Param("sealNo") int sealNo, @Param("transactionId") String transactionId);

    int deleteByFileId(@Param("fileId") String fileId);
}
