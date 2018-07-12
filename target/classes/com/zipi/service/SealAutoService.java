package com.zipi.service;


import com.zipi.enums.SealFileType;


public interface SealAutoService {


	byte[] getLoanAgreement(String investId, String loanId, String userId, SealFileType fileType)throws Exception;

}
