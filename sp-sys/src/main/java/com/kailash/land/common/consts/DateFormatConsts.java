package com.kailash.land.common.consts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * <pre>
 * 功能说明：日期格式化类
 * </pre>
 *
 * @author ztl
 * @version 1.0
 */
public class DateFormatConsts {
	/**
	 * 时间格式(yyyy-MM-dd)
	 */
	public final static String DATE_PATTERN = "yyyy-MM-dd";

	/**
	 * 时间格式(yyyy年MM月dd日)
	 */
	public final static String DATE_CHINESE = "yyyy年MM月dd日";

	/**
	 * 时间格式(yyyyMMdd)
	 */
	public final static String DATE_PATTERN_NO = "yyyyMMdd";
	/**
	 * 时间格式(yyyyMMddHHmmss)
	 */
	public final static String DATE_PATTERN_MO = "yyyyMMddHHmmss";
	/**
	 * 时间格式(yyyyMMddHH)
	 */
	public final static String DATE_PATTERN_HOUR = "yyyyMMddHH";
	/**
	 * 时间格式(yyyy-MM-dd HH:mm:ss)
	 */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * "yyyy-MM-dd" 的format
	 */
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_PATTERN, java.util.Locale.CHINA);

	public static final DateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss", java.util.Locale.CHINA);

	public static final DateFormat DATE_TIME_FORMAT = new SimpleDateFormat(DATE_TIME_PATTERN, java.util.Locale.CHINA);

	public static final DateFormat DATE_TIME_FORMAT_STR = new SimpleDateFormat(DATE_PATTERN_MO, java.util.Locale.CHINA);

	public static final DateFormat YYYYMMDDHHMM_DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm",
			java.util.Locale.CHINA);

}
