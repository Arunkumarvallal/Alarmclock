package com.example.admin.alarmclock;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextClock;
import android.widget.TimePicker;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
TimePicker alarmtime;
TextClock currentTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmtime=findViewById(R.id.simpleTimePicker);
        currentTime=findViewById(R.id.clock);



    }

    public String AlarmTime(){
        Integer hour,min;
        hour=alarmtime.getCurrentHour();
        min=alarmtime.getCurrentMinute();
        String salarmtime,salarmmin="0";
        if(min<10){
            salarmmin=salarmmin.concat(min.toString());
        }
        else{
            salarmmin=min.toString();
        }

        if(hour>12){
            hour=hour-12;
            salarmtime=hour.toString().concat(":").concat(salarmmin).concat(" PM");
        }
        else{
            salarmtime=hour.toString().concat(":").concat(salarmmin).concat(" AM");
        }
    return salarmtime;
    }

    public void setAlarm(View view) {

        final Ringtone ring=RingtoneManager.getRingtone(getApplicationContext(),RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM));
        Timer t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if(currentTime.getText().equals(AlarmTime())){
                    ring.play();
                }
                else{
                    ring.stop();
                }
            }
        },0,1000);
    }
}
