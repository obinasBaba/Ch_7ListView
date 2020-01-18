package com.hfad.ch_7listview;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class DrinkDetail extends AppCompatActivity {
    static final String sendMe = "";
    private static final String TAG = "DrinkDetail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_drink_detail );

        int index = getIntent().getIntExtra( sendMe, 0 ) + 1;

        StarbuzzDatabase starbuzzDatabase = new StarbuzzDatabase( this );
        try {
            SQLiteDatabase rdb = starbuzzDatabase.getReadableDatabase();
            Cursor cursorQuery = rdb.query( "drink", new String[]{"name", "description", "IMG_resource" }, "_id = ?",
                                            new String[]{String.valueOf( index )}, null, null, null );

            Log.d( TAG, "onCreate: empty : " + cursorQuery.moveToFirst() + " count : " + cursorQuery.getCount() + "index " + index );

            if ( cursorQuery.moveToFirst() ) {
                Log.d( TAG, "onCreate: two" );
                //Get reference
                ImageView imageView = findViewById( R.id.image );
                TextView title = findViewById( R.id.textTitle );
                TextView disc = findViewById( R.id.textDiscription );

                //set value from the cursor
                int img_ID = cursorQuery.getInt( 2 );
                String titleValue = cursorQuery.getString( 0 );
                String desc = cursorQuery.getString( 1 );

                //Fill the references
                imageView.setImageResource( img_ID );
                title.setText( titleValue );
                disc.setText( desc );
            }
            //Close both of them
            rdb.close();
            cursorQuery.close();

        } catch (Exception e) {
            Toast.makeText( this, "Database faild", Toast.LENGTH_SHORT ).show();
            Log.d( TAG, "onCreate: " + e );
        }

    }
}
