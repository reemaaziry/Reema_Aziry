package com.example.reemaaziry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextTextEmailAddress, editTextTextPassword;
    private Button btnRegister, btnCancel;
    private TextView tvWelcome;

    SharedPreferences preferences;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        //code starts here
        //connect between java class and XML componens

        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnCancel = findViewById(R.id.btnCancel);

        preferences = getSharedPreferences("Userinfo", 0);
    }

    public void signup(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("REEMA", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //from sign up page to sign in page

                            Intent i_mail = new Intent(RegisterActivity.this, BottomNavigation.class);
                            startActivity(i_mail);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("REEMA", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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

            signup(input_mail, input_password);
//            Intent intent_main = new Intent(this, MainActivity.class);
//            startActivity(intent_main);
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