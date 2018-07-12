package com.zipi.entity;

import org.apache.commons.lang3.StringUtils;


public class PrivacyDimmer {
	public static <T> T dim(T obj) {
        if (obj instanceof CoreUser) {
            CoreUser user = (CoreUser) obj;
            user.setUserName(maskName(user.getUserName()));
            user.setUserMobile(mask(user.getUserMobile(), 3, 4));
            user.setIdNumber(maskIdNumber(user.getIdNumber()));
            user.setEmail(maskEmail(user.getEmail()));
            return (T) user;
        }
       /* if (obj instanceof BankAccountType) {
            BankAccountType account = (BankAccountType) obj;
            account.setAccount(mask(account.getAccount(), 4, 8));
        }*/
        return obj;
    }
	/**
     * 139****0504
     *
     * @param content
     * @return
     */
    public static String mask(String content, int offset, int length) {
        if (StringUtils.isEmpty(content)) {
            return "";
        }
        assert content.length() >= offset + length;

        char[] chars = content.toCharArray();
        for (int i = offset; i < offset + length; i++) {
            chars[i] = '*';
        }
        return new String(chars);
    }

    public static String maskIdNumber(String idNumber) {
        if (StringUtils.isEmpty(idNumber)) {
            return "";
        }
        // 非身份证
        if(!(idNumber.length() == 15 || idNumber.length() == 18)) {
            return mask(idNumber, 2, idNumber.length() - 4);
        }

        return mask(idNumber, idNumber.length() == 15 ? 5 : 8, 9);
    }

    private static String maskEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return "";
        }
        int offset = 0;
        int length = email.indexOf('@');
        if (length > 2) {
            offset = 2;
            length -= offset;
        }
        return mask(email, offset, length);
    }

    public  static String maskName(String name) {
        if (StringUtils.isEmpty(name)) {
            return "";
        }
        return mask(name, name.length() - 1, 1);
    }

    public static String maskLoginName(String loginName) {
        if (StringUtils.isEmpty(loginName)) {
            return "";
        }
        if (loginName.length() < 2) {
            return "*";
        }
        return mask(loginName, 1, loginName.length() > 2 ? loginName.length() - 2 : 1);
    }
    /**
     * 用户名遮罩：用于移动端投资记录的显示
     * 2016年7月8日  上午9:57:49
     * zhaoqiang
     */
    public static String maskLoginNameForMove(String loginName) {
    	if (StringUtils.isEmpty(loginName)) {
    		return "";
    	}
    	if (loginName.length() < 2) {
    		return "*";
    	}
    	if(loginName.length()>=7){
    		loginName=loginName.substring(0, 6)+loginName.substring(loginName.length()-1,loginName.length());
    	}
    	return mask(loginName, 1, loginName.length() > 2 ? loginName.length() - 2 : 1);
    }

    public static String maskBankCard(String cardNo){
        if(StringUtils.isEmpty(cardNo)){
            return "";
        }
        char[] chars = cardNo.toCharArray();
        String card = "**** **** **** ";
        for (int i = chars.length-4; i < chars.length; i++) {
            card += chars[i];
        }
        return card;
    }
}
