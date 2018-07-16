package com.zipi.modules.contract.service;


import com.zipi.modules.contract.entity.RmbContractTemplate;

public interface ContractTemplateService {

	
	public RmbContractTemplate getByType(String type);
}
