package com.lakhlifi.sqlite_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.lakhlifi.sqlite_project.Models.Person;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {


    public MyDatabase(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    public static final int databaseVersion = 1;
    public static final String databaseName = "person_db";
    // Définition des tables
    public static final String TABLE_PERSON = "persons";
    // les noms des colonnes
    public static final String Col_CODE = "Code";
    public static final String Col_NOM = "Nom";
    public static final String Col_Prenom = "Prenom";
    public static final String Col_Moyenne_notes = "Moyenne_notes";
    //req de creation de la table
    private static final String SQLCreate_TablesEtudiants = "CREATE TABLE " +
            TABLE_PERSON + " ("
            + Col_CODE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Col_NOM + " TEXT NOT NULL, "
            + Col_Prenom + " TEXT NOT NULL, "
            + Col_Moyenne_notes + " FLOAT NOT NULL);";
    //
    private static final String SQLDeleteTablePersons = "DROP TABLE IF EXISTS " + TABLE_PERSON;

    ///////////////////
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(SQLCreate_TablesEtudiants);
            Log.e("message :", "table TABLE_PERSON is created with success");
        } catch (Exception ex) {
            Log.e("Creation Table Error", ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL(SQLDeleteTablePersons);
        onCreate(database);
    }

    void addPerson(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Col_NOM, person.getFirst_name());
        values.put(Col_Prenom, person.getLast_name());
        values.put(Col_Moyenne_notes, person.getNotes_average());

        // Inserting Row  
        db.insert(TABLE_PERSON, null, values);

        db.close(); // Closing database connection  
    }

    public List<Person> getAllPersons() {
        List<Person> personList = new ArrayList<Person>();
        // Select All Query  
        String selectQuery = "SELECT  * FROM " + TABLE_PERSON;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list  
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setCode(Integer.parseInt(cursor.getString(0)));
                person.setFirst_name(cursor.getString(1));
                person.setLast_name(cursor.getString(2));
                person.setNotes_average((int) cursor.getDouble(3));
                // Adding person to list  
                personList.add(person);
            } while (cursor.moveToNext());
            // return person list  

        }

        return personList;
    }
}

