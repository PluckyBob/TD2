package com.example.td2;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.td2.data.model.DataItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.ViewHolder> {

    public static final String ITEM_KEY = "item_key";
    private final List<DataItem> mItems;
    private final Context mContext;

    public DataItemAdapter(Context context, List<DataItem> items) {
        this.mContext = context;
        this.mItems = items;
    }

    @Override
    public DataItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataItemAdapter.ViewHolder holder, int position) {
        final DataItem item = mItems.get(position);

        try {
            holder.tvName.setText(item.getItemName());
            String imageFile;

            imageFile = getImage(item.getLocation());
            InputStream inputStream = mContext.getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            holder.imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }

        holder.mView.setOnClickListener(v -> {
//               Toast.makeText(mContext, "You selected " + item.getItemName(), Toast.LENGTH_SHORT).show();
//            String itemID = item.getItemID();
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra(ITEM_KEY, item);
            mContext.startActivity(intent);
        });

        holder.mView.setOnLongClickListener(v -> {
            Toast.makeText(mContext, "You long clicked" + item.getItemName(), Toast.LENGTH_SHORT).show();
            return false;
        });
    }

    public static String getImage(int location) {
        switch (location) {
            case 1:
                return "home.jpg";
            case 2:
                return "work.jpg";
            case 3:
                return "unison.jpg";
            default:
                return "world.jpg";
        }

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView tvName;
        final ImageView imageView;

        final View mView;

        ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.itemNameText);
            imageView = itemView.findViewById(R.id.imageView);
            mView = itemView;
        }
    }
}