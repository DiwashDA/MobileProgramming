package com.example.blankactivity.localdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.blankactivity.R;

public class LocalDatabase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_database);

        DatabaseHandler handler =new  DatabaseHandler(this);

    }

}