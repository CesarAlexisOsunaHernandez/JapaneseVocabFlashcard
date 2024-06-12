package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class CardActivity extends AppCompatActivity {
    private Context context;
    private String Table;
    private boolean E2J;
    private boolean KK;
    private SQLiteOpenHelper databaseHelper;
    private SQLiteDatabase db;

    private int size;
    private float correct;
    private int cardId;
    private boolean[] used;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Table = (String) getIntent().getExtras().get("unit_table");
        Table = Table.replace(' ', '_');
        E2J = (boolean) getIntent().getExtras().get("E2J");
        KK = (boolean) getIntent().getExtras().get("KK");

        databaseHelper = new DatabaseHelper(this);

        try {
            db = databaseHelper.getReadableDatabase();
        }catch (Exception e){

        }

        View againBtn = findViewById(R.id.again);
        View corrBtn = findViewById(R.id.correct);
        View almstBtn = findViewById(R.id.almost);
        View incorrBtn = findViewById(R.id.incorrect);

        againBtn.setVisibility(View.INVISIBLE);
        corrBtn.setVisibility(View.INVISIBLE);
        almstBtn.setVisibility(View.INVISIBLE);
        incorrBtn.setVisibility(View.INVISIBLE);

        size = (int) DatabaseUtils.queryNumEntries(db, Table);
        if (size > 0) {
            used = new boolean[size];
            correct = 0;

            TextView b_text = findViewById(R.id.back);
            TextView f_text = findViewById(R.id.front);
            TextView f2_text = findViewById(R.id.front2);
            TextView h_text = findViewById(R.id.front_h);

            if (savedInstanceState != null) {
                used = savedInstanceState.getBooleanArray("used");
                cardId = savedInstanceState.getInt("cardId");
                correct = savedInstanceState.getInt("correct");

                Cursor cursor = db.query(Table, new String[]{"F_TEXT", "K_TEXT", "B_TEXT"}, "_id = ?", new String[]{Integer.toString(cardId + 1)}, null, null, null);

                if (cursor.moveToFirst()) {
                    String frontText = cursor.getString(0);
                    String frontHText = cursor.getString(1);
                    String backText = cursor.getString(2);

                    f_text.setText(frontText);
                    f2_text.setText(frontText);

                    if (frontHText.equals(frontText) || !KK)
                        h_text.setVisibility(View.INVISIBLE);
                    h_text.setText(frontHText);

                    b_text.setVisibility(View.INVISIBLE);
                    b_text.setText(backText);

                    if (E2J) {
                        f_text.setVisibility(View.INVISIBLE);
                        h_text.setVisibility(View.INVISIBLE);
                        b_text.setVisibility(View.VISIBLE);
                    }
                }
                cursor.close();
            } else {
                getDatabaseElement(Table);
            }
        }else{
            Toast toast = Toast.makeText(this,"Set de cartas vacio", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void manageCard(View view){
        TextView b_text = findViewById(R.id.back);
        TextView f_text = findViewById(R.id.front);
        TextView k_text = findViewById(R.id.front_h);

        View corrBtn   = findViewById(R.id.correct);
        View almstBtn = findViewById(R.id.almost);
        View incorrBtn = findViewById(R.id.incorrect);

        if (b_text.getVisibility() == View.INVISIBLE){    //Si el texto de abajo es invisible
            b_text.setVisibility(View.VISIBLE);
            corrBtn.setVisibility(View.VISIBLE);
            almstBtn.setVisibility(View.VISIBLE);
            incorrBtn.setVisibility(View.VISIBLE);

            if(!f_text.getText().equals(k_text.getText()) && !KK) {
                k_text.setVisibility(View.VISIBLE);
            }
        }else if(f_text.getVisibility() == View.INVISIBLE && k_text.getVisibility() == View.INVISIBLE){ //Si los dos textos de arriba son invisibles
            f_text.setVisibility(View.VISIBLE);
            corrBtn.setVisibility(View.VISIBLE);
            almstBtn.setVisibility(View.VISIBLE);
            incorrBtn.setVisibility(View.VISIBLE);

            if (!f_text.getText().equals(k_text.getText()))
                k_text.setVisibility(View.VISIBLE);
        }else if(!allUsed(size) && corrBtn.getVisibility() != View.VISIBLE){
            getDatabaseElement(Table);
        }
    }

    protected void getDatabaseElement(String table){
        try {
            TextView f_text = findViewById(R.id.front);
            TextView f2_text = findViewById(R.id.front2);
            TextView h_text = findViewById(R.id.front_h);
            TextView b_text = findViewById(R.id.back);

            h_text.setVisibility(View.VISIBLE);

            Random ran = new Random();

            do{
                cardId = ran.nextInt((int) DatabaseUtils.queryNumEntries(db, Table));
            }while (used[cardId]);

            used[cardId] = true;

            Cursor cursor = db.query(table, new String[]{"F_TEXT", "K_TEXT", "B_TEXT"}, "_id = ?", new String[]{Integer.toString(cardId + 1)}, null, null, null);

            if (cursor.moveToFirst()) {

                String frontText = cursor.getString(0);
                String frontHText = cursor.getString(1);
                String backText = cursor.getString(2);

                f_text.setText(frontText);
                f2_text.setText(frontText);

                if(frontHText.equals(frontText) || !KK)
                    h_text.setVisibility(View.INVISIBLE);
                h_text.setText(frontHText);

                b_text.setVisibility(View.INVISIBLE);
                b_text.setText(backText);

                if (E2J){
                    f_text.setVisibility(View.INVISIBLE);
                    h_text.setVisibility(View.INVISIBLE);
                    b_text.setVisibility(View.VISIBLE);
                }
            }
            cursor.close();

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this,"Set de cartas vacio", Toast.LENGTH_SHORT);
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
        correct = 0;
        getDatabaseElement(Table);
    }

    public void updateScore(View view){
        View corrBtn   = findViewById(R.id.correct);
        View slash   = findViewById(R.id.slash);
        View almstBtn = findViewById(R.id.almost);
        View incorrBtn = findViewById(R.id.incorrect);

        if (view.getId() == R.id.correct){
            correct++;
        }else if(view.getId() == R.id.almost){
            correct += 0.5F;
        }

        corrBtn.setVisibility(View.INVISIBLE);
        almstBtn.setVisibility(View.INVISIBLE);
        incorrBtn.setVisibility(View.INVISIBLE);

        //manageCard(view);
        if(allUsed(size)){
            View againBtn = findViewById(R.id.again);

            TextView f_text = findViewById(R.id.front);
            TextView f2_text = findViewById(R.id.front2);
            TextView h_text = findViewById(R.id.front_h);
            TextView b_text = findViewById(R.id.back);

            againBtn.setVisibility(View.VISIBLE);

            f_text.setText("Correctas");
            slash.setVisibility(View.GONE);
            f2_text.setVisibility(View.GONE);
            h_text.setVisibility(View.INVISIBLE);
            b_text.setText(Float.toString(correct) + " / " + Integer.toString(size));

            db.close();
        }else{
            getDatabaseElement(Table);
        }
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        db.close();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBooleanArray("used", used);
        savedInstanceState.putInt("cardId", cardId);
        savedInstanceState.putFloat("correct", correct);
    }
}