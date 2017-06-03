package com.example.chino.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int id = intent.getIntExtra("MY_HAND",0);
        ImageView myHandImigeView = (ImageView) findViewById(R.id.my_hand);
        switch (id) {
            case R.id.gu:
                myHandImigeView.setImageResource(R.drawable.gu);
                break;
            case R.id.tyoki:
                myHandImigeView.setImageResource(R.drawable.tyo);
                break;
            case R.id.pa:
                myHandImigeView.setImageResource(R.drawable.pa);
                break;
            default:
                break;


        }
    }
}
