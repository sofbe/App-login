package com.example.project;

import android.content.Context;
import android.graphics.Color;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyLookOfPWSM {

    private TextView output;
    int grade;
    private ProgressBar progressBar;


    public MyLookOfPWSM(int grade, TextView output, ProgressBar progressBar) {
        this.grade = grade;
        this.output = output;
        this.progressBar = progressBar;
        validate(grade);
    }

    /**
     * Decides text and color for progressbar.
     * Fills up the progressbar depending on the grade.
     * @param grade Return statement from password algorithm.
     */
    public void validate(int grade){
        switch(grade) {
            case 4:
                setText("Strong", "#75F74C");
                break;
            case 3:
                setText("Good", "#1951F7");
                break;
            case 2:
                setText("Fair", "#F742D2");
                break;
            case 1:
                setText("Minimum 8 characters", "#F70000");
                break;
        }
        progressBar.setProgress(grade);
    }

    /**
     * Sets text and color for the progressbar/message.
     * @param text Output message.
     * @param color Output color.
     */
    public void setText(String text, String color){
        output.setTextColor(Color.parseColor(color));
        output.setText(text);
        progressBar.getProgressDrawable().setColorFilter(
                Color.parseColor(color), android.graphics.PorterDuff.Mode.SRC_IN);
    }
}