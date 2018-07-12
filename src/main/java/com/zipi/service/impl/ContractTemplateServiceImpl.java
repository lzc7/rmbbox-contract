package com.zipi.service.impl;

import com.zipi.entity.RmbContractTemplate;
import com.zipi.mapper.RmbContractTemplateMapper;
import com.zipi.service.ContractTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class ContractTemplateServiceImpl implements
        ContractTemplateService {

	@Autowired
	private RmbContractTemplateMapper rmbContractTemplateMapper;
	


    public RmbContractTemplate getByType(String type) {
        RmbContractTemplate template = rmbContractTemplateMapper.getByType(type);
        if (template == null) {
            log.info("contract template type = {} not found!", type);
            return null;
        }
        return template;
    }

}
