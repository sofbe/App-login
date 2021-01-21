package com.example.project;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class MyField extends LinearLayout{
    private View view;
    private String label;
    private TextView textView;
    private DataManip dataManip;

    public MyField(Context context) {
        super(context);
        if (view != null) {
            init();
        }
    }

    public MyField(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (view != null) {
            init();
        }
    }

    public MyField(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyField(Context context, String label, View view, DataManip dataManip) {
        this(context);
        this.view = view;
        this.label = label;
        this.dataManip = dataManip;
        init();
    }

    /**
     * Creates a TextView with a given label next to the view and adds them both to the form.
     */
    public void init(){
        this.setOrientation(LinearLayout.VERTICAL);
        textView = new TextView(getContext());
        textView.setText(label);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        view.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        addView(view);
        addView(textView);
    }


    public DataManip getDataManip() {
        return dataManip;
    }

    public View getView() {
        return view;
    }


    /**
     * Sets color depending on if field is validated or not.
     * @param color (e.g. Color.BLACK)
     */
    public void setColor(int color){
        this.textView.setTextColor(color);
    }


}