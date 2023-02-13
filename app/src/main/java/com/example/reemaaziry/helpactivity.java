package com.example.reemaaziry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class helpactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpactivity);
    }
//this method loads yhe menu  design into this activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.camera_menu)
            Toast.makeText(helpactivity.this,"camera clicked",Toast.LENGTH_LONG).show();
            Intent c = new Intent(this, CameraActivity.class);
            startActivity(c);
        if(item.getItemId()==R.id.about_menu) {
            Toast.makeText(helpactivity.this,"about clicked",Toast.LENGTH_LONG).show();
            Intent a = new Intent(this, Aboutactivity.class);
            startActivity(a);}
        if(item.getItemId()==R.id.help_menu)
            Toast.makeText(helpactivity.this,"help clicked",Toast.LENGTH_LONG).show();
        if(item.getItemId()==R.id.logout_menu)
            Toast.makeText(helpactivity.this,"logout clicked",Toast.LENGTH_LONG).show();
        if(item.getItemId()==R.id.list_menu)
            Toast.makeText(helpactivity.this,"list clicked",Toast.LENGTH_LONG).show();
            Intent m = new Intent(this, Listactivity.class);
            startActivity(m);
        return true;
    }
}