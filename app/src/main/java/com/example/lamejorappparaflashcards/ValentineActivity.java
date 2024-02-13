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
import android.widget.ListView;
import android.widget.Toast;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

public class ValentineActivity extends AppCompatActivity {
    //private boolean espaToJapa;
    //private boolean kanjiKana;
    private boolean palabras;
    private SQLiteDatabase db;
    private String Table;
    private int size;
    private Context context;
    private List<String> content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valentine);

        palabras = false;

        //espaToJapa = (boolean) getIntent().getExtras().get("E2J");
        //kanjiKana = (boolean) getIntent().getExtras().get("KK");

        List<String> tables = new ArrayList<>();
        List<String> tablesReal = new ArrayList<>();
        ListView tablesView = findViewById(R.id.objects);
        SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
        context = this;

        try {
            db = databaseHelper.getReadableDatabase();

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

                //Intent intent = new Intent(TablesListActivity.this, SubMenuActivity.class);
                //intent.putExtra("E2J", espaToJapa);
                //intent.putExtra("KK", kanjiKana);
                //intent.putExtra("unit_table", tablesReal.get((int) id));
                //startActivity(intent);


                if(!palabras){
                    content = new ArrayList<>();

                    db = databaseHelper.getReadableDatabase();

                    Table = tablesReal.get((int)id);
                    Table = Table.replace(' ', '_');
                    size = (int) DatabaseUtils.queryNumEntries(db, Table);

                    if (size > 0){
                        try {
                            int j = 0;
                            for (int i = 1; i <= size + j; i++){
                                Cursor cursor = db.query(Table, new String[]{"_id", "F_TEXT", "K_TEXT", "B_TEXT"}, "_id = ?", new String[]{Integer.toString(i)}, null, null, null);

                                if (cursor.moveToFirst()) {
                                    String Id = Integer.toString(cursor.getInt(0));
                                    String frontText = cursor.getString(1);
                                    String frontHText = cursor.getString(2);
                                    String backText = cursor.getString(3);

                                    content.add(Id+"-"+frontText+"-"+frontHText+"-"+backText);
                                }else{
                                    j++;
                                }

                                cursor.close();
                            }

                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                                    context,
                                    android.R.layout.simple_list_item_1,
                                    content
                            );

                            tablesView.setAdapter(arrayAdapter);
                        }catch (Exception e){
                            System.out.println("No database");
                        }
                    }else{
                        Toast toast = Toast.makeText(context,"Set de cartas vacio", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    palabras = true;
                }else{
                    String palabra = content.get((int)id).replaceFirst("-","_     ");
                    palabra = palabra.substring(palabra.indexOf('_') + 1);
                    palabra = palabra.replace("-","\n     ");
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Este San Valentin quiero expresar mis sentimientos por ti con esta palabra:\n" + palabra + "\nFeliz San Valentin");
                    sendIntent.setType("text/plain");

                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    startActivity(shareIntent);
                }
            }
        };

        tablesView.setOnItemClickListener(itemClickListener);
    }

    @Override
    public void onBackPressed(){
        if (palabras){

        }else{
            super.onBackPressed();
        }
    }
}