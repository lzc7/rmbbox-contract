package com.zipi.enums.core;


import com.zipi.base.BaseEnum;

import java.util.Arrays;
import java.util.List;

/**
 * Created by veryyoung on 2015/6/30.
 */
public enum ProductType implements BaseEnum {


    BBT("邦帮堂", ""),
    UPLAN("优选计划", ""),
    CURRENT_DEPOSIT("零存宝", "HQLC"),//活期理财
    MONTH_WIN("月盈计划", "YYJH"),//月息通
    RECYCLE_INTEREST("复利计划", "FLJH"),//鑫茂通
    FIXED_DEPOSIT_1("定期计划A", "DAJH"),//定期宝1个月
    FIXED_DEPOSIT_3("定期计划B", "DBJH"),//定期宝3个月
    FIXED_DEPOSIT_6("定期计划C", "DCJH"),//定期宝6个月
    FIXED_DEPOSIT_9("定期计划D", "DDJH"),//定期宝9个月
    FIXED_DEPOSIT_12("",""),
    FIRST_INVEST("新手标","XSJH"),
    ASSET_COMMON("普标","PBXM"),
	ASSET_GOLDEN("金标","JBXM"),
	ASSET_DIAMOND("钻石标","ZBXM"),
    C_D_B("车贷标", "CDBD"),
    X_D_B("V贷标", "XDBD"),
    P_J_B("银票据标", "PJBD"),
    S_P_J_B("商票据标","SPJBD"),
    P_X_D_B("信贷标","PXDBD"),
    /** 兼容使用，不计入发标标的类型*/
    Y_Y_B("预约标","YYBD"),
    Z_Z_B("债权标","ZZBD");

    private final String key;

    private final String orderType;

    private ProductType(String key, String orderType) {
        this.key = key;
        this.orderType = orderType;
    }

    @Override
    public String getKey() {
        return key;
    }

    public String getOrderType() {
        return orderType;
    }
    /**
     * @see 获取所有非活期的新产品
     * @return
     */
    public final static List<String> getAllFixedProductTypeString(){

        return Arrays.asList(MONTH_WIN.name(),RECYCLE_INTEREST.name(),FIXED_DEPOSIT_1.name(),FIXED_DEPOSIT_3.name(),FIXED_DEPOSIT_6.name(),FIXED_DEPOSIT_9.name());

    }

    public final static List<ProductType> getFixedProductTypes() {
        return Arrays.asList(MONTH_WIN,RECYCLE_INTEREST,FIXED_DEPOSIT_1,FIXED_DEPOSIT_3,FIXED_DEPOSIT_6,FIXED_DEPOSIT_9, BBT, UPLAN);
    }
    /**
     * @see 获取所有非活期的新产品
     * @return
     */
    public final static List<ProductType> getAllFixedProductType(){

        return Arrays.asList(MONTH_WIN,RECYCLE_INTEREST,FIXED_DEPOSIT_1,FIXED_DEPOSIT_3,FIXED_DEPOSIT_6,FIXED_DEPOSIT_9,ASSET_COMMON,ASSET_GOLDEN,ASSET_DIAMOND,FIRST_INVEST);

    }
    /**
     * @see 获取所有定期宝产品
     * @return
     */
    public final static List<String> getAllRegularProductTypeString(){

        return Arrays.asList(FIXED_DEPOSIT_1.name(),FIXED_DEPOSIT_3.name(),FIXED_DEPOSIT_6.name(),FIXED_DEPOSIT_9.name());

    }
    /**
     * @author haojunfu
     * @see 月息通 和 鑫茂通 产品类型活期
     * @return
     */
    public final static List<String> getMonthWinAndRecycleInterest(){

        return Arrays.asList(MONTH_WIN.name(),RECYCLE_INTEREST.name());

    }

    /**
     * 获取债权产品（非至投标和优选）
     * @return
     */
    public final static List<ProductType> getAllClaimProductType() {

    	return Arrays.asList(ProductType.CURRENT_DEPOSIT,
    			ProductType.FIXED_DEPOSIT_1,
    			ProductType.FIXED_DEPOSIT_3,
    			ProductType.FIXED_DEPOSIT_6,
    			ProductType.FIXED_DEPOSIT_9,
    			ProductType.MONTH_WIN,
    			ProductType.RECYCLE_INTEREST,
    			ProductType.FIRST_INVEST,
    			ASSET_COMMON,
    			ASSET_GOLDEN,
    			ASSET_DIAMOND);
    }

    /**
     * 获取参加抽奖活动的投资类型
     * 非零存宝和定期计划A
     */
    public final static List<ProductType> getAllActiveProductType() {
        return Arrays.asList(ProductType.BBT, ProductType.MONTH_WIN, ProductType.FIXED_DEPOSIT_3, ProductType.FIXED_DEPOSIT_6,
                ProductType.FIXED_DEPOSIT_9, ProductType.RECYCLE_INTEREST);
    }
    
    public final static List<ProductType> getAllAssetLoanType() {

    	return Arrays.asList(ProductType.ASSET_COMMON,ProductType.ASSET_GOLDEN,ProductType.ASSET_DIAMOND,ProductType.FIRST_INVEST);
    }

    public final static List<ProductType> getAllXWLoanType() {

        return Arrays.asList(ProductType.C_D_B,ProductType.X_D_B,ProductType.P_J_B,ProductType.S_P_J_B,ProductType.P_X_D_B);
    }
}
