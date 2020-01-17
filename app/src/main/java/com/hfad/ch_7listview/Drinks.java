package com.hfad.ch_7listview;


public class Drinks
{
    private String name;
    private String disc;
    private int imageResourceID;

    private Drinks(String name, String disc, int ID ){
        this.name = name;
        this.disc = disc;
        imageResourceID = ID;
    }

      final static Drinks[] drinks = new Drinks[]
            {
                new Drinks( "Cappuccino", "A couple of espresso shots with steamed milk", R.drawable.cappuccino ),
                new Drinks( "Filter", "Espresso, hot milk, and a steamed milk foam",R.drawable.filter ),
                new Drinks( "Latte", "Highest quality beans roasted and brewed fresh", R.drawable.latte)
            };

     private String getName() {
        return name;
    }

     String getDisc() {
        return disc;
    }

     int getImageResourceID() {
        return imageResourceID;
    }

    @Override
    public String toString() {
        return getName();
    }
}
