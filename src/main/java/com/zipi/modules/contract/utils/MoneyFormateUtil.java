package com.zipi.modules.contract.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class MoneyFormateUtil {
	private static final String[] NUMBERS = { "零", "壹", "贰", "叁", "肆", "伍",
			"陆", "柒", "捌", "玖" };
	private static final String[] IUNIT = { "元", "拾", "佰", "仟", "万", "拾", "佰",
			"仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟" };
	private static final String[] DUNIT = { "角", "分", "厘" };
	
	/**
	* 特殊字符：整
	*/
	private static final String CN_FULL = "整";
	/**
	* 特殊字符：负
	*/
	private static final String CN_NEGATIVE = "负";
	/**
	* 金额的精度，默认值为2
	*/
	private static final int MONEY_PRECISION = 2;
	/**
	* 特殊字符：零元整
	*/
	private static final String CN_ZEOR_FULL = "零元" + CN_FULL;
	
	/**
     * 汉语中数字大写
     */
    private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆",
            "伍", "陆", "柒", "捌", "玖" };
    /**
     * 汉语中货币单位大写，这样的设计类似于占位符
     */
    private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元",
            "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾",
            "佰", "仟" };
	
	/**
     * 把输入的金额转换为汉语中人民币的大写
     * 
     * @param numberOfMoney
     *            输入的金额
     * @return 对应的汉语大写
     */
    public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {
        StringBuffer sb = new StringBuffer();
        // -1, 0, or 1 as the value of this BigDecimal is negative, zero, or
        // positive.
        int signum = numberOfMoney.signum();
        // 零元整的情况
        if (signum == 0) {
            return CN_ZEOR_FULL;
        }
        //这里会进行金额的四舍五入
        long number = numberOfMoney.movePointRight(MONEY_PRECISION)
                .setScale(0, 4).abs().longValue();
        // 得到小数点后两位值
        long scale = number % 100;
        int numUnit = 0;
        int numIndex = 0;
        boolean getZero = false;
        // 判断最后两位数，一共有四中情况：00 = 0, 01 = 1, 10, 11
        if (!(scale > 0)) {
            numIndex = 2;
            number = number / 100;
            getZero = true;
        }
        if ((scale > 0) && (!(scale % 10 > 0))) {
            numIndex = 1;
            number = number / 10;
            getZero = true;
        }
        int zeroSize = 0;
        while (true) {
            if (number <= 0) {
                break;
            }
            // 每次获取到最后一个数
            numUnit = (int) (number % 10);
            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
                }
                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
                }
                sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                getZero = false;
                zeroSize = 0;
            } else {
                ++zeroSize;
                if (!(getZero)) {
                    sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                }
                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                }
                getZero = true;
            }
            // 让number每次都去掉最后一个数
            number = number / 10;
            ++numIndex;
        }
        // 如果signum == -1，则说明输入的数字为负数，就在最前面追加特殊字符：负
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }
        // 输入的数字小数点后两位为"00"的情况，则要在最后追加特殊字符：整
        if (!(scale > 0)) {
            sb.append(CN_FULL);
        }
        return sb.toString();
    }

	public static String toChinese(String str) {
		str = str.replaceAll(",", "");
		String decimalStr;
		String integerStr;
		if (str.indexOf(".") > 0) {
			integerStr = str.substring(0, str.indexOf("."));
			decimalStr = str.substring(str.indexOf(".") + 1);
		} else {
			if (str.indexOf(".") == 0) {
				integerStr = "";
				decimalStr = str.substring(1);
			} else {
				integerStr = str;
				decimalStr = "";
			}
		}
		if (!integerStr.equals("")) {
			integerStr = Long.toString(Long.parseLong(integerStr));
			if (integerStr.equals("0")) {
				integerStr = "";
			}
		}
		if (integerStr.length() > IUNIT.length) {
			System.out.println(str + ":超出处理能力");
			return str;
		}
		int[] integers = toArray(integerStr);
		boolean isMust5 = isMust5(integerStr);
		int[] decimals = toArray(decimalStr);
		return getChineseInteger(integers, isMust5)
				+ getChineseDecimal(decimals);
	}

	private static int[] toArray(String number) {
		int[] array = new int[number.length()];
		for (int i = 0; i < number.length(); i++) {
			array[i] = Integer.parseInt(number.substring(i, i + 1));
		}
		return array;
	}

	private static String getChineseInteger(int[] integers, boolean isMust5) {
		StringBuffer chineseInteger = new StringBuffer("");
		int length = integers.length;
		for (int i = 0; i < length; i++) {
			String key = "";
			if (integers[i] == 0) {
				if (length - i == 13) {
					key = IUNIT[4];
				} else if (length - i == 9) {
					key = IUNIT[8];
				} else if ((length - i == 5) && (isMust5)) {
					key = IUNIT[4];
				} else if (length - i == 1) {
					key = IUNIT[0];
				}
				if ((length - i > 1) && (integers[(i + 1)] != 0)) {
					key = key + NUMBERS[0];
				}
			}
			chineseInteger.append(NUMBERS[integers[i]]
					+ IUNIT[(length - i - 1)]);
		}
		return chineseInteger.toString();
	}

	private static String getChineseDecimal(int[] decimals) {
		StringBuffer chineseDecimal = new StringBuffer("");
		for (int i = 0; i < decimals.length; i++) {
			if (i == 3) {
				break;
			}
			chineseDecimal.append(NUMBERS[decimals[i]] + DUNIT[i]);
		}
		return chineseDecimal.toString();
	}

	private static boolean isMust5(String integerStr) {
		int length = integerStr.length();
		if (length > 4) {
			String subInteger = "";
			if (length > 8) {
				subInteger = integerStr.substring(length - 8, length - 4);
			} else {
				subInteger = integerStr.substring(0, length - 4);
			}
			return Integer.parseInt(subInteger) > 0;
		}
		return false;
	}

	public static String toEnglish(String str) {
		String result = "";
		String decimalStr;
		String integerStr;
		if (str.indexOf(".") > 0) {
			integerStr = str.substring(0, str.indexOf("."));
			decimalStr = str.substring(str.indexOf(".") + 1);
		} else {
			if (str.indexOf(".") == 0) {
				integerStr = "";
				decimalStr = str.substring(1);
			} else {
				integerStr = str;
				decimalStr = "";
			}
		}
		integerStr = integerStr.replace(",", "");

		int a = integerStr.length() / 3;
		int b = integerStr.length() % 3;
		String head = "";
		String other = "";
		if ((a > 1) || ((a == 1) && (b > 0))) {
			head = integerStr.substring(0, b == 0 ? 3 : b);
			other = integerStr.substring(head.length(), integerStr.length());
			result = result + head;
			a = b == 0 ? a - 1 : a;
			for (int i = 0; i < a; i++) {
				result = result + ",";
				result = result + other.substring(i * 3, (i + 1) * 3);
			}
		} else {
			result = integerStr;
		}
		if (!"".equals(decimalStr)) {
			result = result + "." + decimalStr;
		} else {
			result = result + ".00";
		}
		return result;
	}

	public static String reBackTwo(String old) {
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(reZero(Double.valueOf(Double.parseDouble(old))));
	}

	private static Double reZero(Double va) {
		if (va.doubleValue() < 0.1D) {
			return Double.valueOf(0.0D);
		}
		return va;
	}

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		map.put("amount", 1000.00);
//		String money = "1000.00";
		System.out.println(number2CNMontrayUnit(new BigDecimal(String.valueOf(map.get("amount")))));
	}
}
