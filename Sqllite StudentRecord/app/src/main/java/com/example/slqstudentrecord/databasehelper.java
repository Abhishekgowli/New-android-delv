package com.example.slqstudentrecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databasehelper extends SQLiteOpenHelper {


    public final static String DATABASE_NAME="Mystudent.db";
    public final static String TABLE_NAME="Mystudent_table";
    public final static String COL_1="ID";
    public final static String COL_2="NAME";
    public final static String COL_3="EMAIL";
    public final static String COL_4="COURSE_COUNT";

    public databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME+
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "EMAIL TEXT," +
                "COURSE_COUNT INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public boolean Insertdata(String name,String Email,String Course_count)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,Email);
        contentValues.put(COL_4,Course_count);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
          return  true;
        }


    }


    public boolean updatedata(String id,String name,String Email,String Course_count)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,Email);
        contentValues.put(COL_4,Course_count);
        db.update(TABLE_NAME,contentValues,"ID=?",new String[]{id});
        return true;


    }

    public Cursor getdata(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE ID='"+id+"'";
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public Integer deletedata(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID=?", new String[]{id});
    }

    public Cursor getalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cursor;
    }
}
