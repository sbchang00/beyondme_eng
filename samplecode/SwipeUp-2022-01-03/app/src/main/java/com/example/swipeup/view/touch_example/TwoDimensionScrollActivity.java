package com.example.swipeup.view.touch_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.swipeup.R;


// Reference GitHub : https://github.com/devunwired/custom-touch-examples

public class TwoDimensionScrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwoDimensionScrollView scrollView = new TwoDimensionScrollView(this);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        for(int i=0; i < 5; i++) {
            ImageButton iv = new ImageButton(this);
            iv.setImageResource(R.mipmap.ic_launcher);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            int width = getResources().getDimensionPixelSize(R.dimen.pan_content_width);
            int height = getResources().getDimensionPixelSize(R.dimen.pan_content_height);
            layout.addView(iv, new LinearLayout.LayoutParams(width, height));
        }

        scrollView.addView(layout);
        setContentView(scrollView);
    }
}