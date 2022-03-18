package com.berkayozisik.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnStart;
    Button btnStop;
    int sayac;
    Runnable runnable;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnStart = findViewById(R.id.button);
        btnStop = findViewById(R.id.button2);
        sayac = 0;


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnStart.setEnabled(false);
                handler = new Handler();

                runnable = new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("Time : " + sayac);
                        sayac++;
                        textView.setText("Time : " + sayac);
                        handler.postDelayed(runnable, 1000);       // her 1000ms de bu işlemi yap...
                    }
                };
                handler.post(runnable);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnStart.setEnabled(true);
                handler.removeCallbacks(runnable);
                sayac = 0;
                textView.setText("Time : " + sayac);
            }
        });

    }
}