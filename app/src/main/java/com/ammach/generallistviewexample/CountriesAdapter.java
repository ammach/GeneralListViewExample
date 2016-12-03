package com.ammach.generallistviewexample;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import adapters.GeneralAdapter;

/**
 * Created by ammach on 12/3/2016.
 */
public class CountriesAdapter extends GeneralAdapter<Country> {

    public CountriesAdapter(Context context, List<Country> data,int layout) {
        super(context, data,layout);
    }

    @Override
    public void performView(View view, Country country) {
        TextView textView= (TextView) view.findViewById(R.id.txt);
        textView.setText(country.getName());
    }
}
