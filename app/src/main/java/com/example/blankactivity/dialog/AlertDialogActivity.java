package com.example.blankactivity.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.blankactivity.R;

public class AlertDialogActivity extends AppCompatActivity {

    Button alertButton;
    Button customDialogButton;
    AlertDialog.Builder builder;
    AlertDialog.Builder customBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        alertButton = findViewById(R.id.button);
        customDialogButton = findViewById(R.id.button2);
        alertDialogButton();
        customDialogButton();
    }

    void alertDialogButton() {
        builder = new AlertDialog.Builder(this);
        alertButton.setOnClickListener(v -> {

            builder.setMessage("Message").setTitle("Dialog Title");
            builder.setMessage("Do you want to go back ?")

                    .setPositiveButton("Yes", (dialog, id) -> {
                        finish();
                        Toast.makeText(getApplicationContext(), "you choose yes action for alertbox", Toast.LENGTH_SHORT).show();
                    }).setNegativeButton("No", (dialog, id) -> {
                        //  Action for 'NO' Button
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(), "you choose no action for alertbox", Toast.LENGTH_SHORT).show();
                    });
            AlertDialog alert = builder.create();
            alert.setTitle("Alert Dialog Example");
            alert.show();
        });
    }

    void customDialogButton() {
        customBuilder = new AlertDialog.Builder(this);
        customDialogButton.setOnClickListener(v -> {

            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.activity_main, null);
            customBuilder.setView(view);
            customBuilder.setCancelable(true);
            AlertDialog alert = customBuilder.create();
            alert.show();
        });
    }
}