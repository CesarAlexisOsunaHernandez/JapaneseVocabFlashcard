package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class CardActivity extends AppCompatActivity {
    private Context context;
    private String Table;
    private SQLiteOpenHelper databaseHelper;
    private SQLiteDatabase db;

    private int size;
    private boolean used[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        Table = (String) getIntent().getExtras().get("unit_table");

        databaseHelper = new DatabaseHelper(this);

        try {
            db = databaseHelper.getReadableDatabase();
        }catch (Exception e){

        }

        size = (int) DatabaseUtils.queryNumEntries(db, Table);
        used = new boolean[size];

        TextView againBtn = findViewById(R.id.again);
        againBtn.setVisibility(View.INVISIBLE);

        getDatabaseElement(Table);
    }

    public void manageCard(View view){
        TextView b_text = findViewById(R.id.back);

        if (b_text.getVisibility() == View.INVISIBLE){
            b_text.setVisibility(View.VISIBLE);
        }else if(!allUsed(size)){
            getDatabaseElement(Table);
        }else{
            TextView againBtn = findViewById(R.id.again);
            againBtn.setVisibility(View.VISIBLE);
            db.close();
        }
    }

    protected void getDatabaseElement(String table){
        int cardId;
        try {
            TextView f_text = findViewById(R.id.front);
            TextView h_text = findViewById(R.id.front_h);
            TextView b_text = findViewById(R.id.back);

            h_text.setVisibility(View.VISIBLE);

            Random ran = new Random();

            do{
                cardId = ran.nextInt((int) DatabaseUtils.queryNumEntries(db, table));
            }while (used[cardId]);

            used[cardId] = true;

            Cursor cursor = db.query(table, new String[]{"F_TEXT", "K_TEXT", "B_TEXT"}, "_id = ?", new String[]{Integer.toString(cardId + 1)}, null, null, null);

            if (cursor.moveToFirst()) {
                String frontText = cursor.getString(0);
                String frontHText = cursor.getString(1);
                String backText = cursor.getString(2);

                f_text.setText(frontText);
                if(frontHText.equals(frontText))
                    h_text.setVisibility(View.INVISIBLE);
                h_text.setText(frontHText);

                b_text.setVisibility(View.INVISIBLE);
                b_text.setText(backText);
            }
            cursor.close();

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, context.getString(R.string.test), Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private boolean allUsed(int size){
        for(int i = 0; i < size; i++){
            if(!used[i]){
                return false;
            }
        }
        return true;
    }

    public void restart(View view){
        TextView againBtn = findViewById(R.id.again);
        againBtn.setVisibility(View.INVISIBLE);

        for(int i = 0; i < size; i++){
            used[i] = false;
        }

        try {
            db = databaseHelper.getReadableDatabase();
        }catch (Exception e){

        }
        getDatabaseElement(Table);
    }
}