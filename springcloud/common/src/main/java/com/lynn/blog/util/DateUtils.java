package com.lynn.blog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;

/**
 * 日期处理类
 * @author Administrator
 *
 */
public final class DateUtils {

	public static boolean isLegalDate(String str,String pattern) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			format.parse(str);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	/**
	 * 字符串转日期
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static Date parseString2Date(String str,String pattern) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			return format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Calendar parseString2Calendar(String str,String pattern) {
		return parseDate2Calendar(parseString2Date(str, pattern));
	}
	public static Calendar parseDate2Calendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	public static String parseLong2DateString(long date,String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String sd = format.format(new Date(date));
		return sd;
	}
	
	public static Date parseCalendar2Date(Calendar calendar) {
		return calendar.getTime();
	}
	/**
	 * 日期转 String
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String parseDate2String(Date date,String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}
	
	public static String formatTime(long time) {
		long nowTime = System.currentTimeMillis();
		long interval = nowTime-time;
		long hours = 3600*1000;
		long days = hours*24;
		long fiveDays = days*5;
		if(interval<hours) {
			long minute = interval/1000/60;
			if(minute==0) {return "刚刚";}
			return minute+"分钟前";
		}else if(interval<days) {
			return interval/1000/3600+"小时前";
		}else if(interval<fiveDays) {
			return interval/1000/3600/24+"天前";
		}else {
			Date date = new Date(time);
			return parseDate2String(date, "MM-dd");
		}
	}
	/**
	 * 获取当前日期后 90日的日期
	 * @return
	 */
	public static String getDateTime() {
		DateTime dateTime = new DateTime();
		return dateTime.plusDays(90).toString("yyyy-mm-dd HH:mm:ss");
	}
}
