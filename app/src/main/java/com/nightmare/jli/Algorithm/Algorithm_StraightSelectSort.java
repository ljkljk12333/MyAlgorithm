package com.nightmare.jli.Algorithm;

import android.util.Log;

import com.nightmare.jli.myalgorithm.MainActivity;
import com.nightmare.jli.myalgorithm.TimeUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 直接选择排序
 * Created by J.Li on 2016/5/26.
 */
public class Algorithm_StraightSelectSort {

    public static String StraightSelectSort(int[] values){
        DateFormat df = new SimpleDateFormat("HH:mm:ss.SSS");
        Log.d(MainActivity.TAG, "StraightSelectSort EnterTime:" + df.format(new Date()));

        long startTimeLong = System.currentTimeMillis();

        for (int i = 0; i < values.length; i++) {
            int tempIndex=i;
            for (int j=i+1;j<values.length;j++){
                if(values[j]<values[tempIndex]){
                    tempIndex=j;
                }
            }
            if(tempIndex!=i){
                swap(values,i,tempIndex);
            }
        }

        String returnValue = "直接选择排序\r\n耗时："+ TimeUtils.getTimeString(System.currentTimeMillis()-startTimeLong);

        Log.d(MainActivity.TAG, "StraightSelectSort LeaveTime:" + df.format(new Date()));

        return returnValue;
    }

    /**
     * 交换位置
     * @param values
     * @param oldIndex
     * @param newIndex
     * @return
     */
    private static void swap(int[] values,int oldIndex,int newIndex) {
        int tempValue = values[oldIndex];
        values[oldIndex] = values[newIndex];
        values[newIndex] = tempValue;
    }

}
