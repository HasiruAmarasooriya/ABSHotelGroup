package com.example.abshotelgroup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    //initialize variable
    private static final int VERSION= 4;
    private static final String DBNAME= "abs_hotel_group";
    private static final String TABLE1= "users";
    private static final String TABLE2= "room_packages";
    private static final String TABLE3= "vehicle_packages";
    private static final String TABLE4= "feedback";


    public DBHelper(Context context) {
        super(context, DBNAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase  MyDB) {

        //Create Tables

        String users = "create Table users(username TEXT PRIMARY KEY ,email TEXT,password TEXT)";


        MyDB.execSQL(users);


    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {

        //Drop Existing Table

        MyDB.execSQL(" DROP TABLE IF EXISTS " +TABLE1);

        onCreate(MyDB);

    }

    //Create Insert method

    public Boolean insertData(String username,String email,String password){

        //Get Writeable Database
        SQLiteDatabase MyDB = this.getWritableDatabase();

        //Create ContentValues

        ContentValues contentValues1 = new ContentValues();
        contentValues1.put("username",username);
        contentValues1.put("email",email);
        contentValues1.put("password",password);

        //Insert Data into Database

        long result = MyDB.insert(TABLE1,null,contentValues1);


        if (result==-1) {
            return false;
        }
        else {
            return true;
        }


    }

    public Boolean checkusername(String username){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username = ?",new String[] {username});
        if (cursor.getCount()>0) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username = ? and password = ?",new String[] {username,password});
        if (cursor.getCount()>0) {
            return true;
        }
        else {
            return false;
        }
    }





}
