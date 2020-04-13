package com.example.baitung;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.baitung.Restaurant;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {
    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        TaoBang();
    }

    public static String nametb="Restaurant";
    public void SQLdata(String sql){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor Sqlgetdata(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return  database.rawQuery(sql,null);
    }

    public void TaoBang(){
        String sql="Create table if not exists "+ nametb +" ("+
                " ma nvarchar(50) primary key, "+
                " ten nvarcar(250), "+
                " diachi nvarchar(250), "+
                " diem double)";
        SQLdata(sql);
    }

    public void Them(Restaurant r){
        String sql="insert into " +nametb +" values ('"+r.getMa()+"',"
                +"'"+r.getTen()+"',"+
                "'"+r.getDc()+"',"+
                r.getDiem()+")";
        SQLdata(sql);
    }



    public void Xoa(String ma){
        String sql="delete from "+nametb+" where ma='"+ma+"'";
        SQLdata(sql);
    }

    public ArrayList<Restaurant> Getalldata(){
        String sql="select * from "+nametb;
        ArrayList<Restaurant> list= new ArrayList<>();
        Cursor cursor= Sqlgetdata(sql);
        while(cursor.moveToNext()){
            String ma=cursor.getString(0);
            String ten=cursor.getString(1);
            String diachi=cursor.getString(2);
            double diem=cursor.getDouble(3);
            list.add(new Restaurant(ma,ten,diachi,diem));
        }
        return list;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
