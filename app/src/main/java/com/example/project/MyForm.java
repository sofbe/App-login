package com.example.project;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MyForm extends LinearLayout {

    private ArrayList<MyField> myFieldList = new ArrayList<MyField>();
    private LinearLayout.LayoutParams layoutParams;
    private MyField myField;

    public MyForm(Context context) {
        super(context);
        init();
    }

    public MyForm(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyForm(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    /**
     * Setup layoutParams for fields.
     */
    public void init(){
        layoutParams = new LayoutParams(LayoutParams. MATCH_PARENT, LayoutParams. WRAP_CONTENT);
        this.setOrientation(LinearLayout.VERTICAL);

    }

    /**
     * Adds field to application and adds the field to a Arraylist of all fields in the form.
     * @param myField
     */
    public void addField(MyField myField){
        myField.setLayoutParams(layoutParams);
        this.addView(myField);
        myFieldList.add(myField);
    }

    /**
     * @return getValue() from all fields in the form.
     */

    public List<String> getData() {
        List<String> data = new ArrayList<String>();
        for (MyField f : myFieldList) {
            if (f.getDataManip().validate(f.getView())) {
                f.setColor(Color.BLACK);
                data.add(f.getDataManip().getValue(f.getView()));
            } else {
                f.setColor(Color.RED);
                data.add(null);
            }
        }
        System.out.println(data);
        return data;
    }

    /**
     * Lets the user add logic to a certain field.
     * @param myField Field that should be modified.
     */
    public void addLogic(MyField myField){

    }
}