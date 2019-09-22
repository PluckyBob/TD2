package com.example.td2.data.sample;

import com.example.td2.data.model.DataItem;

import java.util.ArrayList;
import java.util.List;

class SampleDataProvider {

    private static final List<DataItem> dataItemList;
    public static final String TAG = "TAG:SampleDataProvider";
//    public static Map<String, DataItem> dataItemMap;

    static {
        dataItemList = new ArrayList<>();
//        String CSV_FILE = "/data/data/com.example.td2/cache/todo.csv";
//        FileReader in = null;
//        try {
//            in = new FileReader(CSV_FILE);
//        } catch (FileNotFoundException e) {
//            Log.i(TAG, "File not found" + e);
//        }
//        String lineFromFile = null;
//        DataItem dataItemList;
//        ArrayList<DataItem> dataItems = new ArrayList<>();
//        Log.i(TAG, "Trying instantiate Buffered reader");
//        BufferedReader bReader = new BufferedReader(in);
//
//        Log.i(TAG, "Trying to get a line from the file");
////        Obtain the title row
//        try {
//            lineFromFile = bReader.readLine();
//            Log.i(TAG,lineFromFile);
//        } catch (IOException e) {
//            Log.i(TAG,"Error obtaining column titles");
//            e.printStackTrace();
//        }

        addItem(new DataItem(null, "Go To Work", "Go To Work", 1,
                1, "1:00", "09/08/19 05:00", "09/08/19 05:00", null,
                null, "d", "12345", "43235.35804", 1, 0,
                "0.208333333", "0.583333333", 1, 4,
                false, false, 0));

        addItem(new DataItem(null, "Pick up H from karate", "Pick up H from karate", 2, 1, "2:10", "05/08/19 20:10", "05/08/19 20:30", null, null, "w1", "1", "42765.33959", 1, 0, "0.291666667", "0.999305556", 4, 2, false, false, 0));
        addItem(new DataItem(null, "Measure Sams Height", "Measure Sams Height", 6, 1, "0:25", "22/08/19 16:28", "ASAP", null, null, "Fw2", "1234567", "42137.75486", 1, 0, "0.291666667", "0.875", 1, 5, false, true, 0));
        addItem(new DataItem(null, "Go To Bed W/D", "Go To Bed W/D", 2, 1, "7:35", "08/04/19 22:00", "08/04/19 22:00", null, null, "d", "12347", "43229.31179", 1, 0, "0.875", "0.999305556", 1, 7, true, true, 0));
        addItem(new DataItem(null, "Go to bed at weekend", "Go to bed at weekend", 1, 1, "7:30", "07/04/19 21:00", "07/04/19 21:00", null, null, "d", "567", "43233.86536", 1, 0, "0.875", "0.291666667", 1, 8, false, false, 0));
        addItem(new DataItem(null, "sort car insurance Comparethemarket", "sort car insurance Comparethemarket", 1, 0, "0:30", "22/05/20 08:46", "23/05/20 08:46", null, null, "y", "1234567", "43607.36545", 0, 0, "0.291666667", "0.291666667", 8, 2, false, false, 0));
        addItem(new DataItem(null, "Get sam ready for swimming", "Get sam ready for swimming", 1, 1, "00:10", "07/04/19 15:30", "07/04/19 16:00", null, null, "w", "7", "43212.64675", 1, 0, "0.645833333", "0.6875", 1, 9, false, false, 0));
        addItem(new DataItem(null, "Sams' homework", "Sams' homework", 2, 1, "0:30", "09/08/19 10:00", "09/08/19 10:00", null, null, "d", "1234567", "43422.62667", 1, 0, "0.416666667", "0.833333333", 1, 10, false, false, 0));
        addItem(new DataItem(null, "Practice Guitar (Electronica)", "Practice Guitar (Electronica)", 2, 1, "1:15", "14/08/19 09:00", "14/08/19 09:00", null, null, "FH12", "1234567", "43233.86696", 1, 0, "0.375", "0.999305556", 1, 11, false, false, 0));
        addItem(new DataItem(null, "Experian", "Experian", 1, 0, "0:30", "14/08/19 08:41", "28/08/19 08:41", null, null, null, "1234567", "43683.53644", 0, 0, "0.000694444", "0.999988426", 2, 13, false, false, 0));
        addItem(new DataItem(null, "File self assessment return", "File self assessment return", 5, 0, "1:00", "27/04/20 10:00", "07/10/20 16:40", null, null, "y", "1234567", "42488.62569", 1, 0, "1.15741E-05", "0.999988426", 12, 9, false, false, 0));
        addItem(new DataItem(null, "Take H to Karate", "Take H to Karate", 1, 1, "0:40", "28/01/19 17:10", "28/01/19 17:10", null, null, "w1", "1", "42765.33957", 1, 0, "0.5", "0.770833333", 1, 17, true, false, 0));
        addItem(new DataItem(null, "Tea Break (AM)", "Tea Break (AM)", 1, 0, "00:15", "08/08/19 09:45", "08/08/19 09:45", null, null, "d", "12345", "43270.33681", 1, 0, "1.15741E-05", "0.999988426", 9, 16, false, false, 0));
        addItem(new DataItem(null, "Hs bday 13/12", "Hs bday 13/12", 1, 0, "0:00", "12/12/19 00:01", "14/12/19 07:01", null, null, "y", "1234567", "42718.36041", 1, 0, "1.15741E-05", "0.999988426", 18, 4, false, false, 0));
        addItem(new DataItem(null, "Sort out clean clothes for morning", "Sort out clean clothes for morning", 5, 1, "0:30", "06/04/19 18:30", "06/04/19 21:00", null, null, "d", "1234567", "42716.3431", 1, 0, "0.708333333", "0.875", 1, 19, false, false, 0));
        addItem(new DataItem(null, "Exercise", "Exercise", 1, 1, "1:00", "09/08/19 00:01", "09/08/19 00:01", null, null, "d", "1234567", "43234.33957", 1, 0, "0.000694444", "0.458333333", 19, 1, false, false, 0));
        addItem(new DataItem(null, "House insurance due for renewal on 15th December (Careful it may automatically renew", "House insurance due for renewal on 15th December (Careful it may automatically renew", 1, 0, "1:00", "26/11/19 09:00", "10/12/19 09:00", null, null, "y", "1234567", "43054.37637", 1, 0, "1.15741E-05", "0.999988426", 13, 14, false, false, 0));
        addItem(new DataItem(null, "Go Home", "Go Home", 1, 2, "01:00", "08/08/19 16:15", "08/08/19 16:15", null, null, "d", "12345", "43235.35762", 2, 0, "1.15741E-05", "0.999988426", 19, 6, false, false, 0));
        addItem(new DataItem(null, "Regional Council", "Regional Council", 1, 0, "5:00", "19/10/19 10:15", "19/10/19 10:30", null, null, null, "6", "43516.66429", 3, 0, "0.427083333", "0.4375", 20, 5, false, false, 10));
        addItem(new DataItem(null, "Put out recycling", "Put out recycling", 5, 1, "3:10", "09/04/19 17:52", "09/04/19 21:52", null, null, "w1", "23", "42711.37355", 1, 0, "1.15741E-05", "0.999988426", 1, 21, false, false, 0));
        addItem(new DataItem(null, "top IA fund?", "top IA fund?", 2, 2, "0:30", "05/03/20 07:00", "07/11/20 17:00", null, null, "y", "12345", "42404.44414", 3, 0, "0.291666667", "0.729166667", 11, 18, false, false, 10));


    }

    private static void addItem(DataItem item) {
        dataItemList.add(item);
//        dataItemMap.put(item.getItemID(), item);

    }

}
