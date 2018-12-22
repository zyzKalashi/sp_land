package com.kailash.land.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 日期处理
 */
public class DateUtils extends DateFormatConsts {
	public static final boolean checkIsDate(String date, String regex) {
		Pattern p = Pattern.compile(regex);
		return p.matcher(date).find();
	}

	/**
	 * 格式化日期
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}

	/**
	 * 判断当前日期和数据库保存的日期差是否超过24小时
	 * @return
	 */
	public static Boolean dataLimit24(String date){
		Date date1 = parse(date,DATE_TIME_PATTERN);
		// 当前日期
		Date date2 = new Date();
		long between = date2.getTime() - date1.getTime();
		if(between > (24* 3600000)){
			// 超过24小时返回true
			return true;
		}
		// 未超过24小时返回false
		return false;
	}


	/**
	 * java.sql.Timestamp转String
	 * 
	 * @param time
	 * @param strFormat
	 * @return
	 */
	public static String timestampToStr(java.sql.Timestamp time, String strFormat) {
		DateFormat df = new SimpleDateFormat(strFormat);
		String str = df.format(time);
		return str;
	}

	/**
	 * 日期解析
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date parse(String date, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			if (date != null && !"".equals(date)) {
				return df.parse(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date getThisWeekMonday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 获得当前日期是一个星期的第几天
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		return cal.getTime();
	}

	public static Date getThisMonthFirst(Date date) {
		// 获取前月的第一天
		Calendar cal = Calendar.getInstance();// 获取当前日期
		cal.setTime(date);
		cal.add(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getYestodayEnd(Date date) {
		// 获取前月的第一天
		Calendar cal = Calendar.getInstance();// 获取当前日期
		cal.setTime(new Date(date.getTime() - 24 * 60 * 60 * 1000));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static Date getYestodayStart(Date date) {
		// 获取前月的第一天
		Calendar cal = Calendar.getInstance();// 获取当前日期
		cal.setTime(new Date(date.getTime() - 24 * 60 * 60 * 1000));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 时间格式(yyyy-MM-dd)
	 */
	public static final ThreadLocal<DateFormat> DF_DATE = new ThreadLocal<DateFormat>() {

		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat(DATE_PATTERN);
		}

	};

	/**
	 * 时间格式(yyyyMMdd)
	 */
	public static final ThreadLocal<DateFormat> DF_DATE_NO = new ThreadLocal<DateFormat>() {

		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat(DATE_PATTERN_NO);
		}

	};

	/**
	 * 时间格式(yyyy-MM-dd HH:mm:ss)
	 */
	public static final ThreadLocal<DateFormat> DF_DATE_TIME = new ThreadLocal<DateFormat>() {

		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat(DATE_TIME_PATTERN);
		}

	};

	/**
	 * 获取今天日期
	 *
	 * @param yyMMdd:格式为yy-MM-dd
	 * @return yy-MM-(dd+1) 00:00:00:0000
	 * @author zyz
	 */
	public static String today(String yyMMdd) {
		if (StringUtils.isEmpty(yyMMdd)) {
			return "";
		} else {
			return yyMMdd + " 00:00:00:0000";
		}
	}
	
	/**
	 * 获取后一天日期
	 *
	 * @param yyMMdd:格式为yy-MM-dd
	 * @return yy-MM-(dd+1) 00:00:00:0000
	 * @author zyz
	 */
	public static String afterDay(String yyMMdd) {
		if (StringUtils.isEmpty(yyMMdd)) {
			return "";
		}
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(yyMMdd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter + " 00:00:00:0000";
	}

	/**
	 * 获取当前日期前n天日期
	 * 
	 * @author zyz
	 * @return 当前日期上一天的yy-MM-dd格式
	 */
	public static String preDayYYMMDD(int n) {
		Calendar c = Calendar.getInstance();
		Date date = new Date();
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - n);
		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayBefore;
	}

	/**
	 * 获取两个日期间的所有日期
	 * 
	 * @author zyz
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> everyDate(String minDate, String maxDate) throws ParseException {
		LocalDate start = LocalDate.parse(minDate);
		LocalDate end = LocalDate.parse(maxDate);
		return Stream.iterate(start, localDate -> localDate.plusDays(1))
                // 截断无限流，长度为起始时间和结束时间的差+1个
                .limit(ChronoUnit.DAYS.between(start, end) + 1)
                // 由于最后要的是字符串，所以map转换一下
                .map(LocalDate::toString)
                // 把流收集为List
                .collect(Collectors.toList());
	}

	/**
	 * 获取两个日期间相差天数
	 * 
	 * @author zyz
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static int compareTwoDate(String minDate, String maxDate) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		Date startDate = df.parse(minDate);
		startCalendar.setTime(startDate);
		Date endDate = df.parse(maxDate);
		endCalendar.setTime(endDate);
		int days = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 3600 * 24));
		return days;

	}

	public static void main(String[] args) {
		try {
			Boolean aBoolean = dataLimit24("2018-09-06 11:58:15");
			System.out.println(aBoolean);
			System.out.println(everyDate("2018-06-30", "2018-07-03"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
