package com.quiz.jm.healthquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by MAX on 15/07/2015.
 */
public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView t=(TextView)findViewById(R.id.txtResu);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        //display score
        bar.setRating(score);
        switch (score)
        {
            case 1:
            case 2: t.setText("Ooops c'est mauvais");
                break;
            case 3:
            case 4:t.setText("Hmmmm.. Moyen, moyen...");
                break;
            case 5:t.setText("Yeah KFC so gooOOood");
                break;
        }
        findViewById(R.id.btAccueil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
