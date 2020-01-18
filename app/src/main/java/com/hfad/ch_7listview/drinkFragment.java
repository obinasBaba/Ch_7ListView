package com.hfad.ch_7listview;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class drinkFragment extends Fragment {

    private static final String PAGE = "";
    private TextView tv;
    private ListView listView;
    private SQLiteDatabase rdb;


     static drinkFragment getInstance(int page) {
        drinkFragment thisFrag = new drinkFragment();
        Bundle bundle = new Bundle();
        bundle.putInt( PAGE, page );
        thisFrag.setArguments( bundle );
        return thisFrag;
    }

    public drinkFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        StarbuzzDatabase starbuzzDatabase = new StarbuzzDatabase( getContext() );
        rdb = starbuzzDatabase.getReadableDatabase();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate( R.layout.fragment_blank, container, false );
                //TextView at the top
        TextView tv = root.findViewById( R.id.textView_ID );
        tv.setText( String.format( Locale.getDefault(), "frag %d", getArguments().getInt( PAGE ) ) );

        ListView listView = root.findViewById( R.id.theList );
        listView.setAdapter( new customLayout2( getContext() ) );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent( getContext(), DrinkDetail.class );
                intent.putExtra( DrinkDetail.sendMe, position );
                startActivity( intent );
            }
        } );
        return root;
    }

    private class customLayout2 extends ArrayAdapter<Drinks> {
        customLayout2(Context context) {
            super( context, R.layout.catagorylayout, Drinks.drinks );
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null)
                convertView = LayoutInflater.from( getContext() )
                        .inflate( R.layout.catagorylayout, parent, false );

            ImageView imageView = convertView.findViewById( R.id.imageViewRow );
            TextView title = convertView.findViewById( R.id.textviewForTitle );

            imageView.setImageResource( Drinks.drinks[position].getImageResourceID() );
            title.setText( Drinks.drinks[position].toString() );
            return convertView;
        }

        @Override
        public int getCount() {
            return Drinks.drinks.length;
        }
    }

}
