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
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.td2.data.database.DataSource;
import com.example.td2.data.model.DataItem;
import com.example.td2.data.sample.DataFromTDF;
import com.example.td2.utils.JSONHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG:MainActivity: ";
    private static final int SIGNIN_REQUEST = 1001;
    public static final String MY_GLOBAL_PREFS = "my_global_prefs";
    private static final int REQUEST_PERMISSION_WRITE = 1002;
    private List<DataItem> dataItemList;// = DataFromJSON.dataItemList;
    private boolean permissionGranted;
    DataSource mDataSource;
    List<DataItem> listFromDB;
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    String[] mLocations;
    RecyclerView mRecyclerView;
    DataItemAdapter mItemAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!permissionGranted) checkPermissions();

        //Code to manage sliding navigation drawer
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mLocations = getResources().getStringArray(R.array.locations);
        mDrawerList = findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new ArrayAdapter<>(this,
                R.layout.drawer_list_item, mLocations));

        mDrawerList.setOnItemClickListener((parent, view, position, id) -> {
            String location = mLocations[position];
            Toast.makeText(MainActivity.this, "You chose " + location,
                    Toast.LENGTH_LONG).show();
            mDrawerLayout.closeDrawer(mDrawerList);
            DisplayDataItems(String.valueOf(position));
        });
        //end of navigation drawer

        mDataSource = new DataSource(this);
        mDataSource.open();
        mDataSource.seedDataBase(dataItemList);
//        dataItemList = JSONHelper.importFromJSON(this);

//        Collections.sort(dataItemList, (o1, o2) ->
//                o1.getItemName().compareTo(o2.getItemName()));


        /*access preference status*/
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        Log.i(TAG, settings.getAll().toString());
        //                String weather = settings.getString(getString(R.string.weatherStatus), "SUNNY");
        //    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
        SharedPreferences.OnSharedPreferenceChangeListener prefsListener = (sharedPreferences, key) -> {
            Log.i(TAG, "prefs listener detected onSharedPreferenceChange " + key);
//                String weather = settings.getString(getString(R.string.weatherStatus), "SUNNY");
        };
        settings.registerOnSharedPreferenceChangeListener(prefsListener);
        mRecyclerView = findViewById(R.id.rvItems);
        DisplayDataItems(null);
    }

    private void DisplayDataItems(String location) {
        listFromDB = mDataSource.getAllItems(location);
        mItemAdapter = new DataItemAdapter(this, listFromDB);
        mRecyclerView.setAdapter(mItemAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.open();
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
            case R.id.action_status:
                // Show the status screen
                Intent SettingsIntent = new Intent(this, StatusActivity.class);
                startActivity(SettingsIntent);
                return true;
            case R.id.action_export_JSON:
                boolean result = JSONHelper.exportToJSON(this, dataItemList);
                if (result) {
                    Toast.makeText(this, "Data Exported", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Export failed", Toast.LENGTH_LONG).show();
                }
                return true;
            case R.id.action_import_TDF:
                //this will be getting data from TDF
                DataFromTDF fromTDF = new DataFromTDF(this);
                List<DataItem> dataItemList = fromTDF.dataItemList;
                if (dataItemList != null) {
                    for (DataItem dataitem :
                            dataItemList) {
                        Log.i(TAG, "onOptionsItemSelected: " + dataitem.getItemName());
                    }
                } else {
                    Log.i(TAG, "No data items to display!");
                }
            case R.id.action_import_JSON:
                //this will be getting data from JSON
                dataItemList = JSONHelper.importFromJSON(this);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == SIGNIN_REQUEST) {
            String email = data.getStringExtra(SigninActivity.EMAIL_KEY);
            Toast.makeText(this, "You signed in as " + email, Toast.LENGTH_LONG).show();

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
                    Toast.LENGTH_LONG).show();
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
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "You must grant permission!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
