package com.ylee.a02thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb1;
    Button btnInc, btnDec;
    SeekBar sb1, sb2;
    TextView tvSeek;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = findViewById(R.id.pBar1);
        btnInc = findViewById(R.id.btnInc);
        btnDec = findViewById(R.id.btnDec);
        sb1 = findViewById(R.id.sBar1);
        sb2 = findViewById(R.id.sBar2);
        tvSeek = findViewById(R.id.tvSeek);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                for(int i=0; i<100; ++i){
//                    sb1.setProgress(sb1.getProgress()+2);
//                    sb2.setProgress(sb2.getProgress()+1);
//                    SystemClock.sleep(100);
//                }
                new Thread(){
                    public void run(){
                        for(int i=0; i< 100; i=i+2){
                            sb1.setProgress(sb1.getProgress()+2);
                            SystemClock.sleep(100);
                        }
                    }
                }.start();

                new Thread(){
                    public void run(){
                        for(int i=0; i< 100; i=i+1){
                            sb2.setProgress(sb2.getProgress()+1);
                            SystemClock.sleep(100);
                        }
                    }
                }.start();
            }
        });
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeek.setText("진행율1: " + progress + "%" );

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {  }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });

        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeek.setText("진행율2: " + progress + "%" );
                pb1.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb1.incrementProgressBy(10);
            }
        });
        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb1.incrementProgressBy(-10);
            }
        });
    }
}
