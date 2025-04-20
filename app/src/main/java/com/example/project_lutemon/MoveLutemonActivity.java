package com.example.project_lutemon;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MoveLutemonActivity extends AppCompatActivity {

    private LinearLayout homeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_lutemon);

        homeList = findViewById(R.id.homeList);

        ArrayList<Lutemon> homeLutemons = Storage.getInstance().getHome();

        for (Lutemon l : new ArrayList<>(homeLutemons)) {
            View item = getLayoutInflater().inflate(R.layout.item_move_lutemon, null);

            TextView txtInfo = item.findViewById(R.id.txtMoveLutemonInfo);
            Button btnToTraining = item.findViewById(R.id.btnToTraining);
            Button btnToArena = item.findViewById(R.id.btnToArena);

            txtInfo.setText(l.getStats());

            btnToTraining.setOnClickListener(v -> {
                Storage.getInstance().moveToTraining(l);
                homeList.removeView(item);
                Toast.makeText(this, l.getName() + " moved to Training!", Toast.LENGTH_SHORT).show();
            });

            btnToArena.setOnClickListener(v -> {
                Storage.getInstance().moveToArena(l);
                homeList.removeView(item);
                Toast.makeText(this, l.getName() + " moved to Arena!", Toast.LENGTH_SHORT).show();
            });

            homeList.addView(item);
        }
    }
}



