package com.example.chino.janken;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class janken extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_janken);
        SharedPreferences resultdata = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = resultdata.edit();
        editor.clear();
        editor.commit();

    }
    public void jankenpad (View view){
        Intent A = new Intent (this, result.class);
        A.putExtra("MY_HAND",view.getId());
        startActivity(A);
    }
}
