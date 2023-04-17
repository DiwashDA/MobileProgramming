package com.example.blankactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button backButton;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        addListenerOnButton();
        Bundle data = getIntent().getExtras();
        System.out.println("================================");
        System.out.println(data.get("value"));
        System.out.println("================================");
        text.setText(data.get("value").toString());
    }


    public void addListenerOnButton() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("back pressed");
                Intent i = new Intent();
                i.putExtra("result", "testing");
                setResult(200, i);
                finish();
            }
        });
    }
}