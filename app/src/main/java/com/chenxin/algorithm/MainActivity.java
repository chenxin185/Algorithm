package com.chenxin.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] array = new int[]{622,32,42,52,62,72,82,92,102,112,122,132,142,152,162, 53, 4123, 321, 2, 1};
        SortUtils.baseSort(array,4);
        SortUtils.printArray(array);
    }
}
