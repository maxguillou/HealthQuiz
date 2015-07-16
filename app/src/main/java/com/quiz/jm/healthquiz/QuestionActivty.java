package com.quiz.jm.healthquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.quiz.jm.healthquiz.metier.DbHelper;
import com.quiz.jm.healthquiz.metier.Question;
import com.quiz.jm.healthquiz.metier.QuestionController;

import java.util.List;

public class QuestionActivty extends Activity {
    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        DbHelper db=new DbHelper(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion = ((TextView) findViewById(R.id.txtQuestion));
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        btNext=(Button)findViewById(R.id.btNext);
        setQuestionView();
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("myTagg", String.valueOf(R.id.radio0));
                Log.d("myTagg", String.valueOf(grp.getCheckedRadioButtonId()));

                if(grp.getCheckedRadioButtonId() == -1){
                    CharSequence text = "Aucune réponse sélectionnée";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                    toast.show();
                }else{
                    Log.d("myTagg", currentQ.getANSWER() + " " + answer.getText());
                    if(currentQ.getANSWER().equals(answer.getText()))
                    {
                        score++;
                        Log.d("score", "Your score"+score);
                    }
                    if(qid<5){
                        currentQ=quesList.get(qid);
                        setQuestionView();
                    }else{
                        Intent intent = new Intent(QuestionActivty.this, ResultActivity.class);
                        Bundle b = new Bundle();
                        b.putInt("score", score); //Your score
                        intent.putExtras(b); //Put your score to your next Intent
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }

    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }


}
