package com.example.chino.janken;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class result extends AppCompatActivity {
    final int GU=0;
    final int TYO=1;
    final int PA=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent A = getIntent();
        int id = A.getIntExtra("MY_HAND",0);
        int myhand = 0;

        ImageView myhandimgview = (ImageView) findViewById(R.id.my_hand);
        switch(id){
            case R.id.gu_button:
                myhandimgview.setImageResource(R.drawable.gu);
                myhand = GU;
                break;
            case R.id.tyoki_button:
                myhandimgview.setImageResource(R.drawable.tyo);
                myhand = TYO;
                break;
            case R.id.pa_buttin:
                myhandimgview.setImageResource(R.drawable.pa);
                myhand = PA;
                break;
            default:
                myhand = GU;
                break;

        }
        int cpuhand = gethand();
        ImageView cpuhandimgview = (ImageView) findViewById(R.id.cpu_hand);
        switch(cpuhand) {
            case GU :
                cpuhandimgview.setImageResource(R.drawable.gu);
                break;
            case TYO :
                cpuhandimgview.setImageResource(R.drawable.tyo);
                break;
            case PA :
                cpuhandimgview.setImageResource(R.drawable.pa);
                break;
            //cpuの手を確定
        }
        TextView result = (TextView) findViewById( R.id.result);
        int resultN = (cpuhand-myhand+3)%3;
        switch(resultN){
            case 0:
                result.setText(R.string.drow);
                break;
            case 1:
                result.setText(R.string.win);
                break;
            case 2:
                result.setText(R.string.lose);
                break;
        }
        savedate(myhand, cpuhand, resultN);
    }
    private void savedate(int myhand, int cpuhand, int resultN ){
        SharedPreferences resultdata = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = resultdata.edit();
        int gamecount = resultdata.getInt("GAMECOUNT",0);
        int wincount = resultdata.getInt("WINCOUNT",0);
        int lastcpuhand = resultdata.getInt("LASTCPUHAND",0);
        int lastresult = resultdata.getInt("LASTRESULT",-1);
        editor.putInt("GAMECOUT",gamecount+1);
        if (lastresult==2 && resultN==2) {
            editor.putInt("WINCOUNT", wincount + 1);
        }else {
            editor.putInt("WINCOUNT",0);
        }
        editor.putInt("LASTCPUHAND",cpuhand);
        editor.putInt("LASTMYHAND",myhand);
        editor.putInt("NXLASTCPUHAND",lastcpuhand);
        editor.putInt("RESULT",resultN);

        editor.commit();
    }
    private int gethand (){
        int hand = (int)(Math.random()*3);
        SharedPreferences resultdata = PreferenceManager.getDefaultSharedPreferences(this);
        int gamecount = resultdata.getInt("GAMECOUNT",0);
        int wincount = resultdata.getInt("WINCOUNT",0);
        int lastmyhand = resultdata.getInt("LUSTMYHAND",0);
        int lastcpuhand = resultdata.getInt("LASTCPUHAND",0);
        int nxlastcpuhand = resultdata.getInt("NXLASTCPUHAND",0);
        int result = resultdata.getInt("RESULT",-1);
        if (gamecount == 1){
            if (result == 2){
                while (lastcpuhand == hand) {
                    hand = (int) (Math.random() * 3);
                }
            }else if (result == 1){
                hand = (lastmyhand + 2) % 3;
            }
        }else if (wincount > 0){
            if (nxlastcpuhand == lastcpuhand){
                while (hand == lastcpuhand){
                    hand = (int)(Math.random()*3);
                }
            }
        }return hand;
    }

    public  void finish (View view ){
        finish();
    }

}
