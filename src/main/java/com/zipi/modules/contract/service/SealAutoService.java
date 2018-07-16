package com.zipi.modules.contract.service;


import com.zipi.modules.contract.enums.SealFileType;


public interface SealAutoService {


	byte[] getLoanAgreement(String investId, String loanId, String userId, SealFileType fileType)throws Exception;

}
