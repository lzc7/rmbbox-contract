package com.zipi.enums.core;

import com.zipi.base.BaseEnum;
import com.zipi.enums.bbt.InvestStatus;
import com.zipi.enums.loan.LoanRequestStatus;
import com.zipi.enums.loan.LoanStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by veryyoung on 2015/7/3.
 */
public enum OperationType implements BaseEnum {


    REGISTER("注册"),
    REGISTER_DEPOSITORY("开通银行存管"),
    IDENTITY_AUTH_BBT("邦帮堂身份认证"),
    BIND_CARD("绑定银行卡"),
    EMAIL_AUTH("邮箱认证"),
    MOBILE_AUTH("手机认证"),
    LOGIN_PWD_SET("登录密码设置"),
    PAY_PWD_SET("支付密码设置"),
    CHANGE_CARD("更换绑定银行卡"),
    CHANGE_MOBILE("更换绷定手机号码"),
    PAY_INFO_SET("支付信息设置,包含身份认证"),
    UNBUNDING_CARD("解绑银行卡"),
    PRE_COMPENSATORY("代偿预授权"),
    PRE_FEE_COMPENSATORY("服务费代偿预授权"),
    COM_COMPENSATORY("代偿确认"),
    COM_COMPENSATORY_SUMMARY("代偿确认"),
    COM_FEE_COMPENSATORY("服务费代偿确认"),
    SUB_COMPENSATORY("代偿扣款"),
    IN_COMPENSATORY("代偿中转入账"),
    IN_COMPENSATORY_SUMMARY("代偿中转入账"),
    OUT_COMPENSATORY("代偿中转出账"),
    OUT_COMPENSATORY_SUMMARY("代偿中转出账"),
    REPAY_COMPENSATION("还代偿预授权"),
    COM_REPAY_COMPENSATION("还代偿确认"),
    IN_REPAY_COMPENSATION("还代偿入账"),
    FREEZE_USER_AMOUNT("冻结用户金额"),
    RELEASE_USER_AMOUNT("解冻用户金额"),
    REPAY_RAISE_AMOUNT("加息券"),
    REPAY_GUARANTEE_FEE("担保费"),
    REPAY_SHARE_FEE("分润费"),
    REPAY_SERVICE_FEE("平台服务费"),
    DIRECT_DEDUTION("小额免密扣费"),
    RECHARGE_DEDUTION("话费充值扣费"),
    RECHARGE_FEE("话费充值"),

    // 用户出借使用(保存至core_user_fund_record的operation_type字段)
    INVEST("出借"),
    INVEST_BBT_SETTLE("出借解冻"),
    // 显示用户账户日历时使用(未保存至数据库)
    INVEST_BBT("出借网贷项目"),
    INVEST_UPLAN("出借优选"),

    // 居间人使用(保存至core_user_fund_record的operation_type字段)
    INVEST_IN("出借入账"),

    MANUAL_FULL_SCALE("手动满标"),

    // 用户零存宝转出时使用(保存至core_user_fund_record的operation_type字段)
    CURRENT_OUT("零存宝转出"),

    // 显示用户账户日历时使用(未保存至数据库)
    INVEST_CURRENT_DEPOSIT("转入零存宝"),
    INVEST_MONTH_WIN("出借月盈计划"),
    INVEST_RECYCLE_INTEREST("出借复利计划"),
    INVEST_FIXED_DEPOSIT_1("出借定期计划A"),
    INVEST_FIXED_DEPOSIT_3("出借定期计划B"),

    INVEST_FIXED_DEPOSIT_6("出借定期计划C"),
    INVEST_FIXED_DEPOSIT_9("出借定期计划D"),
    REDEMPTION_CURRENT_DEPOSIT("零存宝转出"),
    REDEMPTION_MONTH_WIN("月盈计划出借还款"),
    REDEMPTION_RECYCLE_INTEREST("复利计划出借还款"),
    INVEST_REPAY_REGULAR ("定期理财出借还款"),
    INVEST_REPAY_DEPOSIT("定期计划出借还款"),
    INVEST_REPAY_BBT("网贷项目出借还款"),
    INVEST_REPAY_UPLAN("原优选计划出借还款"),

    AUTO_WITHDRAW("自动提现"),
    WITHDRAW("提现"),
    WITHDRAW_APPLY("提现申请"),
    WITHDRAW_SUBMIT("提现提交"),
    WITHDRAW_SUCCESS("提现成功"),
    DEPOSIT("充值"),
    CALLBACK_DEPOSIT("资金回退充值"),
    LOAN("放款"),
    LOAN_REPAY("贷款还款"),
    LOAN_REPAY_SUMMARY("贷款还款"),
    DISBURSE("垫付还款"),
    INVEST_REPAY("出借回款"),
    INVEST_REWARD_REPAY("出借回款"),
    CREDIT_ASSIGN("债权转让"),

    SETTLEMENT("账户结算"),// 账户结算

    ACCOUNT_CHECK("平台对账"),// 平台对账使用 add by zcc 2016-2-3


    EXPERIENCE_CHECK("体验金对账"),// 体验金对账使用 fhj 2016-08-29

    TRANSFER("转账扣款"),//商户用
    TRANSFER_REQUEST("商户向用户转账申请"),
    TRANSFER_IMPORT_REQUEST("批量导入商户向用户转账申请"),
    TRANSFER_CHECK_REQUEST_PASSED("商户向用户转账审核-通过"),
    TRANSFER_CHECK_REQUEST_UNPASSED("商户向用户转账审核-拒绝"),

    PAY_2_OWNER("付款至个人银行账户"),//add by zcc

    /********
     * 手机APP操作
     */
    APP_DEPOSIT("手机充值"),
    APP_INVEST_BBT("手机出借邦帮堂"),
    APP_INVEST_UPLAN("手机出借优选"),

    NOTHING("无"),
    /**
     * 奖励
     */
    REWARD_REGISTER("注册奖励"),
    REWARD_REDELIVERY("复投奖励"),
    REWARD_REFERRAL("推荐奖励"),
    REWARD_REFERRAL_NEW("新推荐奖励"),
    REWARD_INVEST("投标奖励"),
    REWARD_DEPOSIT("充值奖励"),
    REWARD_COMMISSION("佣金提成"),
    REWARD_COMMISSION_ACCOUNT("佣金提成"),
    REWARD_ACTIVITY("活动奖励"),
    REWARD_CASH_PACKET("现金红包"),
    REWARD_GIFT_SEND("发放红包"),
    REWARD_GIFT_BATCH_SEND("批量发放红包"),
    RAISINGRATES_SEND("发放加息券"),
    RAISINGRATES_BATCH_SEND("批量发放加息券"),
    EXPERIENCE_BATCH_SEND("批量发放体验金"),
    MANAGER_SWITCH_CONTROL("后台开关控制"),
    SPRING_FESTIVAL_CASH_2017("2017春节红包活动现金红包"),
    LANTERN_2017_CASH("元宵节活动现金红包"),
    LANTERN_2017_CASH_DES("2017元宵节红包"),

    DRAGON_2017_CASH("龙抬头活动现金红包"),
    DRAGON_2017_CASH_DES("2017龙抬头红包"),

    VALENTINE_2017_CASH("情人节活动现金红包"),
    VALENTINE_2017_CASH_DES("2017情人节红包"),
    SPE_RED_PACKET_CASH("财源滚滚现金红包"),
    SPE_RED_PACKET_CASH_DES("财源滚滚红包"),

    /**
     * 红包
     */
    RED_PACKAGE_BACK("红包奖励"),
    /**
     * 项目当日计息奖励
     */
    PROJECT_RAISE_INTEREST("活动奖励"),

    RED_PACKAGE_PRESENT("红包转赠"),
    /**
     * 2016元宵猜灯谜活动返现
     */
    RIDDLES2016_BACK("猜灯谜红包奖励"),

    GOLDRUSH2016_BACK("淘金热现金返现"),
    CHILD2016_BACK("六一现金红包"),
    /**
     * 用户体验
     */
    USER_EXPERIENCE_INTEREST("体验金收益"),
    USER_RAISE_INTEREST("加息券出借收益"),
    /**
     * 服务管理手续费
     */
    FEE_BACK("退手续费"),
    FEE_CURRENT_OUT("零存宝转出手续费"),
    FEE_INVEST_REPAY("赎回手续费"),
    FEE_WITHDRAW("提现手续费"),
    FEE_AUTHENTICATE("身份验证手续费"),
    FEE_INVEST_INTEREST("出借管理费"),
    FEE_LOAN_SERVICE("借款服务费"),
    FEE_LOAN_SHARE("借款分润费"),
    FEE_LOAN_MANAGE("借款管理费"),
    FEE_LOAN_INTEREST("还款管理费"),
    FEE_LOAN_VISIT("实地考察费"),
    FEE_LOAN_GUARANTEE("担保费"),//一般对应担保类贷款
    FEE_LOAN_RISK("风险管理费"),//一般对应信用类贷款
    FEE_LOAN_OVERDUE("逾期管理费"),
    FEE_LOAN_PENALTY("逾期罚息(给商户)"),//商户收取
    FEE_LOAN_PENALTY_INVEST("逾期罚息(给出借人)"),//出借人收取
    FEE_DEPOSIT("充值手续费"),
    FEE_ADVANCE_REPAY("提前还款违约金(给商户)"),//商户收取
    FEE_ADVANCE_REPAY_INVEST("提前还款违约金(给出借人)"),//出借人收取
    FEE_CREDIT_ASSIGN("债权转让手续费"),
    FEE_BIND_CARD("用户绑卡手续费"),//联动在用户绑卡时需要从商户中扣除1分钱


    FEE_REDEMPTION_CURRENT("活期赎回手续费"),//活期赎回手续费--存入平台账户C
    FEE_REDEMPTION_FIXED("非活期赎回手续费"),//非活期赎回手续费--存入平台账户C
    MANAGE_FEE_FIXED("非活期赎回管理费"),//非活期赎回手续费--存入平台账户C
    FEE_REDEMPTION_FIXED_DIFF("定期宝赎回利息差"),//定期宝赎回时，债权实际收益-个人利息 所得的利息差
    REDEMPTION_SERVICE_CHARGE("赎回平台服务费"),// 赎回平台服务费


    POST_LOAN("发布新标"),

    /**
     * 用户类活动
     */
    USER_ENABLE("开启用户"),
    USER_DISABLE("关闭用户"),
    USER_MOBILE_CHANGE("用户交换手机号"),
    USER_SAVE_RECOMMENDINFO("用户保存推荐人信息"),
    /**
     * 贷款申请类活动
     */
    REQUEST_SUMBIT("提交贷款申请"),
    REQUEST_ASSIGN(LoanRequestStatus.ASSIGNED.getKey()),
    REQUEST_ASSIGN_VISIT_TASK("分配外审任务"),
    REQUEST_VISIT_REVIEW("外勤评审"),
    REQUEST_ASSIGN_RISK_TASK("分配风控任务"),
    REQUEST_RISK_REVIEW("风控评审"),
    REQUEST_CANCELL(LoanRequestStatus.CANCELED.getKey()),
    REQUEST_APPROVE(LoanRequestStatus.APPROVED.getKey()),
    REQUEST_PUBLISH(LoanRequestStatus.PUBLISHED.getKey()),
    REQUEST_REJECT(LoanRequestStatus.REJECTED.getKey()),
    REQUEST_ARCHIVE(LoanRequestStatus.ARCHIVED.getKey()),
    /**
     * 贷款类活动
     */
    LOAN_SPLIT("拆标"),
    LOAN_SCHEDULE(LoanStatus.SCHEDULED.getKey()),
    LOAN_RESCHEDULE("重新安排"),
    LOAN_OPEN(LoanStatus.OPENED.getKey()),
    LOAN_FAIL(LoanStatus.FAILED.getKey()),
    LOAN_CANCEL(LoanStatus.CANCELED.getKey()),
    LOAN_FINISH(LoanStatus.FINISHED.getKey()),
    LOAN_SETTLE(LoanStatus.SETTLED.getKey()),
    LOAN_SETTLE_SUMMARY("放款"),
    LOAN_DISBURSE("垫付"),
    LOAN_CLEAR(LoanStatus.CLEARED.getKey()),
    LOAN_OVERDUE(LoanStatus.OVERDUE.getKey()),
    LOAN_BREACH(LoanStatus.BREACH.getKey()),
    LOAN_REWARD("奖励"),
    LOAN_ARCHIVE(LoanStatus.ARCHIVED.getKey()),
    LOAN_ADD_RECOMMEND("设置推荐标"),
    LOAN_DEL_RECOMMEND("取消推荐标"),
    LOAN_ALTER("修改标的信息"),
    /**
     * 合同类活动
     */
    CONTRACT_REGENERATE("重新生成合同"),
    /**
     * 投标类活动
     */
    INVEST_CANCEL(InvestStatus.CANCELED.getKey()),
    /**
     * 提现类活动
     */
    WITHDRAW_DOWNLOAD_UNPROCESSED_TOPAY("下载未处理提现信息-支付使用"),
    WITHDRAW_DOWNLOAD_UNPROCESSED_TOINNER("下载未处理提现信息-内部使用"),
    WITHDRAW_DOWNLOAD_PROCESSING_BYBATCHNO("下载处理中提现信息-按批次号"),
    WITHDRAW_IMPORT_RESULT("提现结果导入"),
    WITHDRAW_CHECK_RESULT_PASSED("提现导入结果审核-通过"),
    WITHDRAW_CHECK_RESULT_BATCH_PASSED("提现导入结果审核-批量"),
    WITHDRAW_CHECK_RESULT_UNPASSED("提现导入结果审核-拒绝"),
    /**
     * 优选计划
     */
    UPLAN_ADD_SAVE("优选计划-发布新产品-保存"),
    UPLAN_ADD_OPEN("优选计划-发布新产品-立即发布"),
    UPLAN_ADD_LOAN("优选计划-新增债权"),
    UPLAN_SETTLE("优选计划结算"),
    UPLAN_EDIT_SAVE("优选计划-修改未发布产品-保存"),
    UPLAN_EDIT_OPEN("优选计划-修改未发布产品-立即发布"),
    UPLAN_DETAIL_EDIT_NAME("优选计划-优选项目列表-详情-修改产品名称"),
    UPLAN_DETAIL_EDIT_OPEN("优选计划-优选项目列表-详情-立即发布"),
    UPLAN_REPAY("优选计划还款"),

    /**
     * 推送
     */
    PUSH_BATCH_SEND("消息的批量推送"),


    /**
     * 债权产品
     */
    CURRENT_INTEREST("活期生成利息"),
    CURRENT_INTEREST_FAILURE("活期生成利息失败"),
    FIXED_REDEMPTION("非活期赎回"),
    CLAIM_LOAN_ADD("债权新增"),
    CLAIM_LOAN_IMPORT("债权批量导入"),
    CLAIM_AUTO_DAYTASK("日终任务报错时发送短信息"),
    /**
     * 短信快捷登陆
     */
    CONFIRM_CREDITMARKET_QUICKLOGIN("短信快捷登陆时发送验证码短信"),
    BBG_CONFIRM_CREDITMARKET_QUICKLOGIN("授权邦帮团短信快捷登陆时发送验证码短信"),
    /**
     * 注册发送验证码短信
     */
    SMS_CONFIRM_REGISTER("注册时发送验证码短信"),
    BBG_SMS_CONFIRM_REGISTER("授权邦帮团注册时发送验证码短信"),
    CONFIRM_CREDITMARKET_REGISTER_WITH_EXPERIENCE("注册时发送验证码短信(专用于体验标注册)"),
    CASH_PACKET_CAPTCHA("现金红包领取短信"),
    REGISTER_DRAGON_HEAD("龙抬头注册短信"),

    CURRENT_REDEMPTION_ERROR("活期赎回问题记录"),

    XW_USER_ACTIVATION("新网用户激活"),

    USER_AUTHORIZATION("新网用户授权"),
    XW_INVEST_CONFIRM("新网出借确认"),
    INVEST_CONFIRM("出借确认"),
    AUTO_INVEST_PRE("自动出借预处理"),
    APPOINTMENT_UNFREEZE("自动出借资金解冻"),
    LOAN_STATUS_UPDATE("标的状态更新"),
    /**
     * 扣减
     */
    DEDUCTION_CASH_PACKET("现金红包扣减"),

    PRE_REPAY("还款预授权"),
    ENTERPRISE_UPDATE("企业信息变更"),
    ORDERCHECKFILE_DOWNLOAD("文件对账下载"),
    ENTERPRISE_REGISTER("企业绑卡注册"),
    PRE_SERVICE_REPAY("还服务费预处理"),
    SERVICE_FEE_REPAID("服务费到账"),
    APPOINTMENT_FREEZE("预约投资冻结"),
    APPOINTMENT_CANCEL("自动出借取消"),

    ONE_ARMED_BANDIT("欢乐老虎机"),
    EVERY_DAY_LOTTERY_DRAW("每日抽奖"),
    DATA_SHARE("全民疯抢流量分享"),
    INVITING_FRIENDS("邀请好友"),
    FIREST_INVEST("首次出借"),
    EXCHANGE_FLOW("流量提取"),
    PRENATIONALDAY_FLOW("双节提前庆流量"),
    EXCHANGE_FARE("兑换话费"),
    PRESENT_FLOW("转赠流量"),
    RECEIVED_FLOW("好友流量转赠"),

    SHARE_REDPACKET("出借分享红包"),
    BBG_REWARD_EXTRACT("帮帮团奖金提取"),
    BBG_GRANT_REGISTER("授权注册"),
    DEDUCT("小额免密扣费"),
    DOUBLE11_2017_LAMP("双十一跑马灯"),

    TASK_INVEST_100("单笔出借≥100元"),
    TASK_INVEST_1000("单笔出借≥1000元"),
    TASK_INVEST_10000("单笔出借≥10000元"),
    TASK_FIRST_INVEST_5000("首位出借且单笔金额≥5000元"),
    TASK_END_INVEST_1000("单笔满标且金额≥1000元"),
    TASK_INVEST_100000("单笔出借≥100000元"),
    TASK_INVEST_500000("单笔出借≥500000元"),
    TASK_INVEST_1000000("单笔出借≥100万元"),
    TASK_INVITATION_1000("邀请好友单笔出借≥1000元"),
    TASK_INVITATION_5000("邀请好友单笔出借≥5000元"),
    TASK_INVITATION_10000("邀请好友单笔出借≥10000元"),
    TASK_INVITATION_100000("邀请好友单笔出借≥100000元"),
    TASK_INVITATION_300000("邀请好友单笔出借≥30万元"),

    TASK_APPOINTMENT_100("单笔自动授权出借金额≥100元"),
    TASK_APPOINTMENT_5000("单笔自动授权出借金额≥5000元"),
    TASK_APPOINTMENT_10000("预约单笔出借≥10000元"),
    TASK_APPOINTMENT_50000("预约单笔出借≥50000元"),
    TASK_APPOINTMENT_100000("预约单笔出借≥100000元"),
    TASK_APPOINTMENT_300000("预约单笔出借≥30万元"),
    TASK_INCOME_1000("单笔预期收益≥1000元"),
    TASK_INCOME_3000("单笔预期收益≥3000元"),
    TASK_INCOME_5000("单笔预期收益≥5000元"),
    TASK_INCOME_10000("单笔预期收益≥10000元"),
    TASK_INCOME_50000("单笔预期收益≥50000元"),
    TASK_IINCOME_100000("单笔预期收益≥10万元"),

    TASK_OPENXW("开通银行存管"),
    TASK_STAGE_1("完成初级任务"),
    TASK_STAGE_2("完成进阶任务"),
    TASK_STAGE_3("完成终极任务"),
    TASK_BIND_WECHAT("绑定邦帮堂公众号"),
    TASK_SIGN("邦帮堂办公地点签到"),
    TASK_REGISTER("注册成功"),

    INVEST_COMPENSATORY_REPAYMENT("代偿还款"),
    OVERDUE_REPAYMENT("逾期还款"),
    INVEST_FORWARD("出借账户转账平台账户"),

    CANCEL_USER_AUTHORIZATION("新网用户取消授权"),

    /** 债权转让 */
    CREDIT_SETTLE("债权回款"),
    CREDIT_SETTLE_MANAGE("转让管理费"),
    CREDIT_ASSIGNMENT("出借债转"),
    CREDIT_ASSIGNMENT_SETTLE("债转出借解冻"),
    CREDIT_ASSIGNMENT_REPAY("出借债转回款"),
    T_CREDIT_SETTLE("垫资回购确认"),
    CREDIT_CANCEL("债权取消"),
    CREDIT_CLEAR("债权结清"),
    CUSHION_PAYMENT_CLEAR("垫资结清"),
    CREDIT_REPAY_RAISE_AMOUNT("债权加息券收益"),
    T_CREDIT_ASSIGNMENT("垫资债权认购"),

    CANCEL_PRE_TRANSACTION("预处理取消");

    private final String key;

    private OperationType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    public static List<OperationType> transferTypeForMG() {
        List<OperationType> transferTypeList = new ArrayList<>();
        transferTypeList.add(OperationType.TRANSFER);
        transferTypeList.add(OperationType.REWARD_COMMISSION);
        transferTypeList.add(OperationType.REWARD_ACTIVITY);
        transferTypeList.add(OperationType.RED_PACKAGE_BACK);
        transferTypeList.add(OperationType.REWARD_REFERRAL);
        transferTypeList.add(OperationType.FEE_BACK);
        transferTypeList.add(OperationType.REWARD_CASH_PACKET);
        return transferTypeList;
    }

    public static List<OperationType> listOtherTypes(List<OperationType> operationTypes) {
        List<OperationType> otherTypes = new ArrayList<>();
        List<OperationType> types = operationTypes;
        for (OperationType fundRecordType : Arrays.asList(OperationType.values())) {
            if (!types.contains(fundRecordType)) {
                otherTypes.add(fundRecordType);
            }
        }
        return otherTypes;
    }






    public static OperationType getValue(String key){
        for(OperationType type : OperationType.values()){
            if(key.equals(type.getKey()))
                return type;
        }
        return OperationType.NOTHING;
    }

    public static List<OperationType> listForUserFlow() {
        List<OperationType> flowList = new ArrayList<>();
        flowList.add(OperationType.REGISTER);
        flowList.add(OperationType.REGISTER_DEPOSITORY);
        flowList.add(OperationType.ONE_ARMED_BANDIT);
        flowList.add(OperationType.EVERY_DAY_LOTTERY_DRAW);
        flowList.add(OperationType.DATA_SHARE);
        flowList.add(OperationType.INVITING_FRIENDS);
        flowList.add(OperationType.FIREST_INVEST);
        flowList.add(OperationType.EXCHANGE_FLOW);

        return flowList;
    }

    public static boolean checkUserFlowType(OperationType type) {
        List<OperationType> typeList = listForUserFlow();
        return typeList.contains(type);
    }

    //资金流水-债转
    public static List<OperationType> fundRecordListForCredit(){
        List<OperationType> creditList = new ArrayList<>();
        creditList.add(OperationType.CREDIT_ASSIGNMENT);
        creditList.add(OperationType.CREDIT_ASSIGNMENT_SETTLE);
        creditList.add(OperationType.CREDIT_SETTLE);
        creditList.add(OperationType.CREDIT_SETTLE_MANAGE);
        creditList.add(OperationType.CREDIT_CLEAR);
        return creditList;
    }
}
