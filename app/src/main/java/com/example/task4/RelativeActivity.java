package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RelativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(makeRelativeLayout());
    }

    private RelativeLayout makeRelativeLayout() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        TextView textView1 = new TextView(this);
        textView1.setText("Семья родственников раскидана по макету");
        textView1.setTextSize(getResources().getDimension(R.dimen.textSize));

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.dedushka);

        ImageView img2 = new ImageView(this);
        img2.setImageResource(R.drawable.babushka);

        ImageView img3 = new ImageView(this);
        img3.setId(View.generateViewId());
        img3.setImageResource(R.drawable.man);

        var params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        relativeLayout.addView(textView1, params);

        params = new RelativeLayout.LayoutParams(450, 450);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        relativeLayout.addView(img, params);

        params = new RelativeLayout.LayoutParams(450, 450);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        relativeLayout.addView(img2, params);

        params = new RelativeLayout.LayoutParams(450, 450);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        relativeLayout.addView(img3, params);

        params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        var btn = new Button(this);
        btn.setText("Перейти к TableLayout");
        btn.setOnClickListener(this::goToTableLayout);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        params.addRule(RelativeLayout.BELOW, img3.getId());
        relativeLayout.addView(btn, params);
        return relativeLayout;
    }

    public void goToTableLayout(View view) {
        Intent intent = new Intent(this, TableActivity.class);
        startActivity(intent);
    }
}