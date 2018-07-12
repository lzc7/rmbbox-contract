package com.zipi.enums.common;

/**
 * Created by zhangyang on 8/2/16.
 */
public enum OperateNode {
    Confirm_Register_Successful("确认注册环节"),
    CONFIRM_REGISTER_SUCCESSFUL_FOR_EXPERIENCE_INVEST("确认注册环节(专用于体验标)"),
    Register_Successful_To_Refrerral("确认注册成功，邀请人环节"),
    Confirm_BindCard_Successful("确认绑卡环节"),
    Invest_Successful("投资环节"),
    Invest_First_Successful("投资环节首投成功"),
    REGISTER_PUT_EXPERIENCE("注册发放体验金(好友邀请体验标)"),
    Invest_First_Repayment_TheDayBefore("首次投资回款前一天(不包括零存宝、直投和月盈计划是最后一期回款前一天)"),
    BIND_THREE_PUT_EXPERIENCE("绑卡后三天未投资"),
    suprise_get_prize("惊喜派送活动发放红包"),
    BIND_SEVEN_PUT_EXPERIENCE("绑卡后七天未投资"),
    Invest_First_To_Refrerral("首投成功向推荐人发体验金"),
    DOUBLE_NINTH_FESTIVAL_2016_For999("2016重阳节999元红包活动"),
    THANKSGIVEN_GIFTCARD_2016("2016感恩节1888元红包"),
    Invest_First_Repayment_Current_Out("首投零存宝转出"),
    Invest_First_Repayment_Current_14_Not_Out("首投零存宝14天没有转出"),
    DAILY_RAFFLE("每日抽奖"),
    CHRISTMAS_2016_B_COMMON("2016圣诞蛋生鸡, 银蛋"),
	CHRISTMAS_2016_B_GOLDEN("2016圣诞蛋生鸡, 金蛋"),
	CHRISTMAS_2016_B_DIAMOND("2016圣诞蛋生鸡, 钻石蛋"),
    DRAGON_HEAD_TELEPHONE_VOICE("二月二龙抬头，话费"),
    New_Confirm_Register_Successful("新网贷注册成功")
    ;

    private String nodeDesc;

    private OperateNode(String nodeDesc){
        this.nodeDesc=nodeDesc;
    }

    public String getNodeDesc(){
        return this.nodeDesc;
    }

}
