package com.google.calculator;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Monitor {
    private Activity activity;
    private ConstraintLayout layout;
    private EditText editText;
    private TextView textView;


    public Monitor() {
        init();
    }

    private void init() {
        layout=activity.findViewById();
    }

    public void removeEditorText(boolean deleteAll){
        CharSequence text= editText.getText();
        if(text==null) {
            return;
        }else if(deleteAll){
            editText.setText("");
        }else{
            editText.setText(text.subSequence(0,text.length()-1));
        }
    }
}
