package com.zipi.service.impl;

import com.zipi.entity.RmbboxLoanApply;
import com.zipi.mapper.RmbboxLoanApplyMapper;
import com.zipi.service.RmbboxLoanApplyService;
import com.zipi.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Slf4j
@Service
public class RmbboxLoanApplyServiceImpl implements RmbboxLoanApplyService {
    @Autowired
    private RmbboxLoanApplyMapper rmbboxLoanApplyMapper;

    @Override
    public String getPurpose(String requestId) {
        String purpose = "短期周转";
        RmbboxLoanApply apply = rmbboxLoanApplyMapper.selectByRequestId(requestId);
        if (null != apply && StringUtils.isNotBlank(apply.getBaseInfo())){
            try {
                Map map = JsonUtil.setString2Map(apply.getBaseInfo());
                purpose = map.get("usage_value")+"";
            } catch (Exception e) {
                log.error("",e);
            }
        }
        return purpose;
    }
}
