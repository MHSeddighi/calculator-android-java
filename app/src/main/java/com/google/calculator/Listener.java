package com.google.calculator;

import android.app.Activity;
import android.text.Editable;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;

public class Listener implements View.OnClickListener{

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

    private Activity activity;
    private Monitor textDisplayer;

    public Listener(Activity activity) {
        this.activity=activity;
        init();
    }

    private void init() {
        clearAll=activity.findViewById(R.id.clear);
        multiple=activity.findViewById(R.id.btn_multiply);
        equal= (ImageButton) activity.findViewById(R.id.equal);
        minus=activity.findViewById(R.id.btn_minus);
        plus=activity.findViewById(R.id.btn_plus);
        backDelete=(ImageButton)activity.findViewById(R.id.back_delete);
        change=(ImageButton)activity.findViewById(R.id.change);
        dot=activity.findViewById(R.id.btn_dot);
        percent=activity.findViewById(R.id.btn_percent);
        divide=activity.findViewById(R.id.btn_divide);
        one=activity.findViewById(R.id.btn_1);
        two=activity.findViewById(R.id.btn_2);
        three=activity.findViewById(R.id.btn_3);
        four=activity.findViewById(R.id.btn_4);
        five=activity.findViewById(R.id.btn_5);
        six=activity.findViewById(R.id.btn_6);
        seven=activity.findViewById(R.id.btn_1);
        eight=activity.findViewById(R.id.btn_2);
        nine=activity.findViewById(R.id.btn_3);
        textDisplayer=new Monitor(activity);
    }

    @Override
    public void onClick(View v) {
        onClickEditButtons(v);
        if(v.get){

        }
    }

    private void onClickEditButtons(View view){
        Editable text =textDisplayer.getEditText().getText();
        switch (view.getId()){
            case R.id.clear:
                textDisplayer.delete(true);
                break;
            case R.id.equal:
                break;
            case R.id.change:
                break;
            case R.id.back_delete:
                textDisplayer.delete(false);
                break;
            default:
        }

    }

}
