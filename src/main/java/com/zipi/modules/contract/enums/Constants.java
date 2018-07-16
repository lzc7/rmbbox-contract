package com.zipi.modules.contract.enums;


import com.zipi.core.util.DateUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

	public static final String ADMIN = "admin";
	public static final String 	SIGN_TYPE = "SHA-256";
	public static final String 	JDPAY_TRADEQUERY = "https://mapi.jdpay.com/npp10/trade_query";
	public static final String JD_DEFRAY_PAY="https://mapi.jdpay.com/npp10/defray_pay"; //京东代付请求地址
	public static final String 	TB_AUTH_FLOW = " bbt.tb_auth_flow "; // 鉴权流水表
	public static final String 	TB_AUTH_FLOW_ID = " id "; // 鉴权流水表主键
	public static final String 	TB_CORE_PLATFOR = " bbt.tb_core_platform_fund_record "; // 平台账户表
	public static final String 	TB_CORE_PLATFOR_ID = " id "; // 平台账户表

	public static final String CONFIG_PATH = "/var/zipi/lending/";// 文件存放路劲
	public static final String RSA_FILE_PATH = "/var/zipi/lending/rsa/";// 文件存放路劲
	public static final String charset="UTF-8";
	public static final String encryptType_RSA="RSA";//加密类型
	public static final String encryptType_DES="3DES";//加密类型
	public static final String singType="SHA-256";//签名类型
	/*******************测试使用，生产需要替换相应的值和文件*******************/
	public static final String passWord="qazwsx";//秘钥文件密码
	public static final String pri="360080000232129677.pfx";//秘钥文件名（该文件包含公钥和私钥）
	public static final String pub="npp_11_API2_pro.cer";//代付证书文件名
	public static final String singKey="1qa2ws3ed~!@360080003181490025";//签名key，测试环境测试的都是test，生产上一个会员对应一个key
	public static final String TRADEAMOUNTSTRING="0.01";//京东代付鉴权，默认转入1分钱；


	public static final DecimalFormat digtialdf4Excel = new DecimalFormat("0.##");
	public static final DecimalFormat df1 = new DecimalFormat("0.00");
	public static final DecimalFormat df2 = new DecimalFormat("0.##");
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat sdShort = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat sdfCh = new SimpleDateFormat("yyyy年MM月dd日");
	public static final SimpleDateFormat sdfChWithBracket = new SimpleDateFormat("【yyyy】年【MM】月【dd】日");
	public static final SimpleDateFormat jddf = new SimpleDateFormat("yyyymmdd'T'HHmmss");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyymmddHHmmss");

	/***zft银行四要素鉴权,返回信息 -- 成功 ***/
	public  static final String RSPCD_SUCCESS="00";
	/***zft银行四要素鉴权,返回信息 -- 处理状态 ***/
	public  static final String RSPCD_PROCESSING="31";
	/***zft银行四要素鉴权,返回信息 -- 不支持该校验的银行 ***/
	public  static final String RSPCD_NOT_SUPPORT="P8";
	/*用户绑卡状态*/
	public  static final String CARD_STATUS_PROCESSING="PROCESSING"; // 银行卡状态 处理中
	public  static final String CARD_STATUS_FAILURE="FAILURE";// 银行卡状态  处理失败
	public  static final String CARD_STATUS_SUCCESS="SUCCESS";// 银行卡状态  处理完成
	public  static final String CARD_STATUS_UNBIND="UNBIND";// 银行卡状态  已解绑

	public  static final String BIND_CARD_SORCE_MANAGER="marger";// 银行卡绑卡来源  后台
	public  static final String BIND_CARD_SORCE_MARKET="market";// 银行卡绑卡来源 官网
	public  static final String BIND_CARD_SORCE_M="m";// 银行卡绑卡来源 M站

	/*第三方支付通道绑卡状态, 复用CARD_STATUS_UNBIND */
	public  static final String CARD_STATUS_WAIT_CHECK="WAIT_CHECK"; // 银行卡状态 等待确认--缺手机号
	public  static final String CARD_STATUS_ERROR="ERROR"; // 银行卡状态 卡状态异常，需要联系客服--银行卡和人不一致
	public  static final String CARD_STATUS_BIND="BIND";// 银行卡状态  已绑定

	/**
     * 债权还款日15
     */
    public static final short LOAN_RETURN_DATE_FIFTEEN = 15;

    /**
     * 债权还款日30
     */
    public static final short LOAN_RETURN_DATE_THIRTY = 30;

    public static final DecimalFormat decF = new DecimalFormat("0");
    public static final BigDecimal percentage = new BigDecimal("100");
    public static final  BigDecimal dayOfYear = new BigDecimal("365");
    //默认除法运算精度
    public static final int DEF_DIV_SCALE = 2;

    /**
     * guowt 模板文件类型
     */
    public final static String ZQZR_TEMPLATE = "100";//债权转让协议
    public final static String ZJBG_TEMPLATE = "101";//资金出借报告
    public final static String CJXY_TEMPLATE = "102";//出借协议

	/**
	 * @author haojunfu 赎回时，债权实际利息-投资人利息 下限 小于1分钱 则平台账户入账为0
	 *
	 */
    public static final BigDecimal PLAMTD_DIFF_AMOUNT = new BigDecimal("0.01");

    public static final Date activeStart = DateUtils.stringParseDate("2015-12-10 00:00:00.0", "yyyy-MM-dd hh:mm:ss.S");//双十二 活动结束时间
    public static final Date activeEnd = DateUtils.stringParseDate("2015-12-18 00:00:00.0", "yyyy-MM-dd hh:mm:ss.S");//双十二 活动开始时间


    public static final int PRODUCT_CONFIG_DEFAULT_INDEX = 999;//产品配置默认排序值，越大越排名越靠前

    public static final  BigDecimal redRate = new BigDecimal("6");//market 首页新手标 红包奖励率==  6% fhj 2012-12-22
    public static final  BigDecimal TEN_THOUSAND = new BigDecimal("10000");//market 首页新手标 一万元收益 fhj 2012-12-22
    public static final  BigDecimal FIFTY = new BigDecimal("50");//market 首页新手标 一万元收益 fhj 2012-12-22
    public static String SHOWRATE = "${fixedRate}%（项目收益）+6.00%（新人加息券收益）=${sumRate}%";
    public static String SHOWTENTHOUSAND = "投资1万元收益=${tenThousand}+50=${sumAmount}元";

    public static final String NEW_PRODUCT_NAME="新手标";
    public static final String NEW_PRODUCT_NAME_SHOW="新人福利计划";

  //2016 猜灯谜 活动开始时间
    public static final Date riddlesActiveStart = DateUtils.stringParseDate("2016-2-29 13:0:0.0", "yyyy-MM-dd hh:mm:ss.S");
  //2016 猜灯谜 活动结束时间
    public static final Date riddlesActiveEnd = DateUtils.stringParseDate("2016-2-29 23:59:59.999", "yyyy-MM-dd hh:mm:ss.S");
    //2016 超级转转赚 活动开始时间
    public static final Date superTurnActiveStart = DateUtils.stringParseDate("2016-3-23 23:59:59.999", "yyyy-MM-dd hh:mm:ss.S");
    //2016 超级转转赚 活动结束时间
    public static final Date superTurnActiveEnd = DateUtils.stringParseDate("2016-3-31 23:59:59.999", "yyyy-MM-dd hh:mm:ss.S");

    //2016 五一淘金热 活动开始时间
//    public static final Date GOLDRUSH2016Start = DateUtils.stringParseDate("2016-5-13 16:00:00.999", "yyyy-MM-dd hh:mm:ss.S");
//    //2016 五一淘金热 活动开始时间
    public static final Date GOLDRUSH2016Start = DateUtils.stringParseDate("2016-5-17 23:59:59.999", "yyyy-MM-dd hh:mm:ss.S");
    //2016 五一淘金热 活动结束时间
    public static final Date GOLDRUSH2016End = DateUtils.stringParseDate("2016-5-27 23:59:59.999", "yyyy-MM-dd hh:mm:ss.S");

    public static final  BigDecimal ONT_HUNDRED = new BigDecimal("100");//market 首页新手标 一万元收益 fhj 2012-12-22

    public static final  BigDecimal ONE_THOUSAND = new BigDecimal("1000");

    public static final  BigDecimal TEN_HUNDRED = new BigDecimal("10000");//

    public static final  BigDecimal ONE_HUNDRED_THOUSAND = new BigDecimal("100000");//

    public static final BigDecimal BASE_AMONT= new BigDecimal("25000");

    public static final String PRIZENAME_500= "500";

    public static  final String TEN_REDPACKAGE = "10元投资红包";

    public static  final String KEYWORD = "盖 章:";
    public static  final String NEW_AGREEMENT_KEYWORD = "证件类型：";
    public static  final String VERSION_THREE_KEYWORD = "乙方：北京紫貔财富网络科技有限公司";
    public static  final String LOAN_CONTRACT = "平台提供人";

    public static  final String RAISING_RATE_TYPE = "raising_rate_type";

	public static void main(String[] args) {
		System.out.println(jddf.format(new Date()));
		System.out.println(riddlesActiveStart.before(riddlesActiveEnd));
	}

	public final static String HTTP_REQUEST_INTERRUPTED_KEY="interruptedRequest";
	//产品类型：新手标
	public final static String FIRST_INVEST="FIRST_INVEST";
	//用于修改最小余额
	public final static String LOAN_ID="LOAN_ID";

	public static final  BigDecimal EXPERIENCE_RATE = new BigDecimal("5.80").setScale(2);// 体验金年化收益率

	public static final  String EXPERIENCE_REPAY_METHOD = "按日付息，到期体验金回收";// 体验金年化收益率

	//体验金类型
	public static final  String REGISTER_EXPERIENCETYPE_SYS="register";//注册体验金
	/**阶梯邀请首次投资**/
	public static final  String LADDER_INVITE_FIRST_INVEST="ladderInviteFirstInvest";

	//手机验证码类型
	public static final  String SMS_CAPTCHA_EXPERIENCE="experience";//注册体验金

	public static final int BIN_KILO = 1024;//2进制千
	public static final String ENCODING_GBK = "GBK";

	public static final Date DOUBLENINTHFESTIVAL2016START = DateUtils.stringParseDate("2016-10-08 23:59:59.999", "yyyy-MM-dd hh:mm:ss.S");

	public static final Date DOUBLENINTHFESTIVAL2016END = DateUtils.stringParseDate("2016-10-12 23:59:59.999", "yyyy-MM-dd hh:mm:ss.S");

	public static final String DOUBLENINTHFESTIVAL2016KEY = "DOUBLENINTHFESTIVAL2016KEY_";
	public static final int  BEACH_DOWNLOAD_COUNT=50;
	// 2016年双十一加息狂欢活动时间范围一【十一号】
	public static final Date INTERESTRATESCARNIVAL20161111START = DateUtils.stringParseDate("2016-11-10 22:30:00.000", "yyyy-MM-dd HH:mm:ss.S");
	public static final Date INTERESTRATESCARNIVAL20161111END = DateUtils.stringParseDate("2016-11-11 23:59:59.999", "yyyy-MM-dd HH:mm:ss.S");


	// 2016年双十一加息狂欢活动时间范围二【十二号】
	public static final Date INTERESTRATESCARNIVAL20161112START = DateUtils.stringParseDate("2016-11-12 00:00:00.000", "yyyy-MM-dd HH:mm:ss.S");
	public static final Date INTERESTRATESCARNIVAL20161112END = DateUtils.stringParseDate("2016-11-12 23:59:59.999", "yyyy-MM-dd HH:mm:ss.S");


	// 2016年双十一加息狂欢活动时间范围三【十三号】
	public static final Date INTERESTRATESCARNIVAL20161113START = DateUtils.stringParseDate("2016-11-13 00:00:00.000", "yyyy-MM-dd HH:mm:ss.S");
	public static final Date INTERESTRATESCARNIVAL20161113END = DateUtils.stringParseDate("2016-11-13 23:59:59.999", "yyyy-MM-dd HH:mm:ss.S");

	public static final String ACTIVITY_DOUBLEELEVEN_PRE_CACHE_NAME = "DOUBLEELEVEN_PRE_";

	public static final String ACTIVITY_DOUBLEELEVEN_TIME_START = "ACTIVITY_DOUBLEELEVEN_TIME_START";//双十一活动开始时间
	public static final String ACTIVITY_DOUBLEELEVEN_TIME_END = "ACTIVITY_DOUBLEELEVEN_TIME_END";//双十一活动结束时间
	public static final String ACTIVITY_TIME_TYPE = "ACTIVITY_TIME";//活动时间type
	public static final String TIME_SEPARATOR = "&&";//时间分割符

	public static final String EXP_TRADE_DETAIL_ORDER_TYPE = "TYZC";//体验金转出明细订单号类型
	public static final String PROJECT_AMOUNT="PROJECT_AMOUNT";//项目金额
	public static final String NY_REMAIN_AMOUNT="NY_REMAIN_AMOUNT";//元旦活动剩余金额
	public static final String ACTIVITY_TIME="ACTIVITY_TIME";//活动时间
	/**普标--资产标--图片**/
	public static final String ASSET_COMMON_IMG="http://rmbboximage.b0.upaiyun.com/m5/corner-common.png";
	/**普标--资产标--图片**/
	public static final String ASSET_GOLDEN_IMG="http://rmbboximage.b0.upaiyun.com/m5/corner-gold.png";
	/**普标--资产标--图片**/
	public static final String ASSET_DIAMOND_IMG="http://rmbboximage.b0.upaiyun.com/m5/corner-diamond.png";
	/**普标--资产标--图片**/
	public static final String ASSET_FIRST_INVEST_IMG="http://rmbboximage.b0.upaiyun.com/m5/corner-newuser.png";


	public static final String FLAG_COUNTRATE = "flagCountRate";

	/**-------------------------------2017一起快乐 跨年活动------------------------------------------***/

	public static final String ACTIVITY_NEWYEAR2017_PRE_CACHE_NAME = "ACTIVITY_NEWYEAR2017_PRE_";

//	public static final String ACTIVITY_NEWYEAR2017_TIME_START = "ACTIVITY_NEWYEAR2017_TIME_START";//2017跨年活动开始时间
//	public static final String ACTIVITY_NEWYEAR2017_TIME_END = "ACTIVITY_NEWYEAR2017_TIME_END";//2017跨年活动结束时间

	public static final String VALENTINE_2017_TYPE="VALENTINE_2017_TYPE";
	public static final String VALENTINE_2017_VALUE="SUPER_DIAMOND_2017";

	public static final String VERIFY_MODE="verifyMode";
	/**-----------------------------cmsArticle过滤时间--------------------------------------------***/
	public static final Date CMSARTICLETIME = DateUtils.stringParseDate("2016-01-01 00:00:00.000", "yyyy-MM-dd HH:mm:ss.S");
	/**获取产品模版的路径**/
	public static final String EXCHAGE_TEMPLATE_PATH = "/APP_DICT/RMBBOX/TEMPLATE";
	
	public static final String EXCHAGE_TEMPLATE_B_PATH = "/APP_DICT/RMBBOX/TEMPLATE/WJS/WJS_B";
	
	public static final DecimalFormat df3 = new DecimalFormat("#,##0");
	/**三八节活动*/
	public static final String WOMENDAY_PRIZE_TYPE="WOMENDAY_PRIZE_TYPE";
	public static final String WOMENDAY_PRIZE_VALUE_MEN="WOMENDAY_PRIZE_VALUE_MEN";
	public static final String WOMENDAY_PRIZE_VALUE_WOMEN="WOMENDAY_PRIZE_VALUE_WOMEN";
	public static final String WOMEDAY_LOAN_DAYS_TYPE = "WOMEDAY_LOAN_DAYS_TYPE";
	public static final String WOMEDAY_LOAN_DAYS_VALUE = "WOMEDAY_LOAN_DAYS_VALUE";
	public static final Date WOMENDAY_START_TIME =  DateUtils.stringParseDate("2017-03-01 00:00:00.000","yyyy-MM-dd HH:mm:ss.S");
	public static final Date WOMENDAY_END_TIME =  DateUtils.stringParseDate("2017-03-10 23:59:59.999","yyyy-MM-dd HH:mm:ss.S");
	//微信点赞上限
	public static final Integer WECHAT_LIKEIT_SUPER_LIMIT = 17;
	public static final String[] WECHATWISHARRAY={"祝您鸡祥如意","祝您万事大吉","祝您阖家安康","祝您心想事成",
		"祝您金玉满堂","祝您一帆风顺","祝您财源广进","祝您吉星高照","祝您万事亨通","祝您前程似锦"};

	public final static String SMS_PREFIX  = "亲，";
	public final static String SMS_SUFFIX  = "，如有疑问，详询：4009-088-988";

	public final static String INTERNAL_MAIL_PREFIX  = "亲爱的糖豆，";
	public final static String INTERNAL_MAIL_SUFFIX  = "，如有疑问，详询：4009-088-988";

	public final static String XW_NOTICE_PREFIX  = "XW_NOTICE_PRIFIX:";

	public final static String XW_CHANGE_FLAG  = "1";

	public final static int XW_CHANGE_LIVETIME  = 30;

	public final static String SHARE_AUTOMATIC  = "shareAutomatic";
	public final static String LOAN_AUTOMATIC   = "loanAutomatic";
	public final static String GUARANTOR_AUTOMATIC  = "guarantorAutomatic";

//	public final static int investmentRequestCapacity  = 1;
	public final static int investmentRequestCapacity  = 90;

	//匹配任务停止标识key
	public final static String FLAG_MATCH_TASK_STOP  = "intelligentMatchTaskStopFlag";
	//是否再次匹配标识key
	public final static String FLAG_AGAIN_MATCH_KEY  = "againIntelligentMatchFlag";
	//正在匹配标识key
	public final static String FLAG_MATCHING_KEY  = "againIntelligentMatchingFlag";
	//产品匹配标识
	public final static String FLAG_LOAN_MATCHING_KEY  = "autoMatchingFlagByLoanId:";

	public static final int SHORT_TERM_DAYS = 45;

	public static final int OPEN_DATA_SHARE_100 = 100;

	public static final int OPEN_DATA_SHARE_500 = 500;

	public static final int TOTAL_DATA_SHARE = 1024*10000;



	/**流量分享活动开始时间**/
	public static final Date ACTIVITY_DATA_SHARE_START_TIME = DateUtils.stringParseDate("2017-08-01 00:00:00.000", "yyyy-MM-dd HH:mm:ss.S");
	/**流量分享活动结束时间**/
	public static final Date ACTIVITY_DATA_SHARE_END_TIME = DateUtils.stringParseDate("2017-08-31 23:59:59.999", "yyyy-MM-dd HH:mm:ss.S");

	public static final String[] DATASHARE_RETURNPAGE = {"overDataPage","openDataPage","500DataPage","600DataPage","dataRegisterPage","falseOpenDataPage"};

	/** 首尾出借标签 */
	public static final String LABELS_LEND_GIFT = "LabelsForLendGift:";

	/** 标的详情页活动链接 */
	public static final String LOAN_DETAIL_AD_URL = "LoanDetailADUrl:";

	public static final String FAKE_IOS_VERSION = "6.1.0";
	
	public final static String LiRenFenQi_Source  = "lirenfenqiBBT001";

	/** 用户新手任务完成列表 */
	public static final String INVESTOR_TASK_LIST = "investor_task_list:";

	public final static String LOAN_CHANNEL = "LoanChannel";

	public final static String LOAN_CHANNEL_ITEM = "LoanChannelItem";

	/** 逾期截止时间 在该截止时间之前逾期数据不在出借账户我要代偿范围之内  **/
	public final static String OVERDUEDATE = "2017-11-20 00:00:00";

	/** 债转管理费率  **/
	public final static BigDecimal 	CREDIT_MANAGE_RATE = new BigDecimal("0.002");
}