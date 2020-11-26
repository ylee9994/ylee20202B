package com.ylee.a08openweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    TextView updates, country, location, temp, humidity, pressure;
    Button button;
    String weatherdata  = null;
    String forecastdata = null;
    String weatherurl = "https://api.openweathermap.org/data/2.5/weather?&mode=xml&units=metric&appid=3e0c533ec49a146af626992e6bcce23f";
    String forecasturl = "https://api.openweathermap.org/data/2.5/forecast?&mode=json&units=metric&appid=3e0c533ec49a146af626992e6bcce23f";
    String cityname = "seoul";
    String weatherurlfull = null;
    String forecasturlfull = null;

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
                cityname = editText.getText().toString();
                weatherurl +=  "&q=" + cityname;
                RequestTaskWeather requestTaskWeather =
                        new RequestTaskWeather();
                requestTaskWeather.execute();

                forecasturl += "&q=" + cityname;
                RequestTaskForecast requestTaskForecast =
                        new RequestTaskForecast();
                requestTaskForecast.execute();
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
            parseXMLopenweather(weatherdata);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            weatherdata = getHTTPdata(weatherurl);
            return null;
        }
    }

    class RequestTaskForecast extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected void onPreExecute() {
            textView.setText("AsyncTask 돌고있음");
        }

        @Override
        protected void onPostExecute(Integer integer) {
            // textView.setText(forecastdata);
            parseJSONforecast(forecastdata);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            forecastdata = getHTTPdata(forecasturl);
            return null;
        }
    }

    public void parseJSONforecast(String odata){
        Integer humidity;
        Double temperature;
        String presult = null;

        if(odata == null){
            textView.setText("데이터없음");
            return;
        }

        presult = "Forecast\n";
        try{
            JSONObject jsonObject = new JSONObject(odata);
            JSONArray jArray = jsonObject.getJSONArray("list");
            for(int i=0; i<jArray.length(); ++i){
                JSONObject jlist = jArray.getJSONObject(i);
                Long udate = jlist.getLong("dt");
                Date date = new Date(udate * 1000);
                SimpleDateFormat dateFormat =
                        new SimpleDateFormat("yyyy-MM-ddEHH:mm:ss");
                JSONObject jmain = jlist.getJSONObject("main");
                temperature = jmain.getDouble("temp");
                humidity = jmain.getInt("humidity");
                presult += dateFormat.format(date) +
                        " temperature = " + temperature + ", " +
                        "humidity = " + humidity + "\n";
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.e("JSONParsing", "Parsing Error");
        }
        textView.setText(presult);
    }

    public void parseXMLopenweather(String odata){
        if(odata == null) {
            updates.setText("디폴트: 오늘");
            country.setText("디폴트: 한국");
            location.setText("디폴트: 서울");
            temp.setText("디폴트: 쾌적");
            humidity.setText("디폴트: 좋음");
            pressure.setText("디폴트: 적당");
            textView.setText(odata);
        }
        String supdats=null, scountry=null, slocation=null, stemp = null;
        String shumidity = null, spressure = null;
        String presult = "XML:";

        try{
            String fxml;
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(odata));

            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_DOCUMENT){
                    presult += "Start of XML\n";
                }else if(eventType == XmlPullParser.START_TAG){
                    fxml = xpp.getName();

                    //<temperature value="20.3" min="20" max="21" unit="celsius"/>
                    if(fxml.equals("temperature")){
                        stemp = xpp.getAttributeValue(null, "value");
                    }
                    //"<humidity value=\"54\" unit=\"%\"/>\n" +
                    //"<pressure value=\"1023\" unit=\"hPa\"/>\n" +
                    else if(fxml.equals("humidity")){
                        shumidity = xpp.getAttributeValue(null, "value");
                    }else if(fxml.equals("pressure")){
                        spressure = xpp.getAttributeValue(null, "value");
                        String sunit = xpp.getAttributeValue(null, "unit");
                        spressure += " " + sunit;
                    }
                    // "<coord lon="126.98" lat="37.57"/>\n" +
                    else if(fxml.equals("coord")){
                        String slon = xpp.getAttributeValue(null, "lon");
                        String slat = xpp.getAttributeValue(null, "lat");
                        // 경도: 126.98, 위도: 37.57
                        slocation = "경도: " + slon + ", " + "위도: " + slat;
                    }
                    // <country>KR</country>
                    else if(fxml.equals("country")){
                        eventType = xpp.next();
                        if(eventType == XmlPullParser.TEXT){
                            scountry = xpp.getText();
                        }
                    }
                }
                eventType = xpp.next();
            }
        }catch (Exception e){
            Log.e("xml parsing", "Parsing error", e);
        }

        updates.setText(supdats);
        country.setText(scountry);
        location.setText(slocation);
        temp.setText(stemp);
        humidity.setText(shumidity);
        pressure.setText(spressure);

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
