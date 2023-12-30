package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SetContentActivity extends AppCompatActivity {
    //private boolean espaToJapa;
    //private boolean kanjiKana;
    SQLiteDatabase db;
    private String Table;
    private int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_content);

        List<String> content = new ArrayList<>();
        ListView tablesView = findViewById(R.id.content_look);
        SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);

        db = databaseHelper.getReadableDatabase();

        //espaToJapa = (boolean) getIntent().getExtras().get("E2J");
        //kanjiKana = (boolean) getIntent().getExtras().get("KK");
        Table = (String) getIntent().getExtras().get("unit_table");
        Table = Table.replace(' ', '_');
        size = (int) DatabaseUtils.queryNumEntries(db, Table);
        System.out.print("size: ");
        System.out.println(size);
        if (size > 0){
            try {
                int j = 0;
                for (int i = 1; i <= size + j; i++){
                    Cursor cursor = db.query(Table, new String[]{"_id", "F_TEXT", "K_TEXT", "B_TEXT"}, "_id = ?", new String[]{Integer.toString(i)}, null, null, null);

                    if (cursor.moveToFirst()) {
                        System.out.print("i: ");
                        System.out.println(i);
                        String id = Integer.toString(cursor.getInt(0));
                        String frontText = cursor.getString(1);
                        String frontHText = cursor.getString(2);
                        String backText = cursor.getString(3);

                        content.add(id+"-"+frontText+"-"+frontHText+"-"+backText);
                    }else{
                        j++;
                    }

                    cursor.close();
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        content
                );

                tablesView.setAdapter(arrayAdapter);
            }catch (Exception e){
                System.out.println("No database");
            }
        }else{
            Toast toast = Toast.makeText(this,"Set de cartas vacio", Toast.LENGTH_SHORT);
            toast.show();
        }


//        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> listTables, View itemView, int position, long id) {
//                //Intent intent = new Intent(TablesListActivity.this, CardActivity.class);
//                Intent intent = new Intent(SetContentActivity.this, SubMenuActivity.class);
//                //intent.putExtra("E2J", espaToJapa);
//                //intent.putExtra("KK", kanjiKana);
//                intent.putExtra("unit_table", id);
//                startActivity(intent);
//            }
//        };
//
//        tablesView.setOnItemClickListener(itemClickListener);
    }

//    private String getTableName(long id){
//        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
//        int i = -1;
//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//                // Retrieve table names
//                String tableName = cursor.getString(0);
//
//                if (!tableName.equals("android_metadata") && !tableName.equals("sqlite_sequence")) {
//                    i++;
//                }
//                if (i == id)
//                    return tableName;
//            }
//
//        }
//        return "-1";
//    }
}