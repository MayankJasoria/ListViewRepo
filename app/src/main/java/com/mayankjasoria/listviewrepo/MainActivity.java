package com.mayankjasoria.listviewrepo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list_view);

        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("second test");
        list.add("Okay, get serious");
        list.add("fourth element");
        list.add("fifth element");

        ListViewAdapter adapter = new ListViewAdapter(this, 0, list);
        listView.setAdapter(adapter);

    }
}
