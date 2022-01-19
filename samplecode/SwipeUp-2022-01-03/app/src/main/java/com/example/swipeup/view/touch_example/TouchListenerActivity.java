package com.example.swipeup.view.touch_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;

import com.example.swipeup.R;

// Reference GitHub : https://github.com/devunwired/custom-touch-examples

public class TouchListenerActivity extends AppCompatActivity  implements View.OnTouchListener {

    /* Views to display last seen touch event */
    CheckBox mLockBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_listener);

        mLockBox = (CheckBox) findViewById(R.id.checkbox_lock);

        findViewById(R.id.selection_first).setOnTouchListener(this);
        findViewById(R.id.selection_second).setOnTouchListener(this);
        findViewById(R.id.selection_third).setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        /*
         * Consume the events here so the buttons cannot process them
         * if the CheckBox in the UI is checked
         */
        return mLockBox.isChecked();
    }

    private String getNameForEvent(MotionEvent event) {
        String action = "";
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                break;
            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                break;
            default:
                return null;
        }

        return String.format("%s\n%.1f, %.1f", action, event.getX(), event.getY());
    }
}