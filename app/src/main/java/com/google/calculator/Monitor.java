package com.google.calculator;

import android.app.Activity;
import android.os.Build;
import android.widget.EditText;
import android.widget.TextView;

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

    private void removeEditorText(boolean deleteAll){
        CharSequence text= editText.getText();
        if(text==null) {
            return;
        }else if(deleteAll){
            editText.setText("");
        }else{
            editText.setText(text.subSequence(0,text.length()-1));
        }
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    private void textScanner(){

    }

}
