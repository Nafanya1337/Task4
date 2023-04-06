package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(makeLinearLayout());
    }


    private LinearLayout makeLinearLayout() {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
        );
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // Создаем текстовые представления
        TextView textView1 = new TextView(this);
        TextView textView2 = new TextView(this);
        TextView textView3 = new TextView(this);

        // Установим атрибуты текстовых представлений

        // Установим текст
        textView1.setText(R.string.str1);
        textView2.setText(R.string.str2);
        textView3.setText(R.string.str3);

        // Установим размер текста
        textView1.setTextSize(20);
        textView2.setTextSize(20);
        textView3.setTextSize(20);

        // Установим цвет заднего фона
        textView1.setBackgroundColor(getColor("#a0a0a0"));
        textView2.setBackgroundColor(getColor("#673AB7"));
        textView3.setBackgroundColor(getColor("#FF9800"));


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0);

        // Установим вес строк
        params.weight = 1.0f;
        params.gravity = Gravity.RIGHT;
        textView1.setLayoutParams(params);

        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0);

        params.weight = 2.0f;
        params.gravity = Gravity.CENTER;
        textView2.setLayoutParams(params);

        params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 0);

        params.weight = 1.0f;
        params.gravity = Gravity.LEFT;
        textView3.setLayoutParams(params);

        // Добавляем представления в макет
        linearLayout.addView(textView1);
        linearLayout.addView(textView2);
        linearLayout.addView(textView3);

        Button btn = new Button(this);
        btn.setText("Перейти к RelativeLayout");
        btn.setOnClickListener(this::goToRelative);
        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.RIGHT;
        btn.setLayoutParams(params);
        linearLayout.addView(btn);

        return linearLayout;
    }

    public void goToRelative(View view) {
        Intent intent = new Intent(this, RelativeActivity.class);
        startActivity(intent);
    }

    private static int getColor(String color) {
        return Color.parseColor(color);
    }
}