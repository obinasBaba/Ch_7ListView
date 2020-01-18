package com.hfad.ch_7listview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StarbuzzDatabase extends SQLiteOpenHelper {

    private static final int DB_VERSION = 2;
    private static final String DB_NAME = "starBuzz";

    StarbuzzDatabase(Context ctx) {
        super( ctx, DB_NAME, null, DB_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDB( db, 0, 1 );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDB( db, 0, 1 );
    }

    private void insertDrink(SQLiteDatabase db, String name, String des, int resID) {
        ContentValues contentValues = new ContentValues();
        contentValues.put( "name", name );
        contentValues.put( "description", des );
        contentValues.put( "IMG_resource", resID );
        db.insert( "drink", null, contentValues );
    }

    private void updateMyDB( SQLiteDatabase db, int oldVersion, int newVirsion ){
        if ( oldVersion < 1 )
        {
            db.execSQL( "CREATE TABLE drink ( _id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                                "name TEXT,  " +
                                "description TEXT," +
                                "IMG_resource INTEGER" +
                                " );" );

            insertDrink( db, "Latte", "Espresso and Streamed Milk", R.drawable.latte );
            insertDrink( db, "Cappuccino", "Espresso, hot milk and steamed-milk foam", R.drawable.cappuccino );
            insertDrink( db, "Filter", "Our best drip coffee", R.drawable.filter );

        }else if ( oldVersion < 2 )
            db.execSQL( "ALTER TABLE drink ADD COLUMN favorite NUMERIC;" );
    }
}
