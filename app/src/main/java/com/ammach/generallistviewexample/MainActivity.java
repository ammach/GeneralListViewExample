package com.ammach.generallistviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    CountriesAdapter countriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.listView);
        countriesAdapter=new CountriesAdapter(this,getData(),R.layout.row);
        listView.setAdapter(countriesAdapter);
    }

    private List<Country> getData() {
        List<Country> countries=new ArrayList<>();
        countries.add(new Country("MAROC"));
        countries.add(new Country("FRANCE"));
        countries.add(new Country("USA"));
        countries.add(new Country("ESPAGNE"));
        return countries;
    }
}
