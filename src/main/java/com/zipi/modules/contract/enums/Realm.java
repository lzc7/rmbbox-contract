/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.modules.contract.enums;


import com.zipi.modules.base.enums.BaseEnum;

/**
 * 定义实体相关的域
 *
 * @author rooseek
 */
public enum Realm implements BaseEnum {


    /**
     * 代表跟realm关联的field仅仅是个字符串，不是系统内的实体
     */
    STRING("字符串"),
    /**
     * 名值对，用于存放额外信息，key和value用|分隔
     */
    KEYVALUE("名值对"),
    /**
     * 影子标显示的借款人
     */
    SHADOW_BORROWER("影子标显示的借款人"),
    /**
     * 借款类型
     */
    LOAN_TYPE("借款类型"),
    /**
     * 借款附加利率
     */
    LOAN_ADDTIONAL_RATE("借款附加利率"),
    /**
     * 企业关联法人
     */
    LEGAL_PERSON("企业关联法人"),
    /*
     * 融资企业
     */
    FINANCE_CORPORATION("融资企业"),
    /**
     * 基本类型
     */
    USER("用戶"),
    CORPORATIONUSER("企业用户"),
    EMPLOYEE("员工"),
    ROLE("角色"),
    CLIENT("客戶"),
    BRANCH("分支机构"),
    CORPORATION("企业"),//注意不是平台用户
    SYSTEM("系统"),//
    /**
     * 认证
     */
    PROOF("证明"),
    CERTIFICATE("认证"),
    VEHICLE("车辆"),
    REALESTATE("房产"),
    /**
     * 借款贷款
     */
    INVEST("投标"),
    LOAN("贷款"),
    CREDITASSIGN("债权转让"),
    INVESTREPAYMENT("投资还款"),
    LOANREPAYMENT("贷款还款"),
    LOANREQUEST("贷款申请"),
    TASK("任务"),
    APPOINTMENT("认购"),
    /**
     * 业务类型
     */
    FUND("资金"),
    WITHDRAW("取现"),
    /**
     * CMS管理
     */
    CHANNEL("CMS栏目"),
    ARTICLE("CMS文章"),
    ADSIMAGE("广告图片管理"),

    /**
     * 其他
     */
    MOBILE("手机号"),
    CONTRACT("合同"),
    STATISTICS("统计"),
    CONTRACTTEMPLATE("合同模板"),
    BROKERAGE_CONTRACTTEMPLATE("居间合同模板"),
    CONTRACTSEAL("合同章"),
    IMAGE("图片"),
    FILE("文件"),
    TICKET("支持工单"),
    BATCHJOB("批量任务"),
    PAGES("页面"),
    BATCH("批量导入"),
    KEFUCALLED("回访"),

    /**
     * 合同模板
     */
    CONTRACTTEMPLATE_O2O("合同模板一对一"),
    CONTRACTTEMPLATE_O2M("合同模板一对多"),


	/**
	 * 广告管理
	 */
	/**
	 * 登录注册背景图
	 */
	ADLOGINBGIMG("登录注册背景图"),
	/**
	 * 首页背景图
	 */
	ADHOMEIMG("首页背景图"),
	/**
	 * 顶部banner
	 */
	ADTOPIMG("顶部banner"),
    /**
     * PC首页统计数据行，左侧图
     */
    ADStatisticsLeftIMG("首页统计数据左侧图"),
    /**
     * 底部banner1
     */
	ADFOOTBANNER1("底部banner"),

	  /**
     * 底部banner2
     */
	ADFOOTBANNER2("底部banner"),
	/**
	 *新手广告位
	 */
	ADNEWPERION("新手广告位"),
    /**
     * 零存宝广告位
     */
	ADCURRENT("零存宝广告位"),
	/**
	 * 手机banner图
	 */
	MOBILEBANNER("手机banner图"),

    /**
     * app广告图片
     */
    APPFIRSTUSE("启动页面图片管理"),
    APPSTARTCAR("开机动画图片管理"),
    APPHOMELT("首页弹层图片"),
    APPFOOTICON("底部ICON图片"),

    PCSKIPICON("pc跳转icon"),
    PCLAYERICON("pc弹层icon"),
    MZSKIPICON("m站跳转icon"),
    MZLAYERICON("m站弹层icon"),
    APPSKIPICON("app跳转icon"),
    APPLAYERICON("app弹层icon"),

    /**
     * icon跳转 弹层
     */
    SKIP("广告跳转"),
    POP("广告弹层"),

    /**
     * 红包主人角色
     */
    GIFTCARD_REGISTER("主动注册"),
    GIFTCARD_INVITER("邀请人"),
    GIFTCARD_INVITEE("被邀请"),
    GIFTCARD_ACTIVITY("参与活动"),

    /**
     * 序列号
     */
    SERIALNUMBER("序列号"),

    /**
     * 担保审计
     */
    GUARANTEE_AUDIT("GUARANTEE_AUDIT"),

    REWARD("奖励"),

    PROMOTE("推广"),

    UPLAN("优选计划"),

    SYSTEM_SETTING("系统设置"),

    SETTLEMENT("结算管理"),


    ACTIVITY("活动统计"),
    /**
     * use for user table when referralEntity is null
     */
    USER_NULL("无"),

    CLAIM_MANAGER("债权管理"),
    CLAIM_PRODUCT_PUBLICSH("发布产品"),
    CLAIM_DAY_END_TASKS("日终任务"),
    CURRENT_PRODUCT("活期理财"),
    MONTH_WIN_PRODUCT("月盈计划"),
    RECYCLE_INTEREST_PRODUCT("复利计划"),
    FIXED_PRODUCT_A("定期计划A"),//定期宝1个月
    FIXED_PRODUCT_B("定期计划B"),//定期宝3个月
    FIXED_PRODUCT_C("定期计划C"),//定期宝6个月
    FIXED_PRODUCT_D("定期计划D"),
    ASSETLOAN("定期理财产品"),
    PRODUCT_CONFIG_LIST("产品推荐位置"),
    NMD_MANAGER("诺曼底后台"),
    NEW_HAND_PRODUCT("新手标"),
    BACKGROUND_IMAGE("背景图片"),
    REGISTERSOURCE("注册渠道管理"),
    DICT_MANAGER("字典管理"),
    TELEPHONE_MANAGER("话费管理"),
    ANTIFRAUD("反欺诈管理"),
    CREDIT_MANAGEMENT("转让列表权限");


    private final String key;

    private Realm(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
