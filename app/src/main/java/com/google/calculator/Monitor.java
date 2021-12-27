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
        editText.setSelection(0);

    }

    public void delete(boolean deleteAll,boolean fastDelete){

        int length         = editText.getText().length();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd   = editText.getSelectionEnd();

        Editable text =editText.getText();

        if(length > 0) {
            if (deleteAll) {
                text.clear();
            } else if(fastDelete){
                fastDelete();
            }else if(selectionStart > 1){
                text.delete(selectionStart-1, selectionEnd);
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
                        if(text.length()>1 && editText.getSelectionStart()>1 ){
                            text.delete(editText.getSelectionStart()-2, editText.getSelectionEnd());
                        }
                    }
                });
                if(text.length()<2){
                    text.clear();
                    this.cancel();
                }
            }
        }, 50, 80);
    }

    public Editable append(View view,Button previousClicked){
        Editable content =editText.getText();
        int length=content.length();

        int selectionStart=editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();

        if(view==null && previousClicked==null){
            return content;
        }

        if(!view.getTag().equals("operator")){
            content.append(((Button)view).getText(),selectionStart,selectionEnd);

        }else if(length > 0 && previousClicked.getTag().equals("operator")){
            content.replace(length-1,length,((Button)view).getText());

        }else{
            content.append(((Button)view).getText(),selectionStart,selectionEnd);
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
