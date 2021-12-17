package com.google.calculator;

import android.app.Activity;
import android.text.Editable;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;

import java.util.HashMap;

public class Listener implements View.OnClickListener, View.OnLongClickListener {

    private HashMap<String,Button> operatorButtons;

    private Button clear;
    private ImageButton backDelete;
    private ImageButton equal;
    private ImageButton change;

    private Button[] numberButtons;

    private Activity activity;
    private Monitor textDisplayer;

    public Listener(Activity activity) {
        this.activity=activity;
        numberButtons=new Button[9];
        textDisplayer=new Monitor(activity);
        operatorButtons=new HashMap<String, Button>();
        init();
    }

    private void init() {
        clear =activity.findViewById(R.id.clear);
        equal= (ImageButton) activity.findViewById(R.id.equal);
        backDelete=(ImageButton)activity.findViewById(R.id.back_delete);
        change=(ImageButton)activity.findViewById(R.id.change);

        operatorButtons.put("multiple",activity.findViewById(R.id.btn_multiple));
        operatorButtons.put("minus",activity.findViewById(R.id.btn_minus));
        operatorButtons.put("plus",activity.findViewById(R.id.btn_plus));
        operatorButtons.put("dot",activity.findViewById(R.id.btn_dot));
        operatorButtons.put("percent",activity.findViewById(R.id.btn_percent));
        operatorButtons.put("divide",activity.findViewById(R.id.btn_divide));

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
        boolean isFinded=onClickEditButtons(v);
        if(isFinded){
            return;
        }
        Button button=(Button)v;
        if(button!=null)
            textDisplayer.append(button.getText(),operatorButtons);
    }

    private boolean onClickEditButtons(View view){
        switch (view.getId()){
            case R.id.clear:
                textDisplayer.delete(true,false);
                return true;
            case R.id.equal:
                return true;
            case R.id.change:
                return true;
            case R.id.back_delete:
                textDisplayer.delete(false,false);
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getId()==backDelete.getId()){
            textDisplayer.delete(false,true);
        }
        return false;
    }
}
