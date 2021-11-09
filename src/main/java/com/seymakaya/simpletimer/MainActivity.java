package com.seymakaya.simpletimer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;
import android.view.View;
// Seyma Kaya

public class MainActivity extends AppCompatActivity {

    TextView textView,textView2;
    int number;
    Runnable runnable;
    Handler handler;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView2=findViewById(R.id.textView2);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        number = 0;
    }

    public void start (View view) {

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: " + number);
                number++;
                textView.setText("Time: " + number +" sn");
                handler.postDelayed(runnable,1000);

            }
        };

        handler.post(runnable);
        button.setEnabled(false);

    }

    public void stop (View view) {
        button.setEnabled(true);

        handler.removeCallbacks(runnable);
        textView2.setText("Result: " + number+ " sn");
        number = 0;
        textView.setText("Time: " + number);

    }
}