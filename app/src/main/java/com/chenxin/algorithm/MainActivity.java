package com.chenxin.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] array = new int[]{6, 5, 4, 3, 2, 1};
        SortUtils.MergeSort(array, array.length);
        //SortUtils.printArray(array);
    }
}
