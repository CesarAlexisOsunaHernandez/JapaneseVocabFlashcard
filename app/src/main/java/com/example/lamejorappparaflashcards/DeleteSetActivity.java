package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DeleteSetActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_set);

        List<String> tables = new ArrayList<>();
        ListView tablesView = findViewById(R.id.tables_del);
        SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);

        db = databaseHelper.getReadableDatabase();

        try {
            SQLiteDatabase db = databaseHelper.getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    // Retrieve table names
                    String tableName = cursor.getString(0);

                    if (!tableName.equals("android_metadata") && !tableName.equals("sqlite_sequence") &&
                        !tableName.equals("KATAKANA") && !tableName.equals("UNIT_FIVE") && !tableName.equals("UNIT_SIX") &&
                        !tableName.equals("UNIT_SEVEN") && !tableName.equals("UNIT_EIGHT")) {
                        tables.add(tableName.replace('$',' '));
                    }
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        tables
                );

                tablesView.setAdapter(arrayAdapter);
                cursor.close();
            }
        }catch (Exception e){
            System.out.println("No database");
        }

        if(tables.isEmpty()){
            Toast toast = Toast.makeText(this,"No hay sets para borrar", Toast.LENGTH_SHORT);
            toast.show();
        }

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listTables, View itemView, int position, long id) {
                db.execSQL("DROP TABLE " + tables.get((int)(id)).replace(' ','$'));

                Intent intent = new Intent(DeleteSetActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };

        tablesView.setOnItemClickListener(itemClickListener);
    }
}