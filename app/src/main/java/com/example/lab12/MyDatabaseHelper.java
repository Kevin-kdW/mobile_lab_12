package com.example.lab12;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String DatabaseName = "Lab12";
    public static final int DB_Ver = 2;

    MyDatabaseHelper(Context context) {
        super(context, DatabaseName, null, DB_Ver);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE COUNTRY (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, IMAGE_RESOURCE_ID INTEGER)");

        //prepopulate data
        ContentValues countryValues = new ContentValues();
        countryValues.put("NAME", "Australia");
        countryValues.put("DESCRIPTION", "Australia is a country and continent located in the Southern Hemisphere, known for its unique wildlife and diverse landscapes.");
        countryValues.put("IMAGE_RESOURCE_ID",R.drawable.australia);
        sqLiteDatabase.insert("COUNTRY", null, countryValues);


        ContentValues countryValues2 = new ContentValues();
        countryValues2.put("NAME", "Brazil");
        countryValues2.put("DESCRIPTION", "Brazil is the largest country in South America, famous for its annual carnival in Rio de Janeiro and its passion for football.");
        countryValues2.put("IMAGE_RESOURCE_ID", R.drawable.brazil);
        sqLiteDatabase.insert("COUNTRY", null, countryValues2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            ContentValues newValues = new ContentValues();
            newValues.put("DESCRIPTION", "AUSTRALIA, the smallest continent known for unique wildlife and pristine beaches");
            sqLiteDatabase.update("COUNTRY", newValues, "NAME = ?", new String[]{"Australia"});
            sqLiteDatabase.delete("COUNTRY", "NAME = ?", new String[]{"Australia"});
        }

    }
}
