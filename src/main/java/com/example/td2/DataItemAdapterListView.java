package com.example.td2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.td2.data.model.DataItem;

import java.util.List;

class DataItemAdapterListView extends ArrayAdapter<DataItem> {

    private final List<DataItem> mDataItems;
    private final LayoutInflater mInflater;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView=mInflater.inflate(R.layout.list_item, parent, false);
        }

        TextView tvName = convertView.findViewById(R.id.itemNameText);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        DataItem item = mDataItems.get(position);
        tvName.setText(item.getItemName());
        imageView.setImageResource(R.drawable.world);

        return convertView;


    }
}
