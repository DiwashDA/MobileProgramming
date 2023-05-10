package com.example.blankactivity.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.blankactivity.R;

import java.util.List;

public class GridAdapter extends ArrayAdapter<Items> {

    List<Items> items_list;
    int custom_layout_id;

    public GridAdapter(@NonNull Context context, int resource, @NonNull List<Items> objects) {
        super(context, resource, objects);
        items_list = objects;
        custom_layout_id = resource;
    }

    @Override public int getCount() {
        return items_list.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            // getting reference to the main layout and initializing
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(custom_layout_id, null);
        }

        // initializing the imageview and textview and setting data
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView textView = v.findViewById(R.id.textView);

        // get the item using the position param
        Items item = items_list.get(position);

        imageView.setImageResource(R.drawable.ic_launcher_foreground);
        textView.setText(item.getText());
        return v;
    }
}

