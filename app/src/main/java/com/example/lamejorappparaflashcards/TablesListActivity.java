package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class TablesListActivity extends AppCompatActivity {
    private String to_csv;
    private boolean espaToJapa;
    private boolean kanjiKana;
    private boolean all;
    private boolean download;
    private boolean normalFont;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables_list);

        espaToJapa = (boolean) getIntent().getExtras().get("E2J");
        kanjiKana = (boolean) getIntent().getExtras().get("KK");
        all = (boolean) getIntent().getExtras().get("all");
        download = (boolean) getIntent().getExtras().get("download");
        normalFont = (boolean) getIntent().getExtras().get("NF");

        List<String> tables = new ArrayList<>();
        List<String> tablesReal = new ArrayList<>();
        ListView tablesView = findViewById(R.id.tables);
        SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);

        try {
            db = databaseHelper.getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    // Retrieve table names
                    String tableName = cursor.getString(0);

                    if (!tableName.equals("android_metadata") && !tableName.equals("sqlite_sequence")){
                            if(all){
                                tablesReal.add(tableName.replace('_', ' '));
                                if (tableName.equals("UNIT_ONE"))
                                    tableName = this.getString(R.string.unit1);
                                if (tableName.equals("UNIT_TWO"))
                                    tableName = this.getString(R.string.unit2);
                                if (tableName.equals("UNIT_THREE"))
                                    tableName = this.getString(R.string.unit3);
                                if (tableName.equals("UNIT_FOUR"))
                                    tableName = this.getString(R.string.unit4);
                                if (tableName.equals("UNIT_FIVE"))
                                    tableName = this.getString(R.string.unit5);
                                if (tableName.equals("UNIT_SIX"))
                                    tableName = this.getString(R.string.unit6);
                                if (tableName.equals("UNIT_SEVEN"))
                                    tableName = this.getString(R.string.unit7);
                                if (tableName.equals("UNIT_EIGHT"))
                                    tableName = this.getString(R.string.unit8);
                                tables.add(tableName.replace('$', ' '));
                            }else{
                                if (!tableName.equals("HIRAGANA") && !tableName.equals("KATAKANA") && !tableName.equals("UNIT_ONE") && !tableName.equals("UNIT_TWO") && !tableName.equals("UNIT_THREE") && !tableName.equals("UNIT_FOUR") && !tableName.equals("UNIT_FIVE") && !tableName.equals("UNIT_SIX") && !tableName.equals("UNIT_SEVEN") && !tableName.equals("UNIT_EIGHT")) {
                                    tables.add(tableName.replace('$', ' '));
                                }
                            }
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

        if(tables.isEmpty() && !all){
            if(download){
                Toast toast = Toast.makeText(this,"No hay sets para descargar", Toast.LENGTH_SHORT);
                toast.show();
            }else{
                Toast toast = Toast.makeText(this,"No hay sets para borrar", Toast.LENGTH_SHORT);
                toast.show();
            }
        }

        AdapterView.OnItemClickListener itemClickListener;
        if(download) {              //Descargar set
            itemClickListener = new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> listTables, View itemView, int position, long id) {
                    to_csv = "";

                    int size = (int) DatabaseUtils.queryNumEntries(db, tables.get((int)(id)).replace(' ','$'));

                    to_csv = to_csv.concat(tables.get((int)(id)).replace('$',' ') + ",,,\n");

                    for(int i = 1; i <= size; i++){
                        System.out.println(tables.get((int)(id)).replace('$',' '));
                        Cursor cursor = db.query(tables.get((int)(id)).replace(' ','$'), new String[]{"_id", "F_TEXT", "K_TEXT", "B_TEXT"}, "_id = ?", new String[]{Integer.toString(i)}, null, null, null);
                        if (cursor.moveToFirst()){
                            to_csv = to_csv.concat(cursor.getString(1) + "," + cursor.getString(2) + "," + cursor.getString(3) + "\n");
                        }
                    }


                    //escribirObjeto(to_csv,tables.get((int)(id)).replace(' ','$'));

                    Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.setType("text/*");
                    intent.putExtra(Intent.EXTRA_TITLE, tables.get((int)(id)).replace('$',' ') + ".csv");
                    startActivityForResult(intent, 5);
                }
            };
        }else if(!all){             //Borrar set
            itemClickListener = new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> listTables, View itemView, int position, long id) {
                    db.execSQL("DROP TABLE " + tables.get((int)(id)).replace(' ','$'));

                    Intent intent = new Intent(TablesListActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            };
        }else{                      //Ir a submenu de un set
            itemClickListener = new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> listTables, View itemView, int position, long id) {

                    Intent intent = new Intent(TablesListActivity.this, SubMenuActivity.class);
                    intent.putExtra("E2J", espaToJapa);
                    intent.putExtra("KK", kanjiKana);
                    intent.putExtra("NF", normalFont);
                    intent.putExtra("unit_table", tablesReal.get((int) id));
                    startActivity(intent);
                }
            };
        }

        tablesView.setOnItemClickListener(itemClickListener);
    }
    @Override
    public void onBackPressed(){
        if(all){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);
        List<String> csv;
        Context context = this;
        SQLiteDatabase db;
        DatabaseHelper dbh = new DatabaseHelper(context);
        db = dbh.getReadableDatabase();

        if (requestCode == 5 && resultCode == Activity.RESULT_OK) {
            // The result data contains a URI for the document or directory that
            // the user selected.
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();

                try {
                    OutputStream outputStream = getContentResolver().openOutputStream(uri);
                    outputStream.write(to_csv.getBytes());
                    outputStream.close();
                } catch (IOException e) {
                    Toast toast = Toast.makeText(this,"Error al crear archivo", Toast.LENGTH_SHORT);
                    toast.show();
                    throw new RuntimeException(e);
                }
            }
        }
    }
}