package com.example.reemaaziry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Listactivity extends AppCompatActivity {

    ListView ListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listactivity);

        ListView = (ListView) findViewById(R.id.ListView);

        //make an array list
        ArrayList<String> arrayList = new ArrayList<>();

        //add items to arrayList
        arrayList.add("Books");
        arrayList.add("Movies");
        arrayList.add("Celebrities");
        arrayList.add("Food");
        arrayList.add("Fashion");
        arrayList.add("Events");
        arrayList.add("School");
        arrayList.add("Work");

        //initialize the adapter
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        //connect adapter to array
        ListView.setAdapter(arrayAdapter);

        //handle items clicks
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Listactivity.this, "clicked item"+i+" "+ arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}