package com.example.reemaaziry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

    //is called when the user clicks the back button
    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Back Button was pressed!");
        dialog.setMessage("Are you sure you want to exit?");
        //in case the user chose No, nothing happens, the dialog closes
        dialog.setNegativeButton("No",null);
        //when the user clicks on the Yes button the application closes
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                helpactivity.this.finish();
            }
        });
        dialog.setIcon(R.drawable.ic_baseline_sentiment_very_dissatisfied_24);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }
}