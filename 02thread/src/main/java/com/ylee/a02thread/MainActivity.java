package com.ylee.a02thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
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
    BackgroundThread thread1, thread2;
    BackgroundTask task1, task2, task3;

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

        thread1 = new BackgroundThread(sb1, 2);
        thread2 = new BackgroundThread(sb2, 1);
        task1 = new BackgroundTask();
        task2 = new BackgroundTask(sb1, 1);
        task3 = new BackgroundTask(sb2, 2);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task2.execute();
                task3.execute();
                //task1.execute();
//                thread1.start();
//                thread2.start();
//                for(int i=0; i<100; ++i){
//                    sb1.setProgress(sb1.getProgress()+2);
//                    sb2.setProgress(sb2.getProgress()+1);
//                    SystemClock.sleep(100);
//                }
//                new Thread(){
//                    public void run(){
//                        for(int i=0; i< 100; i=i+2){
//                            sb1.setProgress(sb1.getProgress()+2);
//                            SystemClock.sleep(100);
//                        }
//                    }
//                }.start();
//
//                new Thread(){
//                    public void run(){
//                        for(int i=0; i< 100; i=i+1){
//                            sb2.setProgress(sb2.getProgress()+1);
//                            SystemClock.sleep(100);
//                        }
//                    }
//                }.start();
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


    // inner class 내부클래스
    class BackgroundThread extends Thread{
        SeekBar seekBar;
        int diff;

        public  BackgroundThread(SeekBar sbar, int diff){
            seekBar = sbar;
            this.diff = diff;
        }

        public void run(){
            for(int i=0; i<100; i++){
                seekBar.setProgress(seekBar.getProgress()+diff);
//                btnStart.setText("진행"+seekBar.getProgress());
                // 실행하면 죽어버림
                SystemClock.sleep(100);
            }
        }
    }

    class BackgroundTask extends AsyncTask<Integer, Integer, Integer>{
        // abstract, 추상클래스
        // 추상클래스: 적어도 하나 이상의 추상메소드
        SeekBar sb = sb1;
        int diff = 1;
        int value =0 ;

        public BackgroundTask() {
            super();
        }

        // polymorphism 다형성
        public BackgroundTask(SeekBar psb, int pdif){
            sb = psb;
            diff = pdif;
        }

        public BackgroundTask(SeekBar psb){
            sb = psb;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            value = 0;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            sb.setProgress(values[0].intValue());
        }


        @Override
        protected Integer doInBackground(Integer... integers) {
            for(int i=0; i<100; i++){
                value = value + diff;
                publishProgress(value);
                SystemClock.sleep(100);
            }
            return null;
        }
    }
}
