package com.google.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity{

    private  Monitor monitor;
    private  Listener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monitor=new Monitor(this);
        listener=new Listener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Second Activity").setOnMenuItemClickListener(item->{
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
            return true;
        });
        return true;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Listener getListener() {
        return listener;
    }
}