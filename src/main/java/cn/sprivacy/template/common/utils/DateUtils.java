package cn.sprivacy.template.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 时间工具类
 */
public class DateUtils {

    /**
     * 获取当前格式化日期
     *
     * @return String
     */
    public static String getCurrentFromatDate() {
        Date currentDate = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(currentDate);
    }

    /**
     * 获取当前格式化时间
     *
     * @return String
     */
    public static String getCurrentFromatTime() {
        Date currentTime = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(currentTime);
    }

    /**
     * 将指定日期格式化
     *
     * @param date 指定格式化的日期
     * @return String
     */
    public static String getFromatDate(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 将指定日期格式化
     *
     * @param date 指定格式化的时间
     * @return String
     */
    public static String getFromatTime(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 将日期字符串转换成日期类型
     *
     * @param date 字符串日期
     * @return Date
     */
    public static Date getDate(String date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取时间
     *
     * @param startTime
     * @param endTime
     * @return Map<String, Long>
     */
    public static Map<String, Long> getDistanceTimes(long startTime, long endTime) {
        long diff = endTime - startTime;
        long day = diff / (24 * 60 * 60 * 1000);
        long hour = (diff / (60 * 60 * 1000) - day * 24);
        long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        Map<String, Long> map = new HashMap<>();
        map.put("day", day);
        map.put("hour", hour);
        map.put("min", min);
        map.put("sec", sec);
        return map;
    }
}
