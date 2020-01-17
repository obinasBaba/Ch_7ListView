package com.hfad.ch_7listview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FoodsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FoodsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public FoodsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FoodsFragment newInstance( ) {
        FoodsFragment fragment = new FoodsFragment();
        Bundle args = new Bundle();

        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_foods, container, false );
    }


}
