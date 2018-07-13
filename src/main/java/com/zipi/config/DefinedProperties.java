package com.zipi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
/**
 * author linzhicheng
 * 2018年7月13日13:47:36
 */
@Configuration
public class DefinedProperties {

    public static String FDD_API_ID;
    public static String FDD_APP_SECRET;
    public static String FDD_V;
    public static String FDD_API_URL;
    public static String FDD_BBT_CUSTOMER_NO;


    @Value("${myProps.FDD_API_ID}")
    public void setFDD_API_ID(String FDD_API_ID) {
        DefinedProperties.FDD_API_ID = FDD_API_ID;
    }

    @Value("${myProps.FDD_APP_SECRET}")
    public void setFDD_APP_SECRET(String FDD_APP_SECRET) {
        DefinedProperties.FDD_APP_SECRET = FDD_APP_SECRET;
    }

    @Value("${myProps.FDD_V}")
    public void setFDD_V(String FDD_V) {
        DefinedProperties.FDD_V = FDD_V;
    }

    @Value("${myProps.FDD_API_URL}")
    public void setFDD_API_URL(String FDD_API_URL) {
        DefinedProperties.FDD_API_URL = FDD_API_URL;
    }

    @Value("${myProps.FDD_BBT_CUSTOMER_NO}")
    public void setFDD_BBT_CUSTOMER_NO(String FDD_BBT_CUSTOMER_NO) {
        DefinedProperties.FDD_BBT_CUSTOMER_NO = FDD_BBT_CUSTOMER_NO;
    }

}
