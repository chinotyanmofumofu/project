package com.example.chino.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void janken(View view) {
        Intent intent = new Intent (this, ResultActivity.class);
        intent.putExtra("MY_HAND",view.getId());
        startActivity(intent);

    }
}
