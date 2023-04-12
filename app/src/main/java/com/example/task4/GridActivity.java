package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(makeGridLayout());
    }

    private GridLayout makeGridLayout() {
        GridLayout gridLayout = new GridLayout(this);

        gridLayout.setRowCount(5);
        gridLayout.setColumnCount(5);

        for (int i = 1; i <= 3; i++) {
            Button button = new Button(this);
            button.setTextSize(getResources().getDimension(R.dimen.textSize));
            button.setText(Integer.toString(3 - i + 1));

            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(0), GridLayout.spec(3 - i));
            button.setLayoutParams(layoutParams);
            gridLayout.addView(button);
        }

        Button button4 = new Button(this);
        // вторая строка (1) и два столбца [0, 1]
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(1), GridLayout.spec(0, 2));
        layoutParams.width = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 180, getResources().getDisplayMetrics());
        button4.setTextSize(getResources().getDimension(R.dimen.textSize));
        button4.setText("4");
        gridLayout.addView(button4, layoutParams);

        Button button5 = new Button(this);
        GridLayout.LayoutParams layoutParams0 = new GridLayout.LayoutParams(GridLayout.spec(1, 2), GridLayout.spec(2));
        layoutParams0.height = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        button5.setTextSize(getResources().getDimension(R.dimen.textSize));
        button5.setText("5");
        gridLayout.addView(button5, layoutParams0);

        Button button6 = new Button(this);
        GridLayout.LayoutParams layoutParams1 = new GridLayout.LayoutParams(GridLayout.spec(2), GridLayout.spec(0));
        button6.setTextSize(getResources().getDimension(R.dimen.textSize));
        button6.setText("6");
        gridLayout.addView(button6, layoutParams1);

        Button button7 = new Button(this);
        GridLayout.LayoutParams layoutParams2 = new GridLayout.LayoutParams(GridLayout.spec(2), GridLayout.spec(1));
        button7.setTextSize(getResources().getDimension(R.dimen.textSize));
        button7.setText("7");
        gridLayout.addView(button7, layoutParams2);

        Button btn = new Button(this);
        GridLayout.LayoutParams layoutParams3 = new GridLayout.LayoutParams(GridLayout.spec(4), GridLayout.spec(0,3));
        layoutParams3.width = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics());
        btn.setText("Перейти к Include");
        btn.setOnClickListener(this::goToInclude);
        gridLayout.addView(btn, layoutParams3);
        return gridLayout;
    }

    public void goToInclude(View view) {
        Intent intent = new Intent(this, UsingInnerActivity.class);
        startActivity(intent);
    }
}