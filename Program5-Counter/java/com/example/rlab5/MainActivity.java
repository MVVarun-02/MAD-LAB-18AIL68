package com.example.rlab5;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bstart, bstop;
    TextView ct;
    public Boolean r = false;
    public int c = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bstart = (Button) findViewById(R.id.btn_start);
        bstart.setOnClickListener(this);
        bstop = (Button) findViewById(R.id.btn_stop);
        bstop.setOnClickListener(this);
        ct = (TextView) findViewById(R.id.textView4);
    }
    @Override
    public void onClick(View view) {
        if (view.equals(bstart)) {
            counterStart();
        } else if (view.equals(bstop)) {
            counterStop();
        }
    }
    private void counterStop() {
        this.r = false;
        bstart.setSaveEnabled(true);
        bstop.setEnabled(false);
    }
    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            ct.setText(String.valueOf(msg.what));
        }
    };
    private void counterStart() {
        this.r = true;
        new Mycounter().start();
        bstart.setSaveEnabled(false);
        bstop.setEnabled(true);
    }
    private class Mycounter extends Thread {
        public void run() {
            while (r) {
                c++;
                handler.sendEmptyMessage(c);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}