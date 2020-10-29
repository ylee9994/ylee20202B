package com.ylee.a07json;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    String jsondata = "{\"coord\":{\"lon\":126.98,\"lat\":37.57},\"weather\":[{\"id\":721,\"main\":\"Haze\",\"description\":\"haze\",\"icon\":\"50d\"}],\"base\":\"stations\",\"main\":{\"temp\":299.78,\"pressure\":1023,\"humidity\":54,\"temp_min\":298.15,\"temp_max\":301.15},\"visibility\":10000,\"wind\":{\"speed\":2.1,\"deg\":330},\"clouds\":{\"all\":20},\"dt\":1569479121,\"sys\":{\"type\":1,\"id\":5509,\"message\":0.0062,\"country\":\"KR\",\"sunrise\":1569446551,\"sunset\":1569489888},\"timezone\":32400,\"id\":1835848,\"name\":\"Seoul\",\"cod\":200}";
    String jsonforecast="{\"cod\":\"200\",\"message\":0.0075,\"cnt\":15,\"list\":[{\"dt\":1569499200,\"main\":{\"temp\":22.63,\"temp_min\":22.55,\"temp_max\":22.63,\"pressure\":1024.27,\"sea_level\":1024.27,\"grnd_level\":1023.03,\"humidity\":76,\"temp_kf\":0.08},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":0.64,\"deg\":100.554},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-26 12:00:00\"},{\"dt\":1569510000,\"main\":{\"temp\":22.61,\"temp_min\":22.55,\"temp_max\":22.61,\"pressure\":1023.67,\"sea_level\":1023.67,\"grnd_level\":1022.25,\"humidity\":73,\"temp_kf\":0.06},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":1.57,\"deg\":115.31},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-26 15:00:00\"},{\"dt\":1569520800,\"main\":{\"temp\":22.28,\"temp_min\":22.24,\"temp_max\":22.28,\"pressure\":1023.76,\"sea_level\":1023.76,\"grnd_level\":1022.46,\"humidity\":61,\"temp_kf\":0.04},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.71,\"deg\":148.824},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-26 18:00:00\"},{\"dt\":1569531600,\"main\":{\"temp\":21.89,\"temp_min\":21.87,\"temp_max\":21.89,\"pressure\":1023.91,\"sea_level\":1023.91,\"grnd_level\":1022.58,\"humidity\":63,\"temp_kf\":0.02},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":2.95,\"deg\":155.161},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-26 21:00:00\"},{\"dt\":1569542400,\"main\":{\"temp\":21.71,\"temp_min\":21.71,\"temp_max\":21.71,\"pressure\":1023.89,\"sea_level\":1023.89,\"grnd_level\":1022.77,\"humidity\":64,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":1.65,\"deg\":114.008},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-27 00:00:00\"},{\"dt\":1569553200,\"main\":{\"temp\":22.45,\"temp_min\":22.45,\"temp_max\":22.45,\"pressure\":1022.84,\"sea_level\":1022.84,\"grnd_level\":1021.8,\"humidity\":65,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":0.38,\"deg\":215.362},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-27 03:00:00\"},{\"dt\":1569564000,\"main\":{\"temp\":22.23,\"temp_min\":22.23,\"temp_max\":22.23,\"pressure\":1021.1,\"sea_level\":1021.1,\"grnd_level\":1020.2,\"humidity\":67,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.38,\"deg\":292.324},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-27 06:00:00\"},{\"dt\":1569574800,\"main\":{\"temp\":22.79,\"temp_min\":22.79,\"temp_max\":22.79,\"pressure\":1020.9,\"sea_level\":1020.9,\"grnd_level\":1019.6,\"humidity\":70,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":2.08,\"deg\":308.487},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-27 09:00:00\"},{\"dt\":1569585600,\"main\":{\"temp\":22.18,\"temp_min\":22.18,\"temp_max\":22.18,\"pressure\":1021.35,\"sea_level\":1021.35,\"grnd_level\":1019.98,\"humidity\":70,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.37,\"deg\":318.502},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-27 12:00:00\"},{\"dt\":1569596400,\"main\":{\"temp\":21.92,\"temp_min\":21.92,\"temp_max\":21.92,\"pressure\":1020.61,\"sea_level\":1020.61,\"grnd_level\":1019.29,\"humidity\":68,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.81,\"deg\":316.445},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-27 15:00:00\"},{\"dt\":1569607200,\"main\":{\"temp\":21.75,\"temp_min\":21.75,\"temp_max\":21.75,\"pressure\":1020,\"sea_level\":1020,\"grnd_level\":1018.41,\"humidity\":66,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":2.73,\"deg\":349.958},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-27 18:00:00\"},{\"dt\":1569618000,\"main\":{\"temp\":21.32,\"temp_min\":21.32,\"temp_max\":21.32,\"pressure\":1020.16,\"sea_level\":1020.16,\"grnd_level\":1018.65,\"humidity\":66,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":86},\"wind\":{\"speed\":2.45,\"deg\":9.401},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2019-09-27 21:00:00\"},{\"dt\":1569628800,\"main\":{\"temp\":21.2,\"temp_min\":21.2,\"temp_max\":21.2,\"pressure\":1020.1,\"sea_level\":1020.1,\"grnd_level\":1018.99,\"humidity\":67,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":43},\"wind\":{\"speed\":1.76,\"deg\":17.321},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-28 00:00:00\"},{\"dt\":1569639600,\"main\":{\"temp\":22,\"temp_min\":22,\"temp_max\":22,\"pressure\":1019.45,\"sea_level\":1019.45,\"grnd_level\":1018.72,\"humidity\":64,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":2.48,\"deg\":269.285},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-28 03:00:00\"},{\"dt\":1569650400,\"main\":{\"temp\":22.21,\"temp_min\":22.21,\"temp_max\":22.21,\"pressure\":1017.02,\"sea_level\":1017.02,\"grnd_level\":1016.36,\"humidity\":69,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":4.54,\"deg\":278.114},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2019-09-28 06:00:00\"}],\"city\":{\"id\":1835848,\"name\":\"Seoul\",\"coord\":{\"lat\":37.5667,\"lon\":126.9783},\"country\":\"KR\",\"population\":10349312,\"timezone\":32400,\"sunrise\":1569446552,\"sunset\":1569489888}}";

    EditText editText;
    TextView textView;
    TextView updates, country, location, temp, humidity, pressure;
    Button button;

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
        setTitle("이용희json");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
