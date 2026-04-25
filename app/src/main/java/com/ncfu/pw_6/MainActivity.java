package com.ncfu.pw_6;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Lab6";
    private TextView tvFunction;
    private Button btnStart;

    private final double a = -2;
    private final double b = 3;
    private final double c = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFunction = findViewById(R.id.tvFunction);
        btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFunctionTimer();
            }
        });
    }

    private void startFunctionTimer() {
        new CountDownTimer(61000, 1000) {
            int x = -30;

            @Override
            public void onTick(long millisUntilFinished) {
                double f;

                if (a < 0 && c != 0) {
                    f = a * x * x + b * x + c;
                } else if (a > 0 && c == 0) {
                    f = -a / (x - c);
                } else {
                    f = a * (x + c);
                }

                String result = "x = " + x + ", F = " + f;
                tvFunction.setText(result);
                Log.i(TAG, result);

                x++;
            }

            @Override
            public void onFinish() {
                tvFunction.setText("Вычисления завершены");
                Log.i(TAG, "Вычисления завершены");
            }
        }.start();
    }
}