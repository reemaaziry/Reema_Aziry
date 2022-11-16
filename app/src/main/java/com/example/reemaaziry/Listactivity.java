package com.example.reemaaziry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        //connect adapter to array
        ListView.setAdapter(arrayAdapter);

        //handle items clicks
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Listactivity.this, "clicked item" + i + " " + arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
        //load option menu from an activity
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu,menu);
            return true;
        }
        //handle options new click events
        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.setting_menu:
                    Toast.makeText(Listactivity.this,"settings clicked",Toast.LENGTH_LONG).show();
                    break;
                case R.id.about_menu:
                    Toast.makeText(Listactivity.this,"about clicked",Toast.LENGTH_LONG).show();
                    Intent a = new Intent(this, Aboutactivity.class);
                    startActivity(a);
                    break;
                case R.id.help_menu:
                    Toast.makeText(Listactivity.this,"help clicked",Toast.LENGTH_LONG).show();
                    Intent h = new Intent(this, helpactivity.class);
                    startActivity(h);
                    break;
                case R.id.logout_menu:
                    Toast.makeText(Listactivity.this,"logout clicked",Toast.LENGTH_LONG).show();
                    break;
                case R.id.list_menu:{
                    Toast.makeText(Listactivity.this,"list clicked",Toast.LENGTH_LONG).show();
                    Intent m = new Intent(this, Listactivity.class);
                    startActivity(m);
                    break;}
            }
            return true;
    }
}