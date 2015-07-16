package com.quiz.jm.healthquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //listener pour clic sur bouton jouer (démarre l'activité de jeu)
        Button btJouer = ((Button) findViewById(R.id.btJouer));
        btJouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), QuestionActivty.class);
                startActivity(intent);
            }
        });
    }
}
