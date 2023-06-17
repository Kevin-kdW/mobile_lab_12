package com.example.lab12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        long countryId = getIntent().getLongExtra("COUNTRY_ID", -1);

        SQLiteOpenHelper databaseHelper = new MyDatabaseHelper(this);
        try {
            db = databaseHelper.getReadableDatabase();
            Cursor cursor = db.query("COUNTRY",
                    new String[]{"_id", "NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id=?",
                    new String[]{String.valueOf(countryId)},
                    null,
                    null,
                    null);

            if (cursor != null && cursor.moveToFirst()) {
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                int imageResourceId = cursor.getInt(3);

                TextView nameTextView = findViewById(R.id.name);
                TextView descriptionTextView = findViewById(R.id.description);
                ImageView imageView = findViewById(R.id.image);

                // imageResoueceIs not added. Unsure how to fix. Austrlia is used for all images.. for now
                nameTextView.setText(name);
                descriptionTextView.setText(description);
                imageView.setImageResource(R.drawable.australia);
            }

        } catch(SQLiteException ex){
            Toast.makeText(this,"SQL Error" + ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cursor != null) {
            cursor.close();
        }
        if (db != null) {
            db.close();
        }
    }
}
