package com.example.chino.project4;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Main extends AppCompatActivity
    implements SensorEventListener{
    SensorManager sencM ;
    Sensor acc ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sencM = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        acc = sencM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            Log.d("Main",
                    "x=" + String.valueOf(event.values[0])+
                            "y=" + String.valueOf(event.values[1])+
                            "z=" + String.valueOf(event.values[2]));

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        sencM.registerListener(this,acc,SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sencM.unregisterListener(this);
    }

    }






