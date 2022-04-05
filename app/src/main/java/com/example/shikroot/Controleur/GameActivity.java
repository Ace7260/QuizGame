package com.example.shikroot.Controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shikroot.Model.QuestionBank;
import com.example.shikroot.R;

import java.util.Arrays;
import com.example.shikroot.Model.*;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView Name;
    private TextView Quiz;
    private Button id_exit;
    private Button Answer1;
    private Button Answer2;
    private Button Answer3;
    private Button Answer4;
    private QuestionBank mQuestionBank=generateQuestionBank();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Name=findViewById(R.id.name);
        Quiz=findViewById(R.id.game_activity_textview_question);
        Answer1=findViewById(R.id.game_activity_button_1);
        Answer2=findViewById(R.id.game_activity_button_2);
        Answer3=findViewById(R.id.game_activity_button_3);
        Answer4=findViewById(R.id.game_activity_button_4);
        id_exit=findViewById(R.id.id_exit);
        id_exit.setOnClickListener(this);

        Answer1.setOnClickListener(this);
        Answer2.setOnClickListener(this);
        Answer4.setOnClickListener(this);
        Answer3.setOnClickListener(this);
        displayQuestion(mQuestionBank.getCurrentQuestion());
    }
   private void displayQuestion(final Quiz Question){
        Quiz.setText(Question.getQuestion());
        Answer1.setText(Question.getChoiceList().get(0));
        Answer2.setText(Question.getChoiceList().get(1));
        Answer3.setText(Question.getChoiceList().get(2));
        Answer4.setText(Question.getChoiceList().get(3));
   }
    private QuestionBank generateQuestionBank(){
    Quiz question1 = new Quiz(
            "Who is the creator of Android?",
            Arrays.asList(
                    "Andy Rubin",
                    "Steve Wozniak",
                    "Jake Wharton",
                    "Paul Smith"
            ),
            0
    );

    Quiz question2 = new Quiz(
            "When did the first man land on the moon?",
            Arrays.asList(
                    "1958",
                    "1962",
                    "1967",
                    "1969"
            ),
            3
    );

    Quiz question3 = new Quiz(
            "What is the house number of The Simpsons?",
            Arrays.asList(
                    "42",
                    "101",
                    "666",
                    "742"
            ),
            3
    );

return new QuestionBank(Arrays.asList(question1, question2, question3));
}

    @Override
    public void onClick(View v) {
        int index;
         if(v==id_exit){
             System.exit(1);
         }
        if (v == Answer1) {
            index = 0;
        } else if (v == Answer2) {
            index = 1;
        } else if (v == Answer3) {
            index = 2;
        } else if (v == Answer4) {
            index = 3;
        } else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }

        if(index==mQuestionBank.getCurrentQuestion().getAnswerIndex()){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "incorrect", Toast.LENGTH_SHORT).show();
        }

    }
}