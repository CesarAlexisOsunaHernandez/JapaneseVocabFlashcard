package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
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

public class DeleteCardActivity extends AppCompatActivity {
    SQLiteDatabase db;
    private String Table;
    private boolean espaToJapa;
    private boolean kanjiKana;
    private int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_card);

        List<String> content = new ArrayList<>();
        ListView tablesView = findViewById(R.id.content_del);
        SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);

        db = databaseHelper.getReadableDatabase();

        espaToJapa = (boolean) getIntent().getExtras().get("E2J");
        kanjiKana = (boolean) getIntent().getExtras().get("KK");
        Table = (String) getIntent().getExtras().get("unit_table");
        Table = Table.replace(' ', '_');
        size = (int) DatabaseUtils.queryNumEntries(db, Table);

        if (size > 0){
            try {
                int j = 0;
                for (int i = 1; i <= size + j; i++){
                    Cursor cursor = db.query(Table, new String[]{"_id", "F_TEXT", "K_TEXT", "B_TEXT"}, "_id = ?", new String[]{Integer.toString(i)}, null, null, null);

                    if (cursor.moveToFirst()) {
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


        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listTables, View itemView, int position, long id) {
                //Intent intent = new Intent(TablesListActivity.this, CardActivity.class);
                System.out.print("id: ");
                System.out.println(id);
                System.out.print("position: ");
                System.out.println(position);
                db.delete(Table,"_id = " + (id + 1), null);
                for(int i = 1; i <= size; i++) {
                    ContentValues value = new ContentValues();
                    value.put("_id", (id + i));
                    db.update(Table, value, "_id = " + (id + 1 + i), null);
                }

                Intent intent = new Intent(DeleteCardActivity.this, SubMenuActivity.class);
                intent.putExtra("E2J", espaToJapa);
                intent.putExtra("KK", kanjiKana);
                intent.putExtra("unit_table", Table);
                intent.putExtra("NF", true);
                startActivity(intent);
            }
        };

        tablesView.setOnItemClickListener(itemClickListener);
    }
}