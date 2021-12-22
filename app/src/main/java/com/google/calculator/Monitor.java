package com.google.calculator;

import android.app.Activity;
import android.os.Build;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

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
                text.delete(editText.getSelectionStart(), editText.getSelectionStart()+1);
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
                            text.delete(editText.getSelectionStart(), editText.getSelectionStart()+1);
                        }
                    }
                });
                if(text.length()<2){
                    text.clear();
                    this.cancel();
                }
            }
        }, 150, 150);
    }

    public Editable append(View view,Button previousClicked){
        Editable content =editText.getText();
        int length=content.length();
        if(view==null){
            return content;
        }
        if(!view.getTag().equals("operator")){
            content.append(((Button)view).getText());

        }else if(length > 0 && previousClicked.getTag().equals("operator")){
            content.replace(length-1,length,((Button)view).getText());

        }else{
            content.append(((Button)view).getText());
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
