package com.ylee.a01lifecycle;
// 2020 0903
// 교재 416쪽 액티비티생명주기

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.util.Log.i("LifeCyle", "OnCreate 호출됨");
        Button buttontel = findViewById(R.id.buttontel);
        buttontel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        Button buttonend = findViewById(R.id.buttonend);
        buttonend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeCyle", "OnStart 호출됨");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeCyle", "OnResume 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LifeCyle", "OnPause 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeCyle", "OnStop 호출됨");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LifeCyle", "OnRestart 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeCyle", "OnDestroy 호출됨");
    }
}
