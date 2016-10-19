package com.nightmare.jli.Algorithm;

import android.util.Log;

import com.nightmare.jli.myalgorithm.MainActivity;
import com.nightmare.jli.myalgorithm.TimeUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 归并排序
 * Created by J.Li on 2016/6/1.
 */
public class Algorithm_MergeSort {

    private static int[] mergeSort_TempData;

    public static String MergeSort(int[] values){
        DateFormat df = new SimpleDateFormat("HH:mm:ss.SSS");
        Log.d(MainActivity.TAG, "MergeSort EnterTime:" + df.format(new Date()));

        long startTimeLong = System.currentTimeMillis();

        mergeSort_TempData=new int[values.length];
        mergesort(values,0,values.length-1);
        mergeSort_TempData=null;

        String returnValue = "归并排序\r\n耗时："+ TimeUtils.getTimeString(System.currentTimeMillis()-startTimeLong);

        Log.d(MainActivity.TAG, "MergeSort LeaveTime:" + df.format(new Date()));

        return returnValue;
    }

    private static void mergesort(int[] values,int first,int last){
        if(first<last){
            int mid=(first+last)/2;
            mergesort(values,first,mid);
            mergesort(values, mid + 1, last);
            mergearray(values,first,mid,last);
        }
    }

    private static void mergearray(int[] values,int first,int mid,int last) {

        int i = first;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= last) {
            if (values[i] <= values[j]) {
                mergeSort_TempData[k++] = values[i++];
            } else {
                mergeSort_TempData[k++] = values[j++];
            }
        }

        while (i <= mid) {
            mergeSort_TempData[k++] = values[i++];
        }

        while (j <= last) {
            mergeSort_TempData[k++] = values[j++];
        }

        for (int tempindex = 0; tempindex < k; tempindex++) {
            values[first + tempindex] = mergeSort_TempData[tempindex];
        }

    }
}
