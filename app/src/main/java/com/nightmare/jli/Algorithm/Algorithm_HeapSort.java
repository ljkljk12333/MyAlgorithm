package com.nightmare.jli.Algorithm;

import android.util.Log;

import com.nightmare.jli.myalgorithm.MainActivity;
import com.nightmare.jli.myalgorithm.TimeUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 堆排序
 * Created by J.Li on 2016/5/25.
 */
public class Algorithm_HeapSort {

    /**
     * 堆排序
     * @param values
     * @return
     */
    public static String HeapSort(int[] values) {

        DateFormat df = new SimpleDateFormat("HH:mm:ss.SSS");
        Log.d(MainActivity.TAG, "HeapSort EnterTime:" + df.format(new Date()));

        long startTimeLong = System.currentTimeMillis();

        int size = values.length;
        BuilHeap(values, size);
        for (int i = size - 1; i >= 0; i--) {
            swap(values, 0, i);
            HeapAdjust(values, 0, i);
        }

        String returnValue = "堆排序\r\n耗时："+ TimeUtils.getTimeString(System.currentTimeMillis()-startTimeLong);

        Log.d(MainActivity.TAG, "HeapSort LeaveTime:" + df.format(new Date()));

        return returnValue;
    }

    private static void BuilHeap(int[] values,int size){
        for(int i=size/2;i>=0;i--){
            HeapAdjust(values,i,size);
        }
    }

    private static void HeapAdjust(int[] values,int index,int size){
        int lchildIndex=2*index+1;
        int rchildIndex=2*index+2;
        int tempIndex=index;
        if(index<size/2){
            if(lchildIndex<size&&values[lchildIndex]>values[tempIndex]){
                tempIndex=lchildIndex;
            }
            if(rchildIndex<size&&values[rchildIndex]>values[tempIndex]){
                tempIndex=rchildIndex;
            }
            if(tempIndex!=index){
                swap(values,index,tempIndex);
                HeapAdjust(values,tempIndex,size);
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
    private static void swap(int[] values,int oldIndex,int newIndex) {
        int tempValue = values[oldIndex];
        values[oldIndex] = values[newIndex];
        values[newIndex] = tempValue;
    }
}
