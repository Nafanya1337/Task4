package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TableActivity extends AppCompatActivity {

    EditText email, subject, msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(makeTableLayout());
    }

    private TableLayout makeTableLayout() {
        var layout = new TableLayout(this);

        layout.setOrientation(LinearLayout.VERTICAL);

        var params = new TableRow.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 1.0f);

        TableRow tableRow = new TableRow(this);

        TextView emailText = new TextView(this);
        emailText.setText("Email: ");
        emailText.setLayoutParams(params);
        emailText.setTextSize(15);
        tableRow.addView(emailText);


        params = new TableRow.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 3.0f);
        email = new EditText(this);
        email.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        email.setLayoutParams(params);
        tableRow.addView(email);

        layout.addView(tableRow);


        tableRow = new TableRow(this);
        params = new TableRow.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 1.0f);
        emailText = new TextView(this);
        emailText.setText("Тема: ");
        emailText.setLayoutParams(params);
        emailText.setTextSize(15);
        tableRow.addView(emailText);


        params = new TableRow.LayoutParams(0, TableLayout.LayoutParams.MATCH_PARENT, 3.0f);
        subject = new EditText(this);
        subject.setLayoutParams(params);
        tableRow.addView(subject);

        layout.addView(tableRow);


        tableRow = new TableRow(this);

        params = new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, 500, 1.0f);
        msg = new EditText(this);
        msg.setHint("Содержание");
        msg.setGravity(Gravity.TOP | Gravity.LEFT);
        msg.setLayoutParams(params);
        msg.setWidth(TableRow.LayoutParams.FILL_PARENT);
        tableRow.addView(msg);
        layout.addView(tableRow);


        Button btn = new Button(this);
        btn.setText("Отправить");
        btn.setOnClickListener(this::setEmail);
        layout.addView(btn);

        btn = new Button(this);
        btn.setText("Перейти на FrameActivity");
        btn.setOnClickListener(this::goToFrameLayout);

        layout.addView(btn);

        return layout;
    }


    public void setEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String mail, sub, data;
        mail = email.getText().toString();
        sub = subject.getText().toString();
        data = msg.getText().toString();

        intent.setType("text/email");
        intent.putExtra(Intent.EXTRA_EMAIL, mail);
        intent.putExtra(Intent.EXTRA_SUBJECT, sub);
        intent.putExtra(Intent.EXTRA_TEXT, data);
        Intent chosen = Intent.createChooser(intent, "Отправить через");
        startActivity(chosen);
    }

    public void goToFrameLayout(View view) {
        Intent intent = new Intent(this, FrameActivity.class);
        startActivity(intent);
    }
}