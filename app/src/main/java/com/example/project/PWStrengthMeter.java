package com.example.project;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class PWStrengthMeter extends LinearLayout implements PasswordValidatorListener {

    private int grade;
    private EditText input;
    private TextView output;
    private MyLookOfPWSM myLookOfPWSM;
    private PasswordValidator passwordValidator;
    private String pw2;
    private ProgressBar progressBar;


    public PWStrengthMeter(Context context) {
        super(context);
        setUpUI();
    }

    public PWStrengthMeter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setUpUI();
    }

    public PWStrengthMeter(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUpUI();
    }

    /**
     * Reads from xml file and adds listener to the password field.
     */
    public void setUpUI() {
        View layout = LayoutInflater.from(getContext())
                .inflate(R.layout.password_validator, (ViewGroup) getParent());

        input = layout.findViewById(R.id.pwfield);
        output = layout.findViewById(R.id.pwgrad);
        progressBar = layout.findViewById(R.id.progressBar);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                grade = passwordValidator.validate(editable.toString());
                myLookOfPWSM = new MyLookOfPWSM(grade, output, progressBar);
            }
        });
        addView(layout);
    }

    /**
     * Sets validator to the Password Strength Meter.
     * @param passwordValidator Our default password validator. Can be changed and/or modified.
     */
    public void setDataManip(PasswordValidator passwordValidator) {
        this.passwordValidator = passwordValidator;
    }


    /**
     * @return the password as a String.
     */
    public String getPassword() {
        return input.getText().toString();
    }

    /**
     * Lets the user decide requirements for a valid password.
     * @return true if requirements are met.
     */
    @Override
    public boolean isValid() {
        if (grade >= 2) {
            return true;
        }
        else {return false;}
    }
}