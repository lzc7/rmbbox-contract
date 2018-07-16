package com.zipi.modules.contract.entity;

import com.zipi.modules.base.entity.BaseObject;
import com.zipi.modules.base.entity.Source;
import com.zipi.modules.base.enums.CertificateType;
import com.zipi.modules.base.enums.Realm;
import com.zipi.modules.contract.enums.PushUserType;
import com.zipi.modules.contract.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoreUser extends BaseObject {

    /**
     * pc用户登录唯一凭证
     */
    private String token;
    /**
     * 用户主键id
     */
    private String userId;

    public void setId(String id) {
        userId = id;
    }

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 内部员工号
     */
    private String empId;

    /**
     * 是否可用
     */
    private boolean enabled = true;

    /**
     * 锁定类型
     */
    private String lockType;

    /**
     * 是否是企业用户
     */
    private boolean enterprise;// 是否为企业用户
    
    private String bankMobile;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 证件类型
     */
    private CertificateType certificateType;

    /**
     * 用户角色
     */
    private UserRole userRole;
    
    /**
     * 用户级别
     */
    private PushUserType userLevel;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 最后修改人员
     */
    private String lastModifiedBy;

    /**
     * 登录名，对于Source.Web方式注册用户必须有,其他方式默认为特殊字符串+手机号
     */
    private String loginName;

    /**
     * 手机号
     */
    private String userMobile;

    /**
     * 用户真实姓名
     */
    private String userName;

    /**
     * 是否需要修改密码
     */
    private boolean needChangePwd;

    /**
     * 口令
     */
    private String passphrase;

    /**
     * 用户注册时间
     */
    private Date registerTime;

    /**
     * 密码加密后的内容
     */
    private String salt;

    /**
     * 注册来源
     */
    private Source registerSource;

    /**
     * 推荐人id
     */
    private String referralId;

    /**
     * 推荐人的身份
     */
    private Realm referralRealm;

    /**
     * 推荐人名字
     */
    private String referralLoginName;

    /**
     *
     */
    private String password;

    /**
     * ip
     */
    private String ip;

    /**
     * @param empId
     * @param loginName
     * @param mobile
     * @param passphrase
     * @param salt
     * @param registerSource
     */
    public CoreUser(String empId, String loginName, String mobile,
                    String passphrase, String salt, Source registerSource) {
        this.empId = empId;
        this.loginName = loginName;
        this.userMobile = mobile;
        this.passphrase = passphrase;
        this.salt = salt;
        this.registerSource = registerSource;
    }



    private int countLoan;//贷款次数
    private int countInvest;//投资次数
    private int countClaimInvest;//新产品投资次数
    private BigDecimal availableAmount;//可用金额
    private BigDecimal forzenAmount;//冻结金额
    private BigDecimal withdrawAmount;//提现金额
    private BigDecimal dueInAmount;//待收金额
    private BigDecimal dueOutAmount;//待还
    private BigDecimal depositAmount;//充值金额
    
    private List<RmbLoanRequest>  loanRequestList;
    private RmbLoanRequest  loanRequest;
    
    private  List<CoreUser> recommendUserList;
//    private List<CoreUserFundRecord> coreUserFundRecords;  //用户资金


    private BigDecimal amount;//总充值金额或回款金额

    //fastjson在序列化的时候会调用此方法,如果身份证号打上马赛克，则会抛异常，因此加上注解让序列化时不触发此方法
    public boolean isMale() {
//        return ChineseIdNumber.isMale(idNumber);
        return true;
    }

    //头像
    private String headPicture;
    //性别
    private String sex;

    private Boolean isInvestUplan;// 是否投资过原优选计划 false 未投资 true 投资过

    private String welcomeName;// x先生 x女士 loginName userMobile


    private Boolean isGetLotteryByLogin;// 用户登录是否获取奖品

    //企业地址
    private String enAddress;
    //企业座机
    private String enPhone;
    //企业性质
    private String enNature;
    //企业营业执照编号
    private String enLicenseNo;

    //企业用户使用 页面显示使用 卡号
    private String cardNo;
    //企业用户使用 页面显示使用 银行名称
    private String bankName;

    private String tmp;// 父亲节临时使用
    
    /**是否有效**/
    private String isValid;
    /**体验金金额的显示**/
    private BigDecimal  experienceAmount;
    /**体验金金额的显示**/
    private String  experienceAmountShow;

    /**
     * 个人信息安全信息
     * 1.是否认证手机
     * 2.是否设置支付密码
     * 3.是否身份认证实名
     * 4.是否绑卡
     * 5.安全等级
     */
    /**是否认证手机*/
    public boolean getIsAuthMobile(){return StringUtils.isNotBlank(userMobile);}
    /**是否设置支付密码*/
    private Boolean isSetPayPass=false;
    /**是否绑卡*/
    private Boolean isBindCard=false;
    /**是否身份认证实名*/
    public boolean getIsAuthIDNumber(){ return StringUtils.isNotBlank(idNumber);}
    /**如果用户名不为空显示xx先生女士，如果为空显示加密电话号码*/
    private String encryptName;

    /**客户编号*/
    private String customerNo;

    /**安全等级*/
    public int getAuthenticateNum(){
        int authenticateNum = 1;  //手机号默认绑定 级别1
        if (this.getIsAuthIDNumber()) {
            authenticateNum++;
        }
        if (this.isSetPayPass!=null && this.isSetPayPass) {
            authenticateNum++;
        }
        if (this.isBindCard!=null && this.isBindCard) {
            authenticateNum++;
        }
        return authenticateNum;
    }
    /**用户头像*/
    private String avatar;

    /** 是否有借款 */
    private Boolean isLoan;// (false：没有 借款记录 true：有借款记录)




    
    /** 维护人相关信息*/
    private String maintenanceIdNumber;
    private String maintenanceEmpId;
    private Date modifyTime;
    /** 推荐人身份证号*/
    private String referralIdNumber;
    //客户端标识
    private Source source = Source.WEB;

    /** 联系人姓名*/
    private String contactName;
    /** 企业名称*/
    private String companyName;
    /** 税务登记号*/
    private String taxRegistrationNumber;
    /** 机构信用代码证*/
    private String institutionalCreditCode;
    /** 开户银行许可证 */
    private String bankLicense;
    /** 组织机构代码*/
    private String organizationCode;

    private String lendingStatus;

    private String lendingStatusName;

    private String userRoleName;

    private String withdrawBankCard;

    private String xwStatus;

    private String xwStatusName;

    private String contactPhone;

    /**
     * 统一社会信用码
     */
    private String unifiedCode;

    /**
     *
     */
    private String isunifiedCode;


    public String getUserRoleName(){
        if(userRole == null){
            return "";
        }
        return this.userRole.getKey();
    }

    //判断用户是否是渠道 true：不是  false:是
    private boolean channel;

    /**
     * 标的序号
     */
    private String loanRequestTitle;
}