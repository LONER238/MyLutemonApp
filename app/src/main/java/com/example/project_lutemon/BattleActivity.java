package com.example.project_lutemon;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {

    private Spinner spinnerA, spinnerB;
    private TextView txtBattleLog;
    private Button btnStartBattle;
    private ArrayList<Lutemon> arenaLutemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        spinnerA = findViewById(R.id.spinnerA);
        spinnerB = findViewById(R.id.spinnerB);
        btnStartBattle = findViewById(R.id.btnStartBattle);
        txtBattleLog = findViewById(R.id.txtBattleLog);

        arenaLutemons = Storage.getInstance().getArena();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, getLutemonNames(arenaLutemons));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerA.setAdapter(adapter);
        spinnerB.setAdapter(adapter);

        btnStartBattle.setOnClickListener(v -> {
            int indexA = spinnerA.getSelectedItemPosition();
            int indexB = spinnerB.getSelectedItemPosition();

            if (indexA == indexB) {
                Toast.makeText(this, "Select two different Lutemons!", Toast.LENGTH_SHORT).show();
                return;
            }

            Lutemon lutemonA = arenaLutemons.get(indexA);
            Lutemon lutemonB = arenaLutemons.get(indexB);

            Battle battle = new Battle();
            String result = battle.fight(lutemonA, lutemonB);
            txtBattleLog.setText(result);

            // Handle the winner and loser
            if (!lutemonA.isAlive()) {
                Storage.getInstance().getArena().remove(lutemonA);
            } else if (!lutemonB.isAlive()) {
                Storage.getInstance().getArena().remove(lutemonB);
            }
        });
    }

    private ArrayList<String> getLutemonNames(ArrayList<Lutemon> list) {
        ArrayList<String> names = new ArrayList<>();
        for (Lutemon l : list) {
            names.add(l.getStats());
        }
        return names;
    }
}

