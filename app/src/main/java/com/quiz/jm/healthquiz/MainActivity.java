package com.quiz.jm.healthquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.api.GoogleApiClient;
import com.quiz.jm.healthquiz.metier.Global;

public class MainActivity extends Activity{

    private GoogleApiClient mGoogleApiClient = Global.mGoogleApiClient;

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

        findViewById(R.id.btDeco).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (mGoogleApiClient.isConnected()) {
                        mGoogleApiClient.clearDefaultAccountAndReconnect();
                        mGoogleApiClient.disconnect();
                        mGoogleApiClient.connect();
                    }
                    //return true;
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
