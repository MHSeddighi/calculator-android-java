package com.google.calculator;

import android.app.Activity;
import android.os.Build;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

    public void delete(boolean deleteAll){
        int length=editText.getText().length();
        Editable text =editText.getText();
        if(text==null) {
            return;
        }
        if(text.length()!=0) {
            if (deleteAll) {
                text.clear();
            } else {
                text.delete(length - 1, length);
            }
        }
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
