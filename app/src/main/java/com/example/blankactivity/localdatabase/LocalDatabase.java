package com.example.blankactivity.localdatabase;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blankactivity.R;

public class LocalDatabase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_database);

        DatabaseHandler handler = new DatabaseHandler(this);

        handler.addData(1,"Diwash", "BKT");
        handler.addData(2,"Diwash1", "BKT1");
        handler.addData(3,"Diwash2", "BKT2");
        handler.addData(4,"Diwash3", "BKT3");

        handler.getAllData();

        handler.update();

        handler.getAllData();
        handler.delete();
        handler.getAllData();

        handler.getContact(3);

    }

}