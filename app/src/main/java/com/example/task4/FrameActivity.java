package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class FrameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(makeFrameLayout());
    }

    private FrameLayout makeFrameLayout() {
        FrameLayout frameLayout = new FrameLayout(this);
        TextView textView1 = new TextView(this);
        textView1.setText("FrameLayout применен для создания ScrollView");
        textView1.setTextSize(getResources().getDimension(R.dimen.textSize));
        textView1.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER | Gravity.TOP));
        frameLayout.addView(textView1);


        ScrollView scrollView = new ScrollView(this);
        ScrollView.LayoutParams layoutParams = new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 550, Gravity.CENTER);
        layoutParams.gravity = Gravity.CENTER;

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        scrollView.setLayoutParams(layoutParams);


        for (int i = 0; i < 20; i++) {
            ImageView img = new ImageView(this);
            if (i % 3 == 0) {
                img.setImageResource(R.drawable.dedushka);
            } else if (i % 3 == 1) {
                img.setImageResource(R.drawable.babushka);
            } else {
                img.setImageResource(R.drawable.man);
            }
            img.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
            linearLayout.addView(img);
        }

        Button btn = new Button(this);
        btn.setText("Перейти к Grid");
        btn.setOnClickListener(this::goToGrid);
        linearLayout.addView(btn);
        scrollView.addView(linearLayout);

        frameLayout.addView(scrollView);
        return frameLayout;
    }

    public void goToGrid(View view) {
        Intent intent = new Intent(this, GridActivity.class);
        startActivity(intent);
    }
}