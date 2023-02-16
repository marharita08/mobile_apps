package com.example.android.hellotoast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        TextView mShowCount = (TextView) findViewById(R.id.count);
        mShowCount.setText(Integer.toString(getIntent().getIntExtra("count", 0)));
    }

}
