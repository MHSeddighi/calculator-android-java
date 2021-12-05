package com.google.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText textEditor;
    private Button clearAll;
    private ImageButton backDelete;
    private Button percent;
    private Button minus;
    private Button plus;
    private ImageButton equal;
    private Button dot;
    private ImageButton change;
    private Button multiple;
    private Button divide;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button six;
    private Button five;
    private Button four;
    private Button three;
    private Button two;
    private Button one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        textEditor=findViewById(R.id.input_number);
        clearAll=findViewById(R.id.btn_0_0);
        multiple=findViewById(R.id.btn_1_3);
        equal= (ImageButton) findViewById(R.id.btn_4_3);
        minus=findViewById(R.id.btn_2_3);
        plus=findViewById(R.id.btn_3_3);
        backDelete=(ImageButton)findViewById(R.id.btn_0_1);
        change=(ImageButton)findViewById(R.id.btn_4_0);
        dot=findViewById(R.id.btn_4_2);
        percent=findViewById(R.id.btn_0_2);
        divide=findViewById(R.id.btn_0_3);
        one=findViewById(R.id.btn_3_0);
        two=findViewById(R.id.btn_3_1);
        three=findViewById(R.id.btn_3_2);
        four=findViewById(R.id.btn_2_0);
        five=findViewById(R.id.btn_2_1);
        six=findViewById(R.id.btn_2_2);
        seven=findViewById(R.id.btn_3_0);
        eight=findViewById(R.id.btn_3_1);
        nine=findViewById(R.id.btn_3_2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Second Activity").setOnMenuItemClickListener(item->{
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
            return true;
        });
        return true;
    }

    public void onClickNumbers(View v) {
        Button btn = (Button)v;
        if(btn!=null){
            textEditor.append(btn.getText());
        }
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_0_0:break;
        }
    }
}