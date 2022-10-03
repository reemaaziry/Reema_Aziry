package com.example.reemaaziry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class Aboutactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutactivity);
    }
    //handle options new click events
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting_menu:
                Toast.makeText(Aboutactivity.this,"settings clicked",Toast.LENGTH_LONG);
                break;
            case R.id.about_menu:
                Toast.makeText(Aboutactivity.this,"about clicked",Toast.LENGTH_LONG);
                Intent a = new Intent(this, Aboutactivity.class);
                startActivity(a);
                break;
            case R.id.help_menu:
                Toast.makeText(Aboutactivity.this,"help clicked",Toast.LENGTH_LONG);
                Intent h = new Intent(this, helpactivity.class);
                startActivity(h);
                break;
            case R.id.logout_menu:
                Toast.makeText(Aboutactivity.this,"logout clicked",Toast.LENGTH_LONG);
        }
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
                Aboutactivity.this.finish();
            }
        });
        dialog.setIcon(R.drawable.ic_baseline_sentiment_very_dissatisfied_24);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }
}