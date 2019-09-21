package com.example.td2;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.td2.data.model.DataItem;
import com.example.td2.data.sample.DataFromCSV;
import com.example.td2.utils.JSONHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int SIGNIN_REQUEST = 1001;
    public static final String MY_GLOBAL_PREFS = "my_global_prefs";
    private static final int REQUEST_PERMISSION_WRITE = 1002;
    private static final String TAG = "TAG:MainActivity: ";
    private final List<DataItem> dataItemList = DataFromCSV.dataItemList;
    private boolean permissionGranted;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        for (DataItem item : dataItemList){
//            Log.i(TAG, "dataItemList item: "+ item.getItemName());
//        }
        setContentView(R.layout.activity_main);
        if (!permissionGranted) checkPermissions();

//        Collections.sort(dataItemList, new Comparator<DataItem>() {
//            public int compare(DataItem o1, DataItem o2) {
//                return o1.getItemName().compareTo(o2.getItemName());
//            }
//        });

        DataItemAdapter adapter = new DataItemAdapter(this, dataItemList);

        /*access preference status*/
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        Log.i(TAG,settings.getAll().toString());
        //                String weather = settings.getString(getString(R.string.weatherStatus), "SUNNY");
        //    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
        SharedPreferences.OnSharedPreferenceChangeListener prefsListener = (sharedPreferences, key) -> {
            Log.i(TAG, "prefs listener detected onSharedPreferenceChange " + key);
//                String weather = settings.getString(getString(R.string.weatherStatus), "SUNNY");
        };
        settings.registerOnSharedPreferenceChangeListener(prefsListener);

        RecyclerView recyclerView = findViewById(R.id.rvItems);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_signin:
                Intent intent = new Intent(this, SigninActivity.class);
                startActivityForResult(intent, SIGNIN_REQUEST);
                return true;
            case R.id.action_settings:
                // Show the status screen
                Intent SettingsIntent = new Intent(this, StatusActivity.class);
                startActivity(SettingsIntent);
                return true;
            case R.id.action_export:
                boolean result = JSONHelper.exportToJSON(this, dataItemList);
                if (result) {
                    Toast.makeText(this, "Data Exported", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Export failed", Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.action_import:
                List<DataItem> dataItems = JSONHelper.importFromJSON(this);
                if (dataItems != null) {
                    for (DataItem dataitem :
                            dataItems) {
                        Log.i(TAG, "onOptionsItemSelected: " + dataitem.getItemName());
                    }
                } else {
                    Log.i(TAG, "No data items to display!");
                }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == SIGNIN_REQUEST) {
            String email = data.getStringExtra(SigninActivity.EMAIL_KEY);
            Toast.makeText(this, "You signed in as " + email, Toast.LENGTH_SHORT).show();

            SharedPreferences.Editor editor =
                    getSharedPreferences(MY_GLOBAL_PREFS, MODE_PRIVATE).edit();
            editor.putString(SigninActivity.EMAIL_KEY, email);
            editor.apply();

        }
    }

    /* Checks if external storage is available for read and write */
    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /* Checks if external storage is available to at least read */
    private boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
    }

    // Initiate request for permissions.
    private void checkPermissions() {
        if (!isExternalStorageReadable() || !isExternalStorageWritable()) {
            Toast.makeText(this, "This app only works on devices with usable external storage",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION_WRITE);
        } else {
        }
    }

    // Handle permissions result
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION_WRITE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permissionGranted = true;
                Toast.makeText(this, "External storage permission granted",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "You must grant permission!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
