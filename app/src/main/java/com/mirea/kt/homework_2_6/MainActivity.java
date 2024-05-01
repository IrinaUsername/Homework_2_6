package com.mirea.kt.homework_2_6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonStart;
    private TextView textValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        buttonStart = findViewById(R.id.startProgram);
        textValue = findViewById(R.id.welcome);
        buttonStart.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.startProgram){
            Intent intent = new Intent(this,Calculator.class);
            startActivityForResult(intent,12345);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 12345){
            if(data !=null){
                int res = data.getIntExtra("data",0);
                Log.d("simple_app_tag","Result: "+res);
                textValue.setText("Произведение чисел: "+res);
                buttonStart.setText("Продолжить");

            }
        }
    }
}