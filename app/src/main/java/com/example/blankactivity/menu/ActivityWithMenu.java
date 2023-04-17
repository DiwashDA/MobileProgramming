package com.example.blankactivity.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.blankactivity.R;
import com.example.blankactivity.Settings;
import com.example.blankactivity.dialog.AlertDialogActivity;

public class ActivityWithMenu extends AppCompatActivity {
    Button button;
    Button button2;
    ListView listView;
    TextView textView;
    String[] data = {"data 1", "data 2", "data 3", "data 4", "data 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_menu);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        listView = findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.textview, R.id.textView, data);
        listView.setAdapter(arrayAdapter);

        registerForContextMenu(listView);
        button.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(ActivityWithMenu.this, button);
            popup.getMenuInflater().inflate(R.menu.options_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(item -> {
                Toast.makeText(ActivityWithMenu.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            });

            popup.show();//showing popup menu
        });
        button2.setOnClickListener(v -> {
            Intent i = new Intent(this, AlertDialogActivity.class);
            startActivity(i);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(), "Item 3 Selected", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, Settings.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Select The Action");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action1) {
            Toast.makeText(getApplicationContext(), "Action 1", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.action2) {
            Toast.makeText(getApplicationContext(), "Action 2", Toast.LENGTH_LONG).show();
        } else {
            return false;
        }
        return true;
    }
}