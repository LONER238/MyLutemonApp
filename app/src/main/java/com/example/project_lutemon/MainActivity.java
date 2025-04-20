package com.example.project_lutemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCreate = findViewById(R.id.btnCreate);
        Button btnTrain = findViewById(R.id.btnTrain);
        Button btnMove = findViewById(R.id.btnMove);
        Button btnBattle = findViewById(R.id.btnBattle);

        btnCreate.setOnClickListener(v -> startActivity(new Intent(this, CreateLutemonActivity.class)));
        btnTrain.setOnClickListener(v -> startActivity(new Intent(this, TrainLutemonActivity.class)));
        btnMove.setOnClickListener(v -> startActivity(new Intent(this, MoveLutemonActivity.class)));
        btnBattle.setOnClickListener(v -> startActivity(new Intent(this, BattleActivity.class)));
    }
}