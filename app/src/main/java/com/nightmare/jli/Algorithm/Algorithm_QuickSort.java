package com.nightmare.jli.Algorithm;

import android.util.Log;

import com.nightmare.jli.myalgorithm.MainActivity;
import com.nightmare.jli.myalgorithm.TimeUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 快速排序
 * Created by J.Li on 2016/5/25.
 */
public class Algorithm_QuickSort {

    /**
     * 快速排序
     * @param values
     * @return
     */
    public static String QuickSort(int[] values) {

        DateFormat df = new SimpleDateFormat("HH:mm:ss.SSS");
        Log.d(MainActivity.TAG, "QuickSort EnterTime:" + df.format(new Date()));

        long startTimeLong = System.currentTimeMillis();

        quickArray(values,values.length);

        String returnValue = "快速排序\r\n耗时："+ TimeUtils.getTimeString(System.currentTimeMillis()-startTimeLong);

        Log.d(MainActivity.TAG, "QuickSort LeaveTime:" + df.format(new Date()));

        return returnValue;
    }

    private static void quickArray(int[] values,int size) {
        if (values.length > 1) {
            int[] lowdata = new int[size];
            int[] highdata = new int[size];
            int lowdatasize=0;
            int highdatasize=0;
            int tempValue = values[0];
            for (int i = 1; i < size; i++) {
                if (values[i] <= tempValue) {
                    lowdata[lowdatasize++]=values[i];
                } else {
                    highdata[highdatasize++]=values[i];
                }
            }
            quickArray(lowdata,lowdatasize);
            quickArray(highdata,highdatasize);

            System.arraycopy(lowdata, 0, values, 0, lowdatasize);
            values[lowdatasize] = tempValue;
            System.arraycopy(highdata, 0, values, lowdatasize + 1, highdatasize);
            lowdata=null;
            highdata=null;
        }
    }

    /**
     * Integer链表转int数组
     * @param templist
     * @return
     */
    private static int[] IntegerListTointArray(ArrayList<Integer> templist) {
        int[] returnValue = new int[templist.size()];
        for (int i = 0; i < templist.size(); i++) {
            returnValue[i] = templist.get(i);
        }
        return returnValue;
    }
}
