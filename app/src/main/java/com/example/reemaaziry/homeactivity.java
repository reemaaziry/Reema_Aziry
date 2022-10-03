package com.example.reemaaziry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class homeactivity extends AppCompatActivity {
    EditText editTextNumber1, editTextNumber2;
    Button plus, minus;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);

        textViewResult = findViewById(R.id.textViewResult);
    }

    public void plus(View view) {
        double number1 = Double.parseDouble(editTextNumber1.getText().toString());
        double number2 = Double.parseDouble(editTextNumber2.getText().toString());

        textViewResult.setText((number1+number2)+"");

        if(editTextNumber1.getText().toString().equals(""))
            Toast.makeText(this,"Empty Number1", Toast.LENGTH_LONG).show();
    }

    public void minus(View view) {
        double number1 = Double.parseDouble(editTextNumber1.getText().toString());
        double number2 = Double.parseDouble(editTextNumber2.getText().toString());

        textViewResult.setText((number1-number2)+"");

        if(editTextNumber2.getText().toString().equals(""))
            Toast.makeText(this,"Empty Number2", Toast.LENGTH_LONG).show();
    }
}