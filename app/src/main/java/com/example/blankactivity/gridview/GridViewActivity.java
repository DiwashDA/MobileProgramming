package com.example.blankactivity.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.blankactivity.R;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        List<Items> itemsList = new ArrayList<>();
        itemsList.add(new Items(R.drawable.ic_launcher_foreground, "image_1"));
        itemsList.add(new Items(R.drawable.ic_launcher_foreground, "image_2"));
        itemsList.add(new Items(R.drawable.ic_launcher_foreground, "image_3"));
        itemsList.add(new Items(R.drawable.ic_launcher_foreground, "image_4"));
        itemsList.add(new Items(R.drawable.ic_launcher_foreground, "image_5"));
        itemsList.add(new Items(R.drawable.ic_launcher_foreground, "image_6"));
        itemsList.add(new Items(R.drawable.ic_launcher_foreground, "image_7"));
        itemsList.add(new Items(R.drawable.ic_launcher_foreground, "image_8"));
        itemsList.add(new Items(R.drawable.ic_launcher_foreground, "image_9"));
        itemsList.add(new Items(R.drawable.ic_launcher_foreground, "image_10"));

        GridView gridView = findViewById(R.id.grid_view);
        GridAdapter customAdapter = new GridAdapter(this, R.layout.activity_grid_view, itemsList);
        gridView.setAdapter(customAdapter);
    }
}