package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    private MyForm myForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myForm = findViewById(R.id.myForm);
        defaultForm();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myForm.getData();
            }
        });
    }


    /**
     * Test form
     * Creates fields for username, email, password and checkbox.
     */
    public void defaultForm(){

        final View usernameV = new EditText(this);
        final MyField name = new MyField(this, "Username", usernameV, new DataManip() {
            @Override
            public boolean validate(View v) {
                if (((EditText)v).getText().length() > 6)
                    return true;
                else {
                    return false;
                }
            }
            @Override
            public String getValue(View v) {
                return ((EditText) usernameV).getText().toString();
            }
        });


        final PWStrengthMeter pwStrengthMeter = new PWStrengthMeter(this);
        pwStrengthMeter.setDataManip(new PasswordValidator());
        final MyField password = new MyField(this, "Password", pwStrengthMeter, new DataManip() {
            @Override
            public boolean validate(View v) {
                return pwStrengthMeter.isValid();
            }

            @Override
            public String getValue(View vv) {
                return pwStrengthMeter.getPassword();
            }
        });


        final EditText emailV = new EditText(this);
        emailV.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        MyField email = new MyField(this, "Email", emailV, new DataManip() {
            @Override
            public boolean validate(View v) {
                if (((EditText)v).getText().toString().contains("@") && ((EditText)v).getText().length() > 6){
                    return true;
                } else return false;
            }
            @Override
            public String getValue(View v) {
                return ((EditText) emailV).getText().toString();
            }
        });

        View checkBoxV = new CheckBox(this);
        MyField checkBox = new MyField(this, "Terms and Conditions", checkBoxV, new DataManip() {
            @Override
            public boolean validate(View v) {
                //insert isChecked();
                return true;
            }
            @Override
            public String getValue(View v) {
                return null;
            }
        });

        myForm.addField(name);
        myForm.addField(email);
        myForm.addField(password);
        myForm.addField(checkBox);
    }
}