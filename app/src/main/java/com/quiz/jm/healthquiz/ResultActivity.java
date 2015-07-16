package com.quiz.jm.healthquiz;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.plus.PlusShare;

/**
 * Created by MAX on 15/07/2015.
 */
public class ResultActivity extends Activity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        context = getApplicationContext();
        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView t=(TextView)findViewById(R.id.txtResu);
        //get score
        Bundle b = getIntent().getExtras();
        final int score= b.getInt("score");
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

        Button shareButton = (Button) findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Lancer la boîte de dialogue de partage Google+ avec attribution à votre application.
                Intent shareIntent = new PlusShare.Builder(getApplicationContext())
                        .setType("text/plain")
                        .setText("J'ai eu " + score + "/5 sur HealthQuiz")
                        .setContentUrl(Uri.parse("https://developers.google.com/+/"))
                        .getIntent();

                startActivityForResult(shareIntent, 0);

            }
        });
    }



}
