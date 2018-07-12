/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.enums.common;


import com.zipi.base.BaseEnum;

/**
 *
 * @author zhaichongchong
 */
public enum ConcurrentCacheKey implements BaseEnum {


    CLAIM_INVEST("investConfig:investClaimLimit"),
    ASSET_INVEST("investConfig:investAssetLimit"),
    NO_KEY(null);// 该枚举不能修改!!!

    private final String key;


    ConcurrentCacheKey(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
