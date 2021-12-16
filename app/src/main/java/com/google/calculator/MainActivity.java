package com.google.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Listener listener=new Listener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Second Activity").setOnMenuItemClickListener(item->{
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
            return true;
        });
        return true;
    }

//    public void onClickNumbers(View v) {
//        Button btn = (Button)v;
//        if(btn!=null){
//        }
//    }


//    @Override
//    public void onClick(View view) {
//        switch(view.getId()){
//            case R.id.btn_0_0:
//                removeEditorText(true);
//                break;
//            case R.id.btn_0_1:
//                removeEditorText(false);
//                break;
//            default:break;
//        }
//    }


}