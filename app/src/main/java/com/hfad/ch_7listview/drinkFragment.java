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

    public static drinkFragment getInstance(int page) {
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
        assert getArguments() != null;
        tv = root.findViewById( R.id.textView_ID );
        tv.setText( String.format( Locale.getDefault(), "frag %d", getArguments().getInt( PAGE ) ) );

        listView = root.findViewById( R.id.theList );
        listView.setAdapter( new customLayout( getActivity(), Drinks.drinks ) );

        AdapterView.OnItemClickListener listen = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent( getContext(), DrinkDetail.class );
                intent.putExtra( DrinkDetail.sendMe, id );
                startActivity( intent );
            }
        };

        listView.setOnItemClickListener( listen );


        return root;
    }

    private class customLayout extends ArrayAdapter<Drinks> {
        customLayout(Context context, Drinks[] drinks) {
            super( context, R.layout.catagorylayout, drinks );
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null)
                convertView = LayoutInflater.from( parent.getContext() ).inflate( R.layout.listview_custom, parent, false );

            try {
                CheckedTextView ctv = convertView.findViewById( R.id.text1 );
                ctv.setText( getItem( position ).toString() );
                if ((position % 2) == 0) ctv.setChecked( true );

            } catch (Exception e) {
                e.printStackTrace();
            }
            return convertView;
        }

        @Override
        public int getCount() {
            return Drinks.drinks.length;
        }
    }

}
