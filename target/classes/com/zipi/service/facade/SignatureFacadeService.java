package com.zipi.service.facade;


import com.zipi.entity.CoreSealFlie;

/**
 * author linzhicheng
 * 2018年7月6日13:15:21
 */
public interface SignatureFacadeService {
    /**
     * 协议签章操作
     * @param coreSealFlie
     * @throws Exception
     */
    void signatureComposite(CoreSealFlie coreSealFlie) throws Exception;

}
