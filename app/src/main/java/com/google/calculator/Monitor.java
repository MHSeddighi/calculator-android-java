package com.google.calculator;

import android.app.Activity;
import android.os.Build;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class Monitor {

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
                        if(text.length()>1){
                            text.delete(text.length() - 2, text.length());
                        }
                    }
                });
                if(text.length()<2){
                    this.cancel();
                }
            }
        }, 150, 150);
    }

    public Editable append(CharSequence text, HashMap<String, Button> operatorButtons){
        Editable content =editText.getText();
        int length=content.length();
        if(text==null){
            return content;
        }
        if(operatorButtons.get(text)==null){
            content.append(text);
        }else if(content.charAt(length-1)==text.charAt(0) && length > 0){
            content.replace(length-1,length,text);
        }else{
            content.append(text);
        }
        return content;
    }

    public void setEditText(CharSequence text) {
        if(text!=null)
            editText.setText(text);
    }

    public void setTextView(String text) {
        textView.setText(text);
    }

    private boolean textScanner() {
        String text=editText.getText().toString();
        return text.matches("");
    }
}
