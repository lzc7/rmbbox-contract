package com.zipi.entity;

import lombok.Data;

@Data
public class ReferralUser {

    private String userId;

    private String loginName;

    private String userName="";

    private String userMobile;
    
    private int referralCount;
}