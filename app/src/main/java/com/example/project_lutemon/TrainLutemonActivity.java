package com.example.project_lutemon;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class TrainLutemonActivity extends AppCompatActivity {

    private LinearLayout trainingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_lutemon);

        trainingList = findViewById(R.id.trainingList);

        ArrayList<Lutemon> trainingLutemons = Storage.getInstance().getTraining();

        for (Lutemon l : trainingLutemons) {
            View item = getLayoutInflater().inflate(R.layout.item_train_lutemon, null);

            TextView txtInfo = item.findViewById(R.id.txtLutemonInfo);
            Button btnTrain = item.findViewById(R.id.btnTrainLutemon);

            txtInfo.setText(l.getStats());

            btnTrain.setOnClickListener(v -> {
                l.train();
                txtInfo.setText(l.getStats());
                Toast.makeText(this, l.getName() + " trained! +1 XP", Toast.LENGTH_SHORT).show();
            });

            trainingList.addView(item);
        }
    }
}


