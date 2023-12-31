package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TablesListActivity extends AppCompatActivity {
    private boolean espaToJapa;
    private boolean kanjiKana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_list);

        espaToJapa = (boolean) getIntent().getExtras().get("E2J");
        kanjiKana = (boolean) getIntent().getExtras().get("KK");

        List<String> tables = new ArrayList<>();
        List<String> tablesReal = new ArrayList<>();
        ListView tablesView = findViewById(R.id.tables);
        SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);

        try {
            SQLiteDatabase db = databaseHelper.getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    // Retrieve table names
                    String tableName = cursor.getString(0);

                    if (!tableName.equals("android_metadata") && !tableName.equals("sqlite_sequence")) {
                        tablesReal.add(tableName.replace('_',' '));
                        if (tableName.equals("KATAKANA"))
                            tableName = this.getString(R.string.katakana);
                        if (tableName.equals("UNIT_FIVE"))
                            tableName = this.getString(R.string.unit5);
                        if (tableName.equals("UNIT_SIX"))
                            tableName = this.getString(R.string.unit6);
                        if (tableName.equals("UNIT_SEVEN"))
                            tableName = this.getString(R.string.unit7);
                        if (tableName.equals("UNIT_EIGHT"))
                            tableName = this.getString(R.string.unit8);
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

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listTables, View itemView, int position, long id) {

                Intent intent = new Intent(TablesListActivity.this, SubMenuActivity.class);
                intent.putExtra("E2J", espaToJapa);
                intent.putExtra("KK", kanjiKana);
                intent.putExtra("unit_table", tablesReal.get((int) id));
                startActivity(intent);
            }
        };

        tablesView.setOnItemClickListener(itemClickListener);
    }

    @Override
    public void onBackPressed(){
        //super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}