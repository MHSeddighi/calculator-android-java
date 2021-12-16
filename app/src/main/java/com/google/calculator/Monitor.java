package com.google.calculator;

import android.app.Activity;
import android.os.Build;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Monitor{
    private Activity activity;
    private EditText editText;
    private TextView textView;


    public Monitor(Activity activity) {
        this.activity=activity;
        init();
    }

    private void init() {
        editText=activity.findViewById(R.id.editText);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            editText.setShowSoftInputOnFocus(false);
        }
        textView=activity.findViewById(R.id.textView);

    }

    public void delete(boolean deleteAll,boolean fastDelete){
        int length=editText.getText().length();
        Editable text =editText.getText();
        if(length!=0) {
            if (deleteAll) {
                text.clear();
            } else if(fastDelete){
                fastDelete();
            }else{
                text.delete(length - 1, length);
            }
        }
    }

    private void fastDelete(){
        Editable text =editText.getText();
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(text.length()!=0){
                            text.delete(text.length() - 1, text.length());
                        }
                    }
                });
                if(text.length()==0){
                    this.cancel();
                }
            }
        }, 0, 200);
    }

    public Editable append(CharSequence ch){
        return editText.getText().append(ch);
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(CharSequence text) {
        if(text!=null)
            editText.setText(text);
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(String text) {
        textView.setText(text);
    }

    private void textScanner() {

    }
}
