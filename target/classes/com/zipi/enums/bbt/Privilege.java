/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.enums.bbt;

import com.zipi.base.BaseEnum;

import java.util.*;

/**
 * 员工权限集合
 *
 * @author sobranie
 */
public enum Privilege implements BaseEnum {

    /******************************************************************系统管理***********************************/
    /**
     * 员工相关权限
     */
    EMPLOYEE_LIST("员工列表", Realm.EMPLOYEE, "员工,角色管理权限"),
    EMPLOYEE_ALTER("员工列表-【增加员工,编辑,启用,禁用】", Realm.EMPLOYEE, "员工,角色管理权限"),
    EMPLOYEE_DETAIL("员工列表-【员工详情】", Realm.EMPLOYEE, "员工,角色管理权限"),
    EMPLOYEE_OWN_ROLES_SAVE("员工列表-【员工详情【保存】】", Realm.EMPLOYEE, "员工,角色管理权限"),
    USER_RESETPASSWORD("员工列表-【员工详情【重置密码】】", Realm.EMPLOYEE, "员工,角色管理权限"),
    SYSTEM_SETTING("员工密码设置",Realm.EMPLOYEE,"员工,角色管理权限"),//系统设置

    EMPLOYEE_ROLES("角色权限列表", Realm.EMPLOYEE, "员工,角色管理权限"),//角色权限
    EMPLOYEE_ROLES_ADD("角色权限列表-【新增】", Realm.EMPLOYEE, "员工,角色管理权限"),//角色权限
    EMPLOYEE_ROLES_SAVE("角色权限列表-【保存】", Realm.EMPLOYEE, "员工,角色管理权限"),//角色权限
    EMPLOYEE_ROLES_DELETE("角色权限列表-【删除】", Realm.EMPLOYEE, "员工,角色管理权限"),//角色权限
//    EMPLOYEE_MANAGER_SWITCH_CONTROL("系统管理-账户管理",Realm.EMPLOYEE,"员工,角色管理权限"),//角色权限
//    STAFF_DATA_IMPORT("员工数据导入",Realm.EMPLOYEE,"员工,角色管理权限"),
    
    /**
     * 用户相关权限
     */
    USER_LIST("个人用户列表", Realm.USER, "用户管理相关权限"),//个人用户

    USER_ADD("个人用户列表-【增加用户】", Realm.USER, "用户管理相关权限"),
    USER_DOWNLOAD("个人用户列表-【下载列表】", Realm.USER, "用户管理相关权限"),
//    USER_ALTER("个人用户列表-【编辑,启用，禁用，补充推荐人】", Realm.USER, "用户管理相关权限"),
    USER_ALTER("个人用户列表-【启用，禁用，解冻交易密码】", Realm.USER, "用户管理相关权限"),
    ENTERPRISE_USER_LIST("企业用户列表", Realm.USER, "用户管理相关权限"),//个人用户
    ENTERPRISE_USER_ALTER("企业用户列表-【增加，编辑，启用，禁用，解冻交易密码】", Realm.USER, "用户管理相关权限"),

    USER_DETAIL_ALTER("个人/企业用户列表-【用户详情【用户信息保存修改，换绑银行卡】】", Realm.USER, "用户管理相关权限"),

    USER_WHITE_LIST("白名单管理", Realm.USER, "用户管理相关权限"),//白名单管理
    USER_MOBILE_CHANGE("互换手机号", Realm.USER, "用户管理相关权限"),//两个用户互换手机号

    /**
     * **
     * 栏目相关权限
     */
    CHANNEL_LIST("cms管理", Realm.CHANNEL, "cms管理相关权限"),//cms管理
    CHANNEL_ADD("创建栏目", Realm.CHANNEL, "cms管理相关权限"),
    CHANNEL_ALTER("栏目-【修改,删除】", Realm.CHANNEL, "cms管理相关权限"),
    /**
     * 文章相关权限
     */
    ARTICLE_ALTER("文章列表-【添加文章,编辑,删除，置顶】", Realm.CHANNEL, "cms管理相关权限"),
    /**
     * 客服统计信息用户回访相关
     */
    CUSTOMER_STATIS_USERCALLED("电话回访", Realm.KEFUCALLED, "回访相关"),//电话回访
    CUSTOMER_STATIS_DOWNLOAD("电话回访-回访列表下载", Realm.KEFUCALLED, "回访相关"),

    SERVICE_MESSAGE_LIST("留言管理", Realm.KEFUCALLED, "回访相关"),

    DICT_MANAGER("字典管理",Realm.DICT_MANAGER,"字典管理"),
    /******************************************************************系统管理***********************************/
    
    /******************************************************************产品管理***********************************/
    /**
     * 网贷项目——借款相关
     */
//    LOAN_QUICKLOANREQUEST_PERSON("发布新产品【个人】", Realm.LOANREQUEST, "网贷项目"),//发布新产品
//
//    LOAN_QUICKLOANREQUEST_ENTERPRISE("发布新产品【企业】", Realm.LOANREQUEST, "网贷项目"),//发布新产品

    LOAN_QUICKLOANREQUEST("发布新产品", Realm.LOANREQUEST, "网贷项目"),//发布新产品

//    LOAN_DETIAL("借款详情【借款标题链接页面】", Realm.LOANREQUEST, "网贷项目"),
    
    LOAN_LOANLIST("网贷项目", Realm.LOANREQUEST, "网贷项目"),//网贷项目
    LOAN_DOWNLOAD("网贷项目-借款列表下载", Realm.LOANREQUEST, "网贷项目"),
    LOANREQUEST_IMMEDIATELY_CHANGE ("网贷项目-【保存未发布-借款信息-立即修改】", Realm.LOANREQUEST, "网贷项目"),
    LOANREQUEST_CONTRACT_VIEW("网贷项目-【投资记录-查看合同】", Realm.LOANREQUEST, "网贷项目"),
    LOANREQUEST_SAFETY_CER_OPERATION ("网贷项目-【安全认证-{批准发布,拒绝发布等}】", Realm.LOANREQUEST, "网贷项目"),
//    LOANREQUEST_REJECT("网贷项目-【保存为发布-借款信息-拒绝发布】", Realm.LOANREQUEST, "网贷项目"),
    LOAN_ARCHIVE("网贷项目-【已还清-存档】", Realm.LOANREQUEST, "网贷项目"), //将已还清的借款标进行归档/隐藏
    

    LOAN_INTELLIGENTLOANLIST("授权项目",Realm.LOANREQUEST,"网贷项目"),//智投标管理

    LOAN_APPLY("借款申请",Realm.LOANREQUEST,"网贷项目"),//智投标管理

    LOAN_APPOINTMENT("授权查看",Realm.LOANREQUEST,"网贷项目"),//智投标管理


//    LOANREQUEST_QUICK("快速录入借款申请，包括用户及其银行卡", Realm.LOANREQUEST, "网贷项目"),
    

    /******************************************************************产品管理***********************************/
    
    /******************************************************************项目管理***********************************/

    /**
     * 合同相关权限
     */
    CONTRACT_DELETE("删除某个合同", Realm.CONTRACT, "合同相关权限"),
    CONTRACT_VIEW("查看借款合同", Realm.CONTRACT, "合同相关权限"),
    CONTRACTS_SETDEFAULT("设置合同模板为默认", Realm.CONTRACT, "合同相关权限"),
    CONTRACT_ADD("增加模板", Realm.CONTRACT, "合同相关权限"),
    CONTRACT_TEMPLATES("合同管理", Realm.CONTRACT, "合同相关权限"),

    SETTLE_FINISHED("结算管理", Realm.SETTLEMENT, "结算相关权限"),
//    SETTLE_FINISHED_CONFIRM("结算管理-通过并结算", Realm.SETTLEMENT, "结算相关权限"),

    /******************************************************************项目管理***********************************/
    
    /******************************************************************资金管理***********************************/
    /**
     * 资金相关权限
     */
    FUND_RECONCILIATION_TRANSFER("商户向用户转账", Realm.FUND, "资金相关权限"),
    USER_TRANSFER("商户向用户转账-【提交申请,批量上传转账申请】", Realm.FUND, "资金相关权限"),
    USER_TRANSFER_AUDIT("商户向用户转账-【批量操作{批准,拒绝,取消},操作{批准,拒绝,取消}】", Realm.FUND, "资金相关权限"),
    FUND_RECONCILIATION_FUND("平台资金记录", Realm.FUND, "资金相关权限"),
    FUND_RECONCILIATION_THIRDPARTY("平台资金充值与提现", Realm.FUND, "资金相关权限"),

    FUND_RECONCILIATION_PLATFORM("平台对账", Realm.FUND, "资金相关权限"),
    FUND_RECONCILIATION_DEPOSIT("充值记录", Realm.FUND, "资金相关权限"),
//    FUND_EXPORT_RECORDS("导入第三方充值记录", Realm.FUND, "资金相关权限"),
//    FUND_EXPORT_RECORDS_SAVE("导入第三方充值记录-保存", Realm.FUND, "资金相关权限"),
    FUND_RECONCILIATION_INVEST("投资记录", Realm.FUND, "资金相关权限"),
    FUND_RECONCILIATION_WITHDRAW("提现记录", Realm.FUND, "资金相关权限"),
    FUND_RECONCILIATION_REPAY("回款记录", Realm.FUND, "资金相关权限"),
    FUND_RECONCILIATION_RECORDS("交易记录", Realm.FUND, "资金相关权限"),
    FUND_RECONCILIATION_COMMISSIONRECORD("佣金记录", Realm.FUND, "资金相关权限"),
    FUND_RECONCILIATION_BACKRECHARGE("资金回退充值", Realm.FUND, "资金相关权限"),
    FUND_RECONCILIATION_INVESTORDERRECORD("投资订单记录", Realm.FUND, "资金相关权限"),

    WITHDRAW_MANAGER("提现管理", Realm.WITHDRAW, "提现相关权限"),
    WITHDRAW_MANAGER_CONFIRM("提现确认", Realm.WITHDRAW, "提现相关权限"),
    WITHDRAW_MANAGER_INTERCEPTWITHDRAW("提现拦截", Realm.WITHDRAW, "提现相关权限"),

    WITHDRAW_UNTREATEDREQUEST("未处理请求", Realm.WITHDRAW, "提现相关权限"),
    WITHDRAW_PROCESSING("处理中记录", Realm.WITHDRAW, "提现相关权限"),
    WITHDRAW_IMPORT("提现结果导入", Realm.WITHDRAW, "提现相关权限"),
    WITHDRAW_CHECK("导入结果审核", Realm.WITHDRAW, "提现相关权限"),
    WITHDRAW_QUERYWITHDRAWFAILED("提现失败列表", Realm.WITHDRAW, "提现相关权限"),
    /******************************************************************资金管理***********************************/
    
    /******************************************************************营销管理***********************************/

    USER_CASHGIFT("现金红包相关", Realm.REWARD, "奖励相关权限"),
    REWARD_REFERRAL("推荐注册记录", Realm.REWARD, "奖励相关权限"),
    REWARD_RATE_COUPON("加息券相关", Realm.REWARD, "奖励相关权限"),
    USER_DATA_STATISTICS("流量统计相关", Realm.REWARD, "奖励相关权限"),

    /******************************************************************营销管理***********************************/

    /******************************************************************活动统计start***********************************/
    PROMOTE_REGISTER("推广注册列表", Realm.PROMOTE, "推荐管理相关权限"),
    PROMOTE_STATISTICS("注册统计", Realm.PROMOTE, "推荐管理相关权限"),
    STATISTICS_PROMOTE("推广统计", Realm.PROMOTE, "推荐管理相关权限"),


    STATISTICS_USER("用户统计", Realm.STATISTICS, "数据统计相关权限"),
    STATISTICS_GIFTCOUNT("红包统计", Realm.STATISTICS, "数据统计相关权限"),
    STATISTICS_LOAN_INFOS("产品项目统计", Realm.STATISTICS, "数据统计相关权限"),
    STATISTICS_INVEST_RECORDS("投资统计", Realm.STATISTICS, "数据统计相关权限"),
    STATISTICS_FUND("资金统计", Realm.STATISTICS, "数据统计相关权限"),

    /******************************************************************数据统计平台 start***********************************/
//    STATISTICS_ACTIVITY("活动数据统计", Realm.STATISTICS, "数据统计相关权限"),
//    STATISTICS_SOURCES("渠道数据统计", Realm.STATISTICS, "数据统计相关权限"),
    /**
     * GrowingIo数据统计
     */
//    GROWINGIO_PERMISION("GrowingIo数据统计",Realm.STATISTICS,"数据统计相关权限"),
    /******************************************************************数据统计平台 end***********************************/

    LOAN_MANAGER("还款管理", Realm.LOAN, "还款管理相关权限"),

    LOAN_PREREPAY("还款预处理", Realm.LOAN, "还款管理相关权限"),
    LOAN_DUEREPAY("还款", Realm.LOAN, "还款管理相关权限"),

    LOAN_PREREPAYCOMPENSATORY("还代偿预授权", Realm.LOAN, "还款管理相关权限"),
    LOAN_REPAYCOMPENSATORY("还代偿确认", Realm.LOAN, "还款管理相关权限"),

    LOAN_PRESERVICEFEE("服务费授权预处理", Realm.LOAN, "还款管理相关权限"),
    LOAN_REPAYSERVICEFEE("还服务费确认", Realm.LOAN, "还款管理相关权限"),

    LOAN_EARLYREPAYMENT("提前还款", Realm.LOAN, "还款管理相关权限"),

    LOAN_GRANT("代偿预授权", Realm.LOAN, "还款管理相关权限"),
    LOAN_CONFIRM("代偿确认", Realm.LOAN, "还款管理相关权限"),

    LOAN_GRANTFEE("服务费代偿预授权", Realm.LOAN, "还款管理相关权限"),
    LOAN_FEECONFIRM("服务费代偿确认", Realm.LOAN, "还款管理相关权限"),

    /**
     * 债权项目
     */

//    CLAIM_PRODUCT_PUBLISH("发布产品",Realm.CLAIM_PRODUCT_PUBLICSH,"发布产品"),
//    CLAIM_DAY_END_TASKS("日终任务",Realm.CLAIM_DAY_END_TASKS,"日终任务"),
//    CLAIM_DAY_END_TASKS_RUN("开始跑批",Realm.CLAIM_DAY_END_TASKS,"日终任务"),



    THIRDPARTY_REGISTER_SOURCE("注册渠道管理",Realm.REGISTERSOURCE,"注册渠道管理"),
    TELEPHONE_STATISTICS("话费统计",Realm.TELEPHONE_MANAGER,"话费统计管理"),
    ANTIFRAUD_LIST("反欺诈管理",Realm.ANTIFRAUD,"反欺诈管理"),
    CREDIT_LIST("债转列表",Realm.CREDIT_MANAGEMENT,"债转标管理");
    private final String key;

    private final Realm realm;

    private final String description;

    /**
     * realm所属的所有priviledges
     */
    private static final Map<Realm, List<Privilege>> realm2Privilege = new HashMap<>();

    static {
        for (Privilege privilege : Privilege.values()) {
            List<Privilege> privilegeList = realm2Privilege.get(privilege.getRealm());
            if (privilegeList == null) {
                privilegeList = new ArrayList<>();
                privilegeList.add(privilege);
                realm2Privilege.put(privilege.getRealm(), privilegeList);
            } else {
                realm2Privilege.get(privilege.getRealm()).add(privilege);
            }
        }
    }

    Privilege(String key, Realm realm, String description) {
        this.key = key;
        this.realm = realm;
        this.description = description;
    }

    @Override
    public String getKey() {
        return key;
    }

    public Realm getRealm() {
        return realm;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 获得realm所有对应的priviledge
     *
     * @param realms
     * @return
     */
    public static List<Privilege> listByIncludedRealm(Realm... realms) {
        if (realms == null || realms.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<Privilege> result = new ArrayList<>();
        for (Realm realm : realms) {
            List<Privilege> temp = realm2Privilege.get(realm);
            if (temp != null && !temp.isEmpty()) {
                result.addAll(temp);
            }
        }
        return result;
    }

    /**
     * 列出所有不属于realm的priviledge,主要给不同的客户权限管理显示不同的可用权限列表
     *
     * @param realms
     * @return
     */
    public static List<Privilege> listByExcludedRealm(Realm... realms) {
        List<Privilege> result = new ArrayList<>();
        Set excludedRealms = new HashSet(Arrays.asList(realms));
        for (Realm realm : realm2Privilege.keySet()) {
            if (!excludedRealms.contains(realm)) {
                List<Privilege> temp = realm2Privilege.get(realm);
                if (temp != null && !temp.isEmpty()) {
                    result.addAll(temp);
                }
            }
        }
        return result;
    }
}
