package com.example.reemaaziry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextTextEmailAddress, editTextTextPassword;
    private Button  btnRegister ,btnCancel;
    private Button buttonLogin, buttonRegister;
    private TextView tvSignup, tvWelcome;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);

        btnRegister = findViewById(R.id.buttonRegister);
        btnCancel = findViewById(R.id.btnCancel);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);

        preferences = getSharedPreferences("Userinfo", 0);

    }
    public void register(View view) {
        Intent i_register = new Intent(this, RegisterActivity.class);
        startActivity(i_register);
    }

    public void login(View view) {
        //this line gets registered email and password, in case no user was registered empty string is returned
        String input_mail = editTextTextEmailAddress.getText().toString();
        String input_password = editTextTextPassword.getText().toString();

        String registeredMail = preferences.getString("username", "");
        String registeredPassword = preferences.getString("password", "");

        if (input_mail.equals(registeredMail)&& input_password.equals(registeredPassword)){
            Intent i_mail = new Intent(this, exhomeactivity.class);
            startActivity(i_mail);
        }
        else {
            Toast.makeText(this, "Incorrect credentials!", Toast.LENGTH_SHORT).show();
        }

//        if(editTextTextEmailAddress.getText().toString().equals(""))
//            Toast.makeText(this,"Empty Email", Toast.LENGTH_LONG).show();
//        else
//        {
//            Intent i = new Intent(this, homeactivity.class);
//            startActivity(i);
//        }
//        if (editTextTextPassword.getText().toString().equals(""))
//            Toast.makeText(this,"Empty Password", Toast.LENGTH_LONG).show();
//        else
//        {
//            Intent i = new Intent(this, homeactivity.class);
//            startActivity(i);
//        }
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
            case R.id.setting_menu:{
                Toast.makeText(MainActivity.this,"settings clicked",Toast.LENGTH_LONG).show();
                break;}
            case R.id.about_menu:{
                Toast.makeText(MainActivity.this,"about clicked",Toast.LENGTH_LONG).show();
                Intent a = new Intent(this, Aboutactivity.class);
                startActivity(a);
                break;}
            case R.id.help_menu:{
                Toast.makeText(MainActivity.this,"help clicked",Toast.LENGTH_LONG).show();
                Intent h = new Intent(this, helpactivity.class);
                startActivity(h);
                break;}
            case R.id.logout_menu:{
                Toast.makeText(MainActivity.this,"logout clicked",Toast.LENGTH_LONG).show();
                break;}
            case R.id.list_menu:{
                Toast.makeText(MainActivity.this,"list clicked",Toast.LENGTH_LONG).show();
                Intent m = new Intent(this, Listactivity.class);
                startActivity(m);
                break;}
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
                MainActivity.this.finish();
            }
        });
        dialog.setIcon(R.drawable.ic_baseline_sentiment_very_dissatisfied_24);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }


}