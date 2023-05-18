package com.example.blankactivity.localdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mydatabase";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        SQLiteDatabase db = this.getWritableDatabase();
//        onCreate(db);

    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE " + "MyTable" + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT, address TEXT)";
        db.execSQL(create_table);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);

    }


    void addData(Integer id,String name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
//        values.put("id", id); // Contact Name
        values.put("name", name); // Contact Name
        values.put("address", address); // Contact Phone

        db.insert("MyTable", null, values);
        db.close(); // Closing database connection
    }

    public Cursor getAllData() {
        // Select All Query
        String selectQuery = "SELECT  * FROM " + "MyTable";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                System.out.println(cursor.getString(0));
                System.out.println(cursor.getString(1));

            } while (cursor.moveToNext());
        }

        // return contact list
        return cursor;
    }

    Cursor getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("MyTable", new String[] { "id",
                        "name", "address" }, "id" + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        System.out.println(cursor.getString(0));
        System.out.println(cursor.getString(1));
        System.out.println(cursor.getString(2));
        return cursor;
    }

    public int update() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", "NewName");
        contentValues.put("address", "NewAddress");
        int i = db.update("MyTable", contentValues, "id" + " = " + "1", null);
        System.out.println(i);
        return i;
    }

    public void delete() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("MyTable", "id" + "=" + "2", null);
    }
}