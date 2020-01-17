package com.hfad.ch_7listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DrinkCatagoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_drink_catagory );


        ArrayAdapter< Drinks > aa = new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, Drinks.drinks );
        ListView cListView = findViewById( R.id.catagoryListView );
//        ArrayAdapter< Drinks > ld = new customLayout( this);
        cListView.setAdapter( aa );

        AdapterView.OnItemClickListener listen  =  new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent( DrinkCatagoryActivity.this, DrinkDetail.class );
                intent.putExtra( DrinkDetail.sendMe, id );
                startActivity( intent );
            }};

        cListView.setOnItemClickListener( listen );


    }

    private class customLayout extends ArrayAdapter< Drinks >
    {

        customLayout(Activity context) {
            super(context, R.layout.catagorylayout );
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
            ImageView imageView =  convertView.findViewById( R.id.imageViewRow );
            TextView title = convertView.findViewById( R.id.textviewForTitle );
            TextView disc = convertView.findViewById( R.id.textViewForDisc );

            imageView.setImageResource( Drinks.drinks[position].getImageResourceID() );
            title.setText( Drinks.drinks[position].toString() );
            disc.setText( Drinks.drinks[position].getDisc() );

            return convertView;
        }


    }
}
