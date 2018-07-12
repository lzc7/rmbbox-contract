/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zipi.utils;

import com.zipi.enums.Constants;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

import static org.apache.commons.lang3.time.DateUtils.*;

/**
 * @author sobranie
 */
public class DateUtils {
	
	public static final String DATE_SIMPLE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_SIMPLE_FORMAT1 = "yyyy/MM/dd";
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static SimpleDateFormat  sdfMD=new SimpleDateFormat("M月d日");
	public static SimpleDateFormat  sdfYMD=new SimpleDateFormat("yyyy年M月d日");
	public static SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat  sdf_Y=new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat  sdf_H=new SimpleDateFormat("HH:mm:ss");
	public static SimpleDateFormat  sdf_YMD=new SimpleDateFormat("yyyyMMdd");
	public static SimpleDateFormat  sdf_YMD_local=new SimpleDateFormat("yyyy年M月dd日");
	public static SimpleDateFormat  sdf_MD=new SimpleDateFormat("MM-dd");
    static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    private static final GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
    public static final Date FIRST_DATE = new Date(0);

    /**
     * Joda Time versoin of offset
     *
     * @param asOfDate
     * @param duration
     * @return
     */

    /**
     * list all dates between start date and end date, both day included
     */
    public static List<Date> listDates(Date start, Date end) {
        List<Date> dates = new ArrayList<>();

        Date date = start;
        calendar.setTime(start);
        while (date.before(end)) {
            dates.add(date);
            calendar.add(Calendar.DAY_OF_WEEK, 1);
            date = calendar.getTime();
        }
        if (date.equals(end)) {
            dates.add(end);
        }

        return dates;
    }

    /**
     * return the 0'clock time for a date, like 2013/8/1 0:0:0
     *
     * @param date
     * @return
     */
    public static Date get0OClock(Date date) {
        if (date == null) {
            return null;
        }

        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTime();
    }
    /**
     * return the 0'clock time for a date, like 2013/8/1 0:0:0
     *
     * @param date
     * @return
     */
    public static Date get0OClock2(Date date) {
    	if (date == null) {
    		return null;
    	}
    	
    	calendar.setTime(date);
    	int year = calendar.get(Calendar.YEAR);
    	int month = calendar.get(Calendar.MONTH);
    	int day = calendar.get(Calendar.DAY_OF_MONTH);
    	calendar.set(year, month, day, 0, 0, 0);
    	calendar.set(Calendar.MILLISECOND, 0);
    	return calendar.getTime();
    }
    /**
     * 获取24点
     * @param date
     * @return
     */
    public static Date get24OClock(Date date) {
    	if (date == null) {
    		return null;
    	}
    	
    	calendar.setTime(date);
    	int year = calendar.get(Calendar.YEAR);
    	int month = calendar.get(Calendar.MONTH);
    	int day = calendar.get(Calendar.DAY_OF_MONTH);
    	calendar.set(year, month, day, 23, 59, 59);
    	calendar.set(Calendar.MILLISECOND, 999);
    	return calendar.getTime();
    }

	/**
	 * 获取24点
	 * @param date
	 * @return
	 */
	public static Date get24OClock2(Date date) {
		if (date == null) {
			return null;
		}

		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(year, month, day, 23, 59, 59);
		return calendar.getTime();
	}

    /**
     * 为使stock曲线平滑，填满遗漏的值
     *
     * @param data
     */
    public static void enrichStockData(Map<LocalDate, BigDecimal> data) {
        Entry<LocalDate, BigDecimal> current = null;
        Map<LocalDate, BigDecimal> extraData = new HashMap<>();
        for (Entry<LocalDate, BigDecimal> entry : data.entrySet()) {
            if (current == null) {
                current = entry;
            } else {
                LocalDate date = current.getKey().plusDays(1);
                while (date.isBefore(entry.getKey())) {
                    extraData.put(date, current.getValue());
                    date = date.plusDays(1);
                }
                current = entry;
            }
        }
        data.putAll(extraData);
    }

    /**
     * 根据身份证号计算年龄，按照周岁计算
     *
     * @param idNumber
     * @return 0 idNumber格式错误
     */
    public static int getAgeFromIdNumber(String idNumber) {
        LocalDate birthday = LocalDate.now();
        try {
            if (idNumber.length() == 18) {
                birthday = LocalDate.parse(idNumber.substring(6, 14), DateTimeFormat.forPattern("yyyyMMdd"));
            } else if (idNumber.length() == 15) {
                birthday = LocalDate.parse(idNumber.substring(6, 12), DateTimeFormat.forPattern("yyMMdd"));
            }
        } catch (Exception ex) {
            logger.error("Error happend when parse age from idNumber.[idNumber=" + idNumber + "]", ex);
        }
        return Years.yearsBetween(birthday, LocalDate.now()).getYears();
    }

    public static Date stringParseDate(String date, String patern) {
        SimpleDateFormat formatDate = new SimpleDateFormat(patern);
        try {
            return formatDate.parse(date);
        } catch (ParseException e) {
            logger.warn("sorry i formate  date false ");
        }
        return null;
    }

    public static String dateFormateString(Date date, String patern) {
        SimpleDateFormat formatDate = new SimpleDateFormat(patern);
        return formatDate.format(date);
    }

    public static Date dateFormateDate(Date date, String patern) {
        SimpleDateFormat formatDate = new SimpleDateFormat(patern);
        return stringParseDate(formatDate.format(date), patern);
    }

    public static Date getAddOneDate(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /*
     *用于将当前天date加n天或者减n天后的时间  addorminus表示加减的天数 例 1表示加一天 -1表示减一天
     * */
    public static Date getAddOrMinusDate(Date date, int addorminus) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, addorminus);
        return calendar.getTime();
    }

	/***
	 * 将日期格式字符串转化成YYYY-mm-dd格式字符串
	 * @param dateStr
	 * @return
	 */
	public static String converDateStrToSimpleDateStr(String dateStr) {
		String result = "";
		try{
			Date date = stringParseDate(dateStr, DATE_SIMPLE_FORMAT);
			result = dateFormateString(date, DATE_SIMPLE_FORMAT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 根据还款开始日期计算债权还款日.
	 * @author haojunfu
	 * @param date
	 * @return
	 */
	public static short countLoanReturnDate(Date date) {
		if (null != date) {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = new Date();
			d = dateFormateDate(date, "yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			if (c.get(Calendar.DAY_OF_MONTH) <= 15 || c.get(Calendar.DAY_OF_MONTH) == 31) {
				return Constants.LOAN_RETURN_DATE_THIRTY;
			}
		}
		return Constants.LOAN_RETURN_DATE_FIFTEEN;
	}
	/**
	 *  返回债权首次还款日期：规则如下：
		借款人在31-15日自己的借款，账单日为每月30【31号的借款为次月30】
		借款人在16-30日之间的借款账单日为次月15日
	 * @param date 初始借款日期
	 * @return String
	 * * @author haojunfu
	 */
	public static Date claimFirstReturnDate(Date date){
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		if(dayOfMonth<=15 || dayOfMonth==31 ){//处理31号和1号到15号之间的账单日
			if(dayOfMonth==31){//如果为31号，则增加一个月
				c.add(Calendar.MONTH, 1);
			}
			if(c.get(Calendar.MONTH)==1){// 特殊二月份处理【定位到28号】
				c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
			}else{
				c.set(Calendar.DAY_OF_MONTH, 30);
			}
		}else{//处理16号到30号之间的账单日，则为次月的15
			c.add(Calendar.MONTH, 1);//定位次月
			c.set(Calendar.DAY_OF_MONTH, 15);//定位15
		}
//		System.out.println("******************"+dateFormateString(c.getTime(),DATE_SIMPLE_FORMAT));
		return c.getTime();
	}
	/**
     * 返回债权最后一期的还款日期
	 * @author haojunfu
	 * @param date
aram loanCount
	 * @return
	 */
	public static Date claimLastReturnDate(Date date,int loanCount){
		List<String> dateList = claimDateList(date,loanCount);
		String dateStr = dateList.get(dateList.size()-1);
//		System.out.println("************"+dateStr);
		return stringParseDate(dateStr,DATE_SIMPLE_FORMAT);
	}
	
	/**
	 * 得到还款期数的现金流日期
	 * @param date 初始借款时间
	 * @param amount 期数
	 * @return 还款日期流集合
	 * @author haojunfu
	 */
	public static List<String> claimDateList(Date date, int amount) {
		List<String> dateList = new ArrayList<String>();
		Calendar c = Calendar.getInstance();
		Date firstDate = claimFirstReturnDate(date);
		c.setTime(firstDate);
		short loanReturn = DateUtils.countLoanReturnDate(date);
		dateList.add(dateFormateString(c.getTime(),DATE_SIMPLE_FORMAT));
		for (int i = 0; i < amount-1; i++) {
			c.add(Calendar.MONTH, 1);
			if(loanReturn==Constants.LOAN_RETURN_DATE_FIFTEEN) {
				c.set(Calendar.DAY_OF_MONTH, 15);
			}else if(c.get(Calendar.MONTH) == 1 && loanReturn==Constants.LOAN_RETURN_DATE_THIRTY) {
				c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DATE));
//				c.set(Calendar.DAY_OF_MONTH, 28);
			}else if(c.get(Calendar.MONTH) != 1 && loanReturn==Constants.LOAN_RETURN_DATE_THIRTY) {
				c.set(Calendar.DAY_OF_MONTH, 30);
			}
			dateList.add(dateFormateString(c.getTime(),DATE_SIMPLE_FORMAT));
		}
//		System.out.println("*********"+dateList);
		return dateList;
	}
	
	/**
	 * * @author haojunfu
	    * 日期差天数(按照时间比较,如果不足一天会自动补足)
	    * @param date1 开始日期
	    * @param date2 结束日期
	    * @return 两日期差天数
	    * @throws Exception 
	   */
	   public static int betweenDays(Date date1, Date date2) throws Exception {
		   long day = 24L * 60L * 60L * 1000L;
		   String str1=dateFormateString(date1, "yyyy-MM-dd");
		   date1=stringParseDate(str1, "yyyy-MM-dd");
		   String str2=dateFormateString(date2, "yyyy-MM-dd");
		   date2=stringParseDate(str2, "yyyy-MM-dd");
	   	   return (int) (((date2.getTime() - date1.getTime()) /day));
//	   		return (int) Math.ceil((((date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000d))));
	   	}
	   
	   
	   /**
	    * 日期只差，不足一天算就一天
	    * 2016年6月2日  下午2:58:29
	    * zhaoqiang
	    */
	   public static int betweenDaysCeil(Date date1, Date date2) throws Exception {
		   long day = 24L * 60L * 60L * 1000L;
		   String str1=dateFormateString(date1, "yyyy-MM-dd");
		   date1=stringParseDate(str1, "yyyy-MM-dd");
		   String str2=dateFormateString(date2, "yyyy-MM-dd");
		   date2=stringParseDate(str2, "yyyy-MM-dd");
	   		return (int) Math.ceil((((date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000d))));
	   }
	   
	   
	   /**
	    * 日期只差，不足一天算一天
	    * 2016年6月2日  下午2:58:29
	    * zhaoqiang
	    */
	   public static int betweenDaysMax(Date date1, Date date2) throws Exception {
		   return (int) Math.ceil((double)(date2.getTime() - date1.getTime())/1000/60/60/24);
	   }

	/**
	 * 日期只差，不足一天算一天
	 * 2016年6月2日  下午2:58:29
	 * zhaoqiang
	 */
	public static int betweenDaysMin(Date date1, Date date2) throws Exception {
		return (int) Math.floor((double)(date2.getTime() - date1.getTime())/1000/60/60/24);
	}
	       
	   /**
         * 计算债权剩余期数
		 * @author haojunfu
		 * @param firstRepayDate
		 * @param loanCount
		 * @return
		 */
		public static int claimRemainPeriod(Date firstRepayDate,int loanCount){
			List<String> dateList = claimDateList(firstRepayDate,loanCount);
//			System.out.println(dateList);
			int step=0;
			Date cruDate = new Date();
			Calendar c = Calendar.getInstance();
			cruDate = LocalDate.parse(LocalDate.fromDateFields(cruDate).toString("yyyy-MM-dd")).toDate();
			Date compareDate = null; 
			c.setTime(cruDate);
			for (int i =dateList.size()-1; i >=0; i--) {
				compareDate = LocalDate.parse(LocalDate.parse(dateList.get(i)).toString("yyyy-MM-dd")).toDate();
				if(cruDate.before(compareDate)){
					step++;
				}else{
					return step;
				}
			}
			return step;
		}
	    /**
	     * @author haojunfu
	    * 日期差天数(和当前时间比)
	    * @param date 比较日期
	    * @return 和当前日期差天数
	     * @throws Exception 
	    */
	   	public static int diff(Date date) throws Exception {
	   		return betweenDays(new Date(), date);
	   	}
	
	/**
     * 获取某日期时间范围
     * @param day
     * @return
     * @throws ParseException
     */
    public static Date[] getOneDayRange(String day) {
    	if (StringUtils.isNotEmpty(day)) {
    		try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				return new Date[]{sdf.parse(day+" 00:00:00"), sdf.parse(day+" 23:59:59")};
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
    	} 
    	return null;
    }

	/**
	 * 获取月息通的下一个回款日
	 * @param date
	 * @param billDateType
     * @return
     */
	public static Date getNextRepayDate(Date date, short billDateType){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        int month =c.get(Calendar.MONTH);

		if(billDateType == 15){
            //日期大于15, 下一个月15日
			if(dayOfMonth>15){
                c.add(Calendar.MONTH, 1);
			}

            c.set(Calendar.DAY_OF_MONTH, 15);

            return c.getTime();
		}

        //30账单日

        //2月比较特殊, 以及1月31号 那么都是2月最后一天
        if(month == 1 || (month == 0 && dayOfMonth == 31)){
            c.set(Calendar.MONTH, 1);
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            return c.getTime();
        }

        //小于等于30的,都返回当月30
        if(dayOfMonth<=30){
            c.set(Calendar.DAY_OF_MONTH, 30);
            return c.getTime();
        }

        //31号的情况,取下一个月的30号
        c.add(Calendar.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH, 30);

		return c.getTime();
	}


    /**
     * 获取上一个账单日
     * @param date
     * @param billDateType
     * @return
     */
    public static Date getPrevRepayDate(Date date, short billDateType){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        int month =c.get(Calendar.MONTH);

        if(billDateType == 15){
            //日期大于15, 下一个月15日
            if(dayOfMonth<15){
                c.add(Calendar.MONTH, -1);
            }
            c.set(Calendar.DAY_OF_MONTH, 15);
            return c.getTime();
        }

        //30账单日

        //大于等于30的,都返回当月30
        if(dayOfMonth>=30){
            c.set(Calendar.DAY_OF_MONTH, 30);
            return c.getTime();
        }

        //3月比较特殊, 以及2月28,29号 那么都是2月最后一天
        if(month == 2 || (month == 1 && dayOfMonth == c.getActualMaximum(Calendar.DAY_OF_MONTH))){
            c.set(Calendar.MONTH, 1);
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            return c.getTime();
        }

        //其他的情况,取上个月的30号
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, 30);

        return c.getTime();
    }

    /**
	 * 
	 * @param date
	 * @return object[0] 是否为账单日，object[1] 账单类型
	 */
	public static Object[] getBillDateType(Date date){
		Object[] array = {false,0};
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		if(dayOfMonth==15){//当期日期是15日，则返回15的账单日
			array[0] = true;
			array[1] = Constants.LOAN_RETURN_DATE_FIFTEEN;
			return array;
		}
		// 如果是二月份，且当前天数是为二月份最后一天，则为30的账单日
		if(c.get(Calendar.MONTH)==1 && dayOfMonth==c.getActualMaximum(Calendar.DAY_OF_MONTH)){
			
			array[0] = true;
			array[1] = Constants.LOAN_RETURN_DATE_THIRTY;
			return array;
		}else if(dayOfMonth==30){
			array[0] = true;
			array[1] = Constants.LOAN_RETURN_DATE_THIRTY;
			return array;
		}else{
			return array;
		}
	}

	/**
	 * 获取24小时前
     * @return
     */
	public static Date getBefore24HoursDate(){
		LocalDateTime time = new LocalDateTime();
		return time.minusHours(24).toDate();
	}
    
  /*  @Test
    public void fun1(){
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	String dstr="2015-12-30";  
    	try{
    		java.util.Date date=sdf.parse(dstr);
    		Date addOrMinusDate = DateUtils.getAddOrMinusDate(date,-1);
        	Date prevRepayDate = DateUtils.getPrevRepayDate(addOrMinusDate,Short.valueOf("30"));
        	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        	System.out.println(sf.format(prevRepayDate));
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	
    }*/
	
	/**
	 * 获取本月第一天
	 * 2016年4月20日  下午4:50:08
	 * zhaoqiang
	 */
	public static  Date getFirstDayInTheMonth(){
        Calendar calendar = Calendar.getInstance();   
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
        return calendar.getTime();
	}
	
	/**
	 * 日期加(天数)
	 */
	public static Date addTimeByDay(Date date,int days) throws Exception
	{
	Calendar calendar=Calendar.getInstance();
	calendar.setTime(date);
	calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)+days);
	return calendar.getTime();
	}
	/**
	 * 日期加(小时)
	 * 2016年6月16日  下午3:26:20
	 * zhaoqiang
	 */
	public static Date addTimeByHour(Date date,int hour) throws Exception{
	Calendar calendar=Calendar.getInstance();
	calendar.setTime(date);
	calendar.set(Calendar.HOUR,calendar.get(Calendar.HOUR)+hour);
	return calendar.getTime();
	}
	/**
	 * 获取两个日期之间的差值         示例::2天5小时59分钟49秒
	 * 2016年6月16日  下午4:26:04
	 * zhaoqiang
	 */
	public static String  betweenTime(Date  date1 ,Date date2) throws Exception{
		int  mill=(int) (date2.getTime()-date1.getTime());
		mill=mill/1000;
		int second=mill%60;
		mill=(mill-second)/60;
		int minute=mill%60;
		mill=(mill-minute)/60;
		int hour=mill%24;
		int day=(mill-hour)/24;
		return day+"天"+hour+"小时"+minute+"分"+second+"秒";
	}


	/**
	 * 获取月份和天（例:8月31日）
	 */
	public static String getMonthAndDay(Date date){
		if(null==date)return  null;
		return sdfMD.format(date);
	}


	/**
	 * 获取时间进度(按天)
	 * @param start
	 * @param end
	 * @return
	 */
	public static BigDecimal getDateProgressByDay(Date start,Date end) throws Exception{
		Date now=new Date();
		if(now.after(end)){
			return new BigDecimal("100");
		}else if(now.before(start)){
			return new BigDecimal("0");
		}else{
			BigDecimal daysToEnd = new BigDecimal(betweenDaysMax(start, end));
			BigDecimal daysToNow = new BigDecimal(betweenDaysMax(start, now));
			BigDecimal progress = new BigDecimal("100").multiply(daysToNow.divide(daysToEnd, 5, RoundingMode.HALF_EVEN));
	    	return progress.setScale(1, RoundingMode.DOWN);
		}
	}

	public static String getDiffTimeFormatHHmmss(Date beforeDate,Date afterDate){

		//两时间差,精确到毫秒
        long diff = afterDate.getTime() - beforeDate.getTime();
        long day = diff / 86400000;                         //以天数为单位取整
        long hour= diff % 86400000 / 3600000;               //以小时为单位取整
        long min = diff % 86400000 % 3600000 / 60000;       //以分钟为单位取整
        long seconds = diff % 86400000 % 3600000 % 60000 / 1000;   //以秒为单位取整
        //天时分秒
		return day*24+hour+"时"+min+"分"+seconds+"秒";
	}
	public static void main(String[] args) {
//		for (int i = 0; i < 200; i++) {
//			Random rand = new Random();
//	        int listIndex = rand.nextInt(Constants.WECHATWISHARRAY.length);
//	        String wishMessage = Constants.WECHATWISHARRAY[listIndex];
//	        System.out.println(wishMessage+"=="+listIndex);
//		}
//		int len = 201;
//		int k =0;
//		for(int i=1;i<=len;i++){
//
//
//			if(i%100==0 || i==len){
//				System.out.println("进行分组"+(++k)+"值："+i);
//			}
//		}
//
//		System.out.println(23%100);
//		System.out.println(100%100);
//		System.out.println(101%100);
//		System.out.println("*********");
//		System.out.println(23/100);
//		System.out.println(100/100);
//		System.out.println(101/100);

		// Java 8之前：
//		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//		for (Object ss : features) {
//			System.out.println(ss);
//		}

// Java 8之后：
//		List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//		features.forEach(n ->System.out.println(n));

// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
// 看起来像C++的作用域解析运算符

		System.out.println(TimeConstant.SIMPLE_TIME_FORMAT_CN.format(new Date()));

		try {

			Date startTime=DateUtils.sdf.parse(DateUtils.sdf_Y.format(new Date())+" 00:00:00");
			Date endTime = LocalDate.fromDateFields(new Date()).plusDays(14).toDate();
			endTime=DateUtils.sdf.parse(DateUtils.sdf_Y.format(endTime)+" 23:59:59");
			System.out.println(endTime);
		} catch (Exception e) {
		    logger.info("",e);
		}

		byte[] af = "adafs".getBytes();
		System.out.println("=========");
		for (byte a : af){
			System.out.println(a);
		}
		System.out.println(af.length);

	}

	/**
	 * 日期加减运算
	 * @param date 日期
	 * @param field 时间类型 Calendar.MINUTE
	 * @param amount 数字
	 * @return
	 */
	public static Date getIntervalTime(Date date, int field, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(field, amount);
		return c.getTime();
	}

	/**
	 * 获取某月时间范围
	 * @param month(20170101)
	 * @return
	 * @throws ParseException
	 *
	 * 修正结束日期 modify by liangyu 2017-06-01
	 */
	public static Date[] getOneMonthRange(String month) {
		Date[] dates = {null, null};
		if(org.apache.commons.lang3.StringUtils.isNotBlank(month)){
			Date startDate = DateUtils.stringParseDate(month,"yyyyMMdd");
			Calendar instance = Calendar.getInstance();
			instance.setTime(startDate);
			int actualMaximum = instance.getActualMaximum(Calendar.DAY_OF_MONTH);
			instance.add(Calendar.DATE, actualMaximum);
			instance.add(Calendar.MILLISECOND, -1);
			Date endDate = instance.getTime();
			dates = new Date[]{startDate, endDate};
		}
		return dates;
	}

	/**
	 * 获取本月最后一天
	 * 2016年4月20日  下午4:50:08
	 * zhaoqiang
	 */
	public static  Date getLostDayInTheMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		return calendar.getTime();
	}

	/**
	 * 获取年月日（例:20170606）,当前日期的前一天
	 * 2017年5月31日  下午3:05:00
	 * chenhaotong
	 */
	public static String getYearAndMonthAndDay(Date date){
		if(null==date)return  null;
		return sdf_YMD.format(getAddOrMinusDate(date,-1));
	}

	/**
	 * 获取本周第一天
	 * @return
	 */
	public static Date getFirstDateByWeek() throws Exception{
		Calendar cal = Calendar.getInstance();
		//获取每周几（周日显示w=0）
		int w = cal.get(Calendar.DAY_OF_WEEK)-1;

		// 设置时分秒
		cal.set(Calendar.HOUR_OF_DAY, 0);// 小时
		cal.set(Calendar.MINUTE, 0);// 分钟
		cal.set(Calendar.SECOND, 0);// 秒

		Date date = cal.getTime();
		if(w==0){
			//周日减6天
			date =addTimeByDay(date,-6);
		}else {
			date = DateUtils.addTimeByDay(date,-(w-1));
		}

		return date;
	}

	/**
	 * 获取本季度的第一天
	 * @return
	 */
	public static Date getFirstDayByQuarter() throws Exception{
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		if (currentMonth >= 1 && currentMonth <= 3)
			c.set(Calendar.MONTH, 0);
		else if (currentMonth >= 4 && currentMonth <= 6)
			c.set(Calendar.MONTH, 3);
		else if (currentMonth >= 7 && currentMonth <= 9)
			c.set(Calendar.MONTH, 6);
		else if (currentMonth >= 10 && currentMonth <= 12)
			c.set(Calendar.MONTH, 9);
		c.set(Calendar.DATE, 1);

		//设置时分秒
		c.set(Calendar.HOUR_OF_DAY, 0);// 小时
		c.set(Calendar.MINUTE, 0);// 分钟
		c.set(Calendar.SECOND, 0);// 秒

		return c.getTime();
	}

	public static Date getDateByTiming(int hour,int minute,int second){
		Calendar c = Calendar.getInstance();
		//设置小时
		c.set(Calendar.HOUR_OF_DAY, hour);// 小时
		c.set(Calendar.MINUTE, minute);// 分钟
		c.set(Calendar.SECOND, second);// 秒
		return c.getTime();
	}

	/**
	 * 获取下个月第一天
	 */
	public static  Date getLostDayInTheNextMonth(){
		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		return calendar.getTime();
	}

	/**
	 *获取小时
	 */
	public static int getHourOfDay(){
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 *获取日
	 */
	public static int getDayForMonth(){
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
}
