package com.zipi.enums;

import com.zipi.base.BaseEnum;

/**
 * 用户风险评测枚举
 * @author haojunfu
 *
 */
public enum UserRiskAssessmentType implements BaseEnum {

	CONSERVATIVE("保守型","/list/bbt","/api/v3/list/v3ListAll"),
	STABLE("稳定型","/list/bbt","/api/v3/list/v3ListAll"),
	POSITIVE("进取型","/list/bbt","/api/v3/list/v3ListAll"),
	NOTHING("尚未测评","","")
    ;


    public String getPcUrl() {
		return pcUrl;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	private final String key;
    private final String pcUrl;
    private final String apiUrl;

    private UserRiskAssessmentType(String key,String pcUrl,String apiUrl) {
        this.key = key;
        this.pcUrl = pcUrl;
        this.apiUrl = apiUrl;
    }

    @Override
    public String getKey() {
        return key;
    }
    
}
