package com.zipi.modules.contract.enums;


import com.zipi.modules.base.enums.BaseEnum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 推送用户类型
 * @author zhaoqiang
 * 全部用户，新用户，老用户，一次投资用户，二次投资用户，导入用户，个人用户
 */
public enum PushUserType implements BaseEnum {
    ALL_USER("全部用户"),
    NEW_USER("新用户"),
    OLD_USER("老用户"),
    FIRST_INVEST_USER("一次投资用户"),
    TWO_INVEST_USER("二次投资用户"),
    PERSON_USER("个人用户"),
    IMPORT_USER("导入用户"),
    WECHAT_USER("微信绑定用户"),
    INVEST_USER("投资用户");
    
    private final String key;
    private PushUserType(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
   /**
    * 获取基本用户类型
    * 2016年6月25日  上午11:47:20
    * zhaoqiang
    */
    public final static List<PushUserType> listBaseUserType(){
		return Arrays.asList(NEW_USER,OLD_USER,FIRST_INVEST_USER,TWO_INVEST_USER);
    }
    
    /**
     * 基本用户类型  枚举类型    key
     * 2016年6月29日  上午9:54:41
     * zhaoqiang
     */
   public final  static  Map<String,String>  mapBaseUserType(){
	   Map<String,String>  map=new HashMap<String, String>();
	   for (PushUserType userType: listBaseUserType()) {
		   map.put(userType.name(), userType.key);
	   }
	   return map;
   }
    /**
     * 获取所有用户类型不包含个人用户
     * 2016年6月25日  上午11:47:20
     * zhaoqiang
     */
     public final static List<PushUserType> listUserTypeWithoutPERSONUSER(){
 		return Arrays.asList(ALL_USER,NEW_USER,OLD_USER,FIRST_INVEST_USER,TWO_INVEST_USER,IMPORT_USER);
     }
     /**
      * 获取所有用户类型
      * 2016年6月25日  上午11:47:20
      * zhaoqiang
      */
     public final static List<PushUserType> listUserType(){
    	 return Arrays.asList(ALL_USER,NEW_USER,OLD_USER,FIRST_INVEST_USER,TWO_INVEST_USER,PERSON_USER,IMPORT_USER);
     }
     /**
      * 获取所有用户类型
      * 2016年6月25日  上午11:47:20
      * zhaoqiang
      */
     public final static List<String> listUserTypeName(){
    	 return Arrays.asList(ALL_USER.name(),NEW_USER.name(),OLD_USER.name(),FIRST_INVEST_USER.name(),TWO_INVEST_USER.name(),PERSON_USER.name(),IMPORT_USER.name());
     }
     /**
      * 获取非基本用户类型
      * 2016年6月29日  上午9:56:52
      * zhaoqiang
      */
    public final static List<String>  listNotBaseUserTypeName(){
   	 return Arrays.asList(ALL_USER.name(),IMPORT_USER.name(),INVEST_USER.name());
    }
    
    /**
     * MAP   key 和  对象
     * 2016年6月29日  上午10:51:16
     * zhaoqiang
     */
    public final  static Map<String,PushUserType>   mapKeyAndUserType(){
    	Map<String,PushUserType>  map=new HashMap<String, PushUserType>();
 	   for (PushUserType userType: listBaseUserType()) {
		   map.put(userType.key, userType);
	   }
    	return map;
    }
}
