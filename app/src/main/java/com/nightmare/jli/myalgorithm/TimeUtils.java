package com.nightmare.jli.myalgorithm;

/**
 * 时间值操作类
 * Created by J.Li on 2016/5/25.
 */
public class TimeUtils {

    /**
     * 获取可识读时间字符串
     * @param tempTimelong
     * @return
     */
    public static String getTimeString(long tempTimelong){

        String returnValue="";

        long[] tempTimeValue=new long[]{tempTimelong};
        long sec2ms=1000;
        long min2ms=60*sec2ms;
        long hour2ms=60*min2ms;
        long day2ms=24*hour2ms;


        long day=getRealValue(tempTimeValue,day2ms);
        returnValue+=day+".";
        long hour=getRealValue(tempTimeValue,hour2ms);
        returnValue+=hour+":";
        long min=getRealValue(tempTimeValue,min2ms);
        returnValue+=min+":";
        long s=getRealValue(tempTimeValue,sec2ms);
        returnValue+=s+":";
        long ms=tempTimeValue[0];
        returnValue+=ms;

        return returnValue;
    }

    /**
     * 根据进制获取具体值
     * @param tempTimelong
     * @param conversion
     * @return
     */
    private static long getRealValue(long[] tempTimelong,long conversion){
        long returnValue=tempTimelong[0]/conversion;
        tempTimelong[0]=tempTimelong[0]-returnValue*conversion;
        return returnValue;
    }

}
