package com.ylee.a03http;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    String naverurl = "https://m.naver.com";
    String urlStr = "https://api.openweathermap.org/data/2.5/forecast?&APPID=3e0c533ec49a146af626992e6bcce23f&lat=36.1444292&lon=128.391079&mode=xml&units=metric&cnt=15";;
    String openweatherapi = "https://api.openweathermap.org/data/2.5/weather?&mode=json&units=metric&appid=3e0c533ec49a146af626992e6bcce23f&q=seoul";
    String busapi = "http://ws.bus.go.kr/api/rest/buspos/getBusPosByRtid?serviceKey=vJm8%2BGpTs1b6mG2%2FB%2Ff31iZqhHXyrrnEN8FjnIBUUwaD6fwqu1kY0dDpH4LBNbNVONA43%2Bt88%2BUWxFloMwKv6A%3D%3D&busRouteId=100100414";
    String airpollutionapi="http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=vJm8%2BGpTs1b6mG2%2FB%2Ff31iZqhHXyrrnEN8FjnIBUUwaD6fwqu1kY0dDpH4LBNbNVONA43%2Bt88%2BUWxFloMwKv6A%3D%3D&numOfRows=20&pageNo=1&sidoName=서울&ver=1.3";

    String htmldata = null;
    String sourceurl = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.urledit);
        button = findViewById(R.id.nbutton);
        textView = findViewById(R.id.textView);
        sourceurl = naverurl;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RequestThread rthread = new RequestThread();
////                rthread.start();
                RequestTask requestTask = new RequestTask();
                requestTask.execute();
                //SystemClock.sleep(5000);
                // textView.setText(htmldata);
            }
        });
    }

    class RequestTask extends AsyncTask<Integer, Integer, Integer>{
        @Override
        protected void onPreExecute() {
           textView.setText("AsyncTask 돌고있음");
        }

        @Override
        protected void onPostExecute(Integer integer) {
            textView.setText(htmldata);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            htmldata = getHTTPdata(sourceurl);
            return null;
        }
    }



    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            textView.setText((String) msg.obj);
        }
    };

    class RequestThread extends Thread{
        public void run(){
            htmldata = getHTTPdata(sourceurl);
            //textView.setText(htmldata);
            Message message = handler.obtainMessage();
            message.obj = htmldata;
            handler.sendMessage(message);
         }
    }

    public String getHTTPdata(String urlStrl){
        String rdata = null;
        try {
            URL url = new URL(urlStrl);
            HttpURLConnection conn = (HttpURLConnection)
                    url.openConnection();
            if(conn != null){
                conn.setConnectTimeout(10000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                int resCode = conn.getResponseCode();
                BufferedReader reader = new BufferedReader
                        (new InputStreamReader(conn.getInputStream()));
                String line;
                line = reader.readLine();
                rdata = line;
                while (true){
                    line = reader.readLine();
                    if(line == null){
                        break;
                    }
                    rdata += line;
                }
                reader.close();
                conn.disconnect();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return rdata;
    }
}
