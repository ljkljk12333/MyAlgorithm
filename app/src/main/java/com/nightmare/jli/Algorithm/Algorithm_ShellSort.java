package com.nightmare.jli.Algorithm;

import android.util.Log;

import com.nightmare.jli.myalgorithm.MainActivity;
import com.nightmare.jli.myalgorithm.TimeUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 希尔排序
 * Created by J.Li on 2016/5/25.
 */
public class Algorithm_ShellSort {

    /**
     * 希尔排序
     * @param values
     * @return
     */
    public static String ShellSort(int[] values) {
        DateFormat df = new SimpleDateFormat("HH:mm:ss.SSS");
        Log.d(MainActivity.TAG, "ShellSort EnterTime:" + df.format(new Date()));

        long startTimeLong = System.currentTimeMillis();

        int d = values.length / 2;
        while (d >= 1) {
            ShellInsert(values, d);
            d = d / 2;
        }

        String returnValue = "希尔排序\r\n耗时："+ TimeUtils.getTimeString(System.currentTimeMillis()-startTimeLong);

        Log.d(MainActivity.TAG, "ShellSort LeaveTime:" + df.format(new Date()));

        return returnValue;
    }

    /**
     * 插入排序
     * @param values
     * @param d
     * @return
     */
    private static void ShellInsert(int[] values, int d) {
        for (int i=d;i<values.length;i+=1){
            if(values[i-d]>values[i]){
                int tempValue=values[i];
                int j=i;
                while (j>=d&&values[j-d]>tempValue){
                    values[j]=values[j-d];
                    j-=d;
                }
                values[j]=tempValue;
            }
        }
    }

    /**
     * 交换位置
     * @param values
     * @param oldIndex
     * @param newIndex
     * @return
     */
    private static void swap(int[] values, int oldIndex, int newIndex) {
        int tempValue = values[oldIndex];
        values[oldIndex] = values[newIndex];
        values[newIndex] = tempValue;
    }

}
