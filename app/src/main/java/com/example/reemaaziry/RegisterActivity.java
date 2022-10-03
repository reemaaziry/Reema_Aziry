package com.example.reemaaziry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextTextEmailAddress, editTextTextPassword;
    private Button btnRegister, btnCancel;
    private TextView tvWelcome;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnCancel = findViewById(R.id.btnCancel);

        preferences = getSharedPreferences("Userinfo", 0);
    }
    public void register (View view) {
        String input_mail = editTextTextEmailAddress.getText().toString();
        String input_password = editTextTextPassword.getText().toString();
        if(input_mail.length()>0){
            //open preference file
            SharedPreferences.Editor editor = preferences.edit();
            //save key, value data
            editor.putString("username", input_mail);
            editor.putString("password",input_password);

            editor.apply();
            Toast.makeText(this, "User registered!", Toast.LENGTH_SHORT).show();
            Intent intent_main = new Intent(this, MainActivity.class);
            startActivity(intent_main);
        }
        else{
            Toast.makeText(this, "Empty value, please insert!", Toast.LENGTH_SHORT).show();
        }
    }
    public void cancel(View view){
        Intent intent_main = new Intent(this, MainActivity.class);
        startActivity(intent_main);
    }
}