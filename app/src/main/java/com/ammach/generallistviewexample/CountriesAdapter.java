package com.ammach.generallistviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import adapters.GeneralAdapter;

/**
 * Created by ammach on 12/3/2016.
 */
public class CountriesAdapter extends GeneralAdapter<Country> {

    List<Country> countries;

    public CountriesAdapter(Context context, List<Country> data,int layoutRow,int layoutBottom , Activity activity) {
        super(context, data,layoutRow,layoutBottom,activity);
        this.countries=data;
    }

    @Override
    public void performView(View view, Country country) {
        TextView textView= (TextView) view.findViewById(R.id.txt);
        textView.setText(country.getName());
    }

    @Override
    protected void updateListView() {
        for (int i = 0; i < 3; i++) {
            countries.add(new Country("rabat"));
        }
    }
}
