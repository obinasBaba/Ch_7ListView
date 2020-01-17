package com.hfad.ch_7listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.PreparedStatement;
import java.util.Objects;

public class DrinkDetail extends AppCompatActivity
{
    static final String  sendMe = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_drink_detail );

        int index = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            index = getIntent().getIntExtra( sendMe, 0 );
        }

        Drinks drinks = Drinks.drinks[ index ];


        ImageView imageView = findViewById( R.id.image );
        TextView title = findViewById( R.id.textTitle );
        TextView disc = findViewById( R.id.textDiscription );


        imageView.setImageResource( drinks.getImageResourceID() );
        title.setText( drinks.toString() );
        disc.setText( drinks.getDisc() );
    }





}
