package com.example.td2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.td2.data.model.DataItem;

import java.io.IOException;
import java.io.InputStream;

@SuppressWarnings("FieldCanBeLocal")
public class DetailActivity extends AppCompatActivity {

    //text values
    private TextView tvName, tvDescription, tvRecycle;
    //Time values as strings
    private TextView tvDuration, tvAfter, tvDeadline;
    //Numeric values as strings
    private TextView tvSubjective, tvBenefit, tvDaysICanDoIt, tvConsequences;
    private TextView tvLocation, tvWeather, tvEarliest;
    private TextView tvLatest, tvPeople, tvWorkLoadAnalysis;

    private ImageView itemImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DataItem item = getIntent().getExtras().getParcelable(DataItemAdapter.ITEM_KEY);
        if (item == null) {
            throw new AssertionError("Null data item received!");
        }

        tvName = findViewById(R.id.tvItemName);
        tvDescription = findViewById(R.id.tvDescription);
        tvDuration = findViewById(R.id.tvDuration);
        tvAfter = findViewById(R.id.tvAfter);
        tvDeadline = findViewById(R.id.tvDeadline);
        tvRecycle = findViewById(R.id.tvRecycle);
        tvSubjective = findViewById(R.id.tvSubjective);
        tvBenefit = findViewById(R.id.tvBenefit);
        tvConsequences = findViewById(R.id.tvConsequences);
        tvDaysICanDoIt = findViewById(R.id.tvDaysICanDoIt);
        tvLocation = findViewById(R.id.tvLocation);
        tvWeather = findViewById(R.id.tvWeather);
        tvEarliest = findViewById(R.id.tvEarliest);
        tvLatest = findViewById(R.id.tvLatest);
        tvPeople = findViewById(R.id.tvPeople);
        tvWorkLoadAnalysis = findViewById(R.id.tvWorkLoadAnalysis);
        itemImage = findViewById(R.id.itemImage);

        //NOW SET THE VALUES
        tvName.setText(item.getItemName());
        tvDescription.setText(item.getDescription());
        tvDuration.setText(item.getDuration());
        tvAfter.setText(item.getAfter());
        tvDeadline.setText(item.getDuration());
        tvRecycle.setText(item.getRecycles());
        tvSubjective.setText(String.valueOf(item.getSubjectivePriority()));
        tvBenefit.setText(String.valueOf(item.getBenefit()));
        tvConsequences.setText(String.valueOf(item.getConsequence()));
        tvDaysICanDoIt.setText(item.getDaysICanDoIt());
        tvLocation.setText(String.valueOf(item.getLocation()));
        tvWeather.setText(String.valueOf(item.getWeather()));
        tvEarliest.setText(item.getEarliestTimeOfDay());
        tvLatest.setText(item.getLatestTimeOfDay());
        tvWorkLoadAnalysis.setText(String.valueOf(item.getWorkLoadAnalysis()));

        InputStream inputStream = null;
        try {
            String imageFile = DataItemAdapter.getImage(item.getLocation());
            inputStream = getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            itemImage.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}