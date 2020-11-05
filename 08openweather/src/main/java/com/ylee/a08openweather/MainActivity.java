package com.ylee.a08openweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
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
    TextView textView;
    TextView updates, country, location, temp, humidity, pressure;
    Button button;
    String weatherdata  = null;
    String weatherurl = "https://api.openweathermap.org/data/2.5/weather?&mode=xml&units=metric&q=seoul&appid=3e0c533ec49a146af626992e6bcce23f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        updates = findViewById(R.id.updates);
        country = findViewById(R.id.country);
        location = findViewById(R.id.location);
        temp = findViewById(R.id.temp);
        humidity = findViewById(R.id.humidity);
        pressure = findViewById(R.id.pressure);
        button = findViewById(R.id.button);
        setTitle("이용희openweather");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestTaskWeather requestTaskWeather =
                        new RequestTaskWeather();
                requestTaskWeather.execute();
            }
        });
    }

    class RequestTaskWeather extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected void onPreExecute() {
            textView.setText("AsyncTask 돌고있음");
        }

        @Override
        protected void onPostExecute(Integer integer) {
            textView.setText(weatherdata);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            weatherdata = getHTTPdata(weatherurl);
            return null;
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
