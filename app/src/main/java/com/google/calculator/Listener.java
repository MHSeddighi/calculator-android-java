package com.google.calculator;

import android.app.Activity;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;

import java.util.HashMap;

public class Listener implements View.OnClickListener, View.OnLongClickListener {

    private HashMap<Character,Button> operatorButtons;

    private Button clear;
    private ImageButton backDelete;
    private Button equal;
    private ImageButton change;

    private Button[] numberButtons;

    private Activity activity;
    private Monitor monitor;

    private Button currentClickedButton;
    private Button previousClickedButton;

    public Listener(Activity activity) {
        this.activity=activity;
        monitor=new Monitor(activity);
        numberButtons=new Button[9];
        operatorButtons=new HashMap<Character, Button>();
        init();
    }

    private void init() {
        clear = activity.findViewById(R.id.clear);
        equal = activity.findViewById(R.id.equal);
        backDelete=(ImageButton)activity.findViewById(R.id.back_delete);
        change=(ImageButton)activity.findViewById(R.id.change);

        operatorButtons.put('×',activity.findViewById(R.id.btn_multiple));
        operatorButtons.put('-',activity.findViewById(R.id.btn_minus));
        operatorButtons.put('+',activity.findViewById(R.id.btn_plus));
        operatorButtons.put('.',activity.findViewById(R.id.btn_dot));
        operatorButtons.put('%',activity.findViewById(R.id.btn_percent));
        operatorButtons.put('÷',activity.findViewById(R.id.btn_divide));

        numberButtons[0]=activity.findViewById(R.id.btn_1);
        numberButtons[1]=activity.findViewById(R.id.btn_2);
        numberButtons[2]=activity.findViewById(R.id.btn_3);
        numberButtons[3]=activity.findViewById(R.id.btn_4);
        numberButtons[4]=activity.findViewById(R.id.btn_5);
        numberButtons[5]=activity.findViewById(R.id.btn_6);
        numberButtons[6]=activity.findViewById(R.id.btn_7);
        numberButtons[7]=activity.findViewById(R.id.btn_8);
        numberButtons[8]=activity.findViewById(R.id.btn_9);

        setListeners();
    }

    private void setListeners(){
        clear.setOnClickListener(this);
        change.setOnClickListener(this);
        equal.setOnClickListener(this);
        backDelete.setOnClickListener(this);
        backDelete.setOnLongClickListener(this);

        for (Button btn : numberButtons) {
            btn.setOnClickListener(this);
        }
        for (Button btn:operatorButtons.values()){
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        previousClickedButton = currentClickedButton;
        if(v instanceof ImageButton){
            currentClickedButton = null;
        }else{
            currentClickedButton = (Button)v;
        }

        boolean isActionButton=onActionEditButtons(v);
        if(isActionButton){
            return;
        }

        monitor.append(v,previousClickedButton);

    }

    private boolean onActionEditButtons(View view){
        switch (view.getId()){
            case R.id.clear:
                monitor.delete(true,false);
                return true;
            case R.id.equal:
                return true;
            case R.id.change:
                return true;
            case R.id.back_delete:
                monitor.delete(false,false);
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getId()==backDelete.getId()){
            monitor.delete(false,true);
        }
        return false;
    }
}
