package com.nightmare.jli.myalgorithm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nightmare.jli.Algorithm.Algorithm_BubbleSort;
import com.nightmare.jli.Algorithm.Algorithm_HeapSort;
import com.nightmare.jli.Algorithm.Algorithm_MergeSort;
import com.nightmare.jli.Algorithm.Algorithm_QuickSort;
import com.nightmare.jli.Algorithm.Algorithm_ShellSort;
import com.nightmare.jli.Algorithm.Algorithm_StraightSelectSort;

import java.util.Random;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends Activity implements View.OnClickListener {

    public static final String TAG = "AlgorithmTime";

    Button button_BubbleSort;
    Button button_HeapSort;
    Button button_MergeSort;
    Button button_QuickSort;
    Button button_ShellSort;
    Button button_StraightSelectSort;
    Button button_ResetArray;

    TextView textView;

    /**
     * 随机数数组
     */
    int[] algorithmDataArray;
    /**
     * 随机数最大值
     */
    final int maxDataValue=1000;
    /**
     * 随机数数组总数量
     */
    final int datasCount=1000;

    Observer<String> textObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.data);

        button_ResetArray=(Button)findViewById(R.id.button_ResetArray);

        button_BubbleSort=(Button)findViewById(R.id.button_BubbleSort);
        button_HeapSort=(Button)findViewById(R.id.button_HeapSort);
        button_MergeSort=(Button)findViewById(R.id.button_MergeSort);
        button_QuickSort=(Button)findViewById(R.id.button_QuickSort);
        button_ShellSort=(Button)findViewById(R.id.button_ShellSort);
        button_StraightSelectSort=(Button)findViewById(R.id.button_StraightSelectSort);


        textObserver=new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String dataString) {
                textView.setText(dataString);
            }
        };

        algorithmDataArray = initdata(datasCount);

        button_ResetArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("正在重新生成随机数组，请稍等...");

                Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        algorithmDataArray = initdata(datasCount);
                        subscriber.onNext("随机数组已重新生成");
                        subscriber.onCompleted();
                    }
                })
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(textObserver);

            }
        });

        button_BubbleSort.setOnClickListener(MainActivity.this);
        button_HeapSort.setOnClickListener(MainActivity.this);
        button_MergeSort.setOnClickListener(MainActivity.this);
        button_QuickSort.setOnClickListener(MainActivity.this);
        button_ShellSort.setOnClickListener(MainActivity.this);
        button_StraightSelectSort.setOnClickListener(MainActivity.this);

    }

    /**
     * 初始化数据
     * @param size
     * @return
     */
    private int[] initdata(int size){
        int[] returnValue=new int[size];
        Random r=new Random();
        for(int i=0;i<size;i++){
            returnValue[i]=r.nextInt(maxDataValue);
        }
        return returnValue;
    }

    private String sortValues( int[] values,int viewID) {
        String returnValue = "";
        switch (viewID) {
            case R.id.button_BubbleSort: {
                returnValue = Algorithm_BubbleSort.BubbleSort(values);
                break;
            }
            case R.id.button_HeapSort: {
                returnValue = Algorithm_HeapSort.HeapSort(values);
                break;
            }
            case R.id.button_MergeSort: {
                returnValue = Algorithm_MergeSort.MergeSort(values);
                break;
            }
            case R.id.button_QuickSort: {
                returnValue = Algorithm_QuickSort.QuickSort(values);
                break;
            }
            case R.id.button_ShellSort: {
                returnValue = Algorithm_ShellSort.ShellSort(values);
                break;
            }
            case R.id.button_StraightSelectSort: {
                returnValue = Algorithm_StraightSelectSort.StraightSelectSort(values);
                break;
            }
        }
        return returnValue;
    }

    @Override
    public void onClick(View v) {

        textView.setText("正在排序，请稍等...");

        final int tempViewID=v.getId();

        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                int[] values = algorithmDataArray.clone();

                String dataString = sortValues(values,tempViewID) + "\r\n";

                for (int i = 0; i < values.length; i++) {
                    dataString += "第" + (i + 1) + "个:" + values[i] + "\r\n";
                }
                subscriber.onNext(dataString);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(textObserver);
    }
}
