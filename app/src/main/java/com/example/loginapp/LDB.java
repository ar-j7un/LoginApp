package com.example.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class LDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="DMS";

    public LDB(Context context)
    {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE login(uname text primary key, pass text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS login ");
        onCreate(db);
    }

    public void addUser(String uname, String ps)
    {
        try
        {
            SQLiteDatabase db= this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("uname",uname);
            cv.put("pass",ps);
            db.insert("login",null,cv);
            db.close();

        }
        catch(Exception e)
        {
            System.out.println("Error : "+e);
            Log.d("INSERT",e.toString());

        }
    }

    public String[] getUser(String un, String ps)
    {
        String a[]= new String [2];

        try
        {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("login",new String[]{"uname","pass"},"uname"+"=?",new String[]{
                    String.valueOf(un)},null,null,null,null);

            if(cursor !=null && cursor.getCount()!=0)
            {
                cursor.moveToFirst();
                a[0]=cursor.getString(0);
                a[1]=cursor.getString(1);
            }
            else
            {
                a[0]="";
                a[1]="";
            }

        }
        catch(Exception e)
        {

            System.out.println("Error : "+e);
            Log.d("CHECK",e.toString());

        }
        return a;



    }

    public boolean CheckPass(String un, String op)
    {

        String a[]= new String [2];

        try
        {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("login",new String[]{"uname","pass"},"uname"+"=?",new String[]{
                    String.valueOf(un)},null,null,null,null);

            if(cursor !=null && cursor.getCount()!=0)
            {
                cursor.moveToFirst();
                a[0]=cursor.getString(1);

            }

            if(a[0].equals(op))
            {
                return true;
            }
            else
            {
                return false;
            }



        }
        catch(Exception e)
        {

            System.out.println("Error : "+e);
            Log.d("CHECK",e.toString());

        }
        return false;
    }


    public void ChangePass( String un, String ps)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("pass",ps);
        db.update("login",values, "uname= ?",new String[] { String.valueOf(un)});
        db.close();

    }


}
