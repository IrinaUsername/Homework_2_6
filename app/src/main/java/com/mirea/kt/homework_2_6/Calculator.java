package com.mirea.kt.homework_2_6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        EditText editTextFirst = findViewById(R.id.firstNum);
        EditText editTextSecond = findViewById(R.id.secondNum);
        EditText editTextThird = findViewById(R.id.thirdNum);
        Button bthCalc = findViewById(R.id.result);
        bthCalc.setOnClickListener(v -> {
            String firstTermStr = editTextFirst.getText().toString();
            String secondTermStr = editTextSecond.getText().toString();
            String thirdTermStr = editTextThird.getText().toString();
            if(!firstTermStr.isEmpty() && !secondTermStr.isEmpty() && !thirdTermStr.isEmpty()) {
                int result = Integer.parseInt(firstTermStr) * Integer.parseInt(secondTermStr) * Integer.parseInt(thirdTermStr);
                Intent intent = new Intent();
                intent.putExtra("data", result);
                setResult(RESULT_OK, intent);
                finish();
            }else{
                Toast.makeText(getApplicationContext(),"Ошибка ввода",Toast.LENGTH_LONG).show();
            }


        });

    }
}