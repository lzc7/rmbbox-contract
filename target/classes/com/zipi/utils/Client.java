/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.utils;



import com.zipi.base.BaseObject;

import javax.validation.constraints.NotNull;
import java.util.Locale;


/**
 * 表示客户机构
 *
 * @author sobranie
 */
public class Client extends BaseObject {

    private static final long serialVersionUID = 20130918L;

    /**
     * full name of the client
     */
    @NotNull
    protected String name="邦帮堂";

    /**
     * 客户简称
     */
    @NotNull
    private String shortName="邦帮堂";

    /**
     * 显示在Market上的title
     */
    @NotNull
    private String title="邦帮堂";

    /**
     * 系统使用的手机，用于发送重要消息
     */
    private String mobile;

    /**
     * 技术支持邮件，在异常等状况下应用
     */
    private String supportEmail="support@rmbbox.com";

    /**
     * 支持/客服电话
     */
    private String supportPhone="4009-088-988";
    
    /**
     * 理财列表网址
     */
    private String  financialUrl="http://t.cn/R5ZCSpQ";
    /**
     * 内部邮件特征字符串，邮件域名中包含creditcloud的即为CRCD的内部客户.
     * <p/>
     * 多个字符串用逗号分割
     */
    private String internalEmailIndicators;


    /**
     * url，类似 www.apengdai.com
     */
    protected String url="www.rmbbox.com";

    /**
     * 是否使用https安全连接访问
     */
    protected boolean secure;


    /**
     * 平台logo url或者base64编码logo
     */
    private String logo;

    private String code="XMRX";
    
    /**
     * 现金欢乐送活动页
     */
    private String cashPacketUrl="https://www.rmbbox.com/activity/cashpacket/index";
    @NotNull
    protected Locale locale;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSupportEmail() {
		return supportEmail;
	}

	public void setSupportEmail(String supportEmail) {
		this.supportEmail = supportEmail;
	}

	public String getSupportPhone() {
		return supportPhone;
	}

	public void setSupportPhone(String supportPhone) {
		this.supportPhone = supportPhone;
	}

	public String getInternalEmailIndicators() {
		return internalEmailIndicators;
	}

	public void setInternalEmailIndicators(String internalEmailIndicators) {
		this.internalEmailIndicators = internalEmailIndicators;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getFinancialUrl() {
		return financialUrl;
	}

	public void setFinancialUrl(String financialUrl) {
		this.financialUrl = financialUrl;
	}

	public String getCashPacketUrl() {
		return cashPacketUrl;
	}

	public void setCashPacketUrl(String cashPacketUrl) {
		this.cashPacketUrl = cashPacketUrl;
	}
    
	
    
}