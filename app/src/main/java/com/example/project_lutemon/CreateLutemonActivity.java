package com.example.project_lutemon;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class CreateLutemonActivity extends AppCompatActivity {

    private EditText etName;
    private Spinner spinnerColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_lutemon);

        etName = findViewById(R.id.etName);
        spinnerColor = findViewById(R.id.spinnerColor);
        Button btnCreate = findViewById(R.id.btnCreateLutemon);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.colors_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerColor.setAdapter(adapter);

        btnCreate.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String color = spinnerColor.getSelectedItem().toString();
            Lutemon l = null;

            switch (color) {
                case "White": l = new WhiteLutemon(name); break;
                case "Green": l = new GreenLutemon(name); break;
                case "Pink": l = new PinkLutemon(name); break;
                case "Orange": l = new OrangeLutemon(name); break;
                case "Black": l = new BlackLutemon(name); break;
            }

            if (l != null) {
                Storage.getInstance().addToHome(l);
                Toast.makeText(this, name + " the " + color + " Lutemon created!", Toast.LENGTH_SHORT).show();
                finish(); // Go back to MainActivity
            }
        });
    }
}

