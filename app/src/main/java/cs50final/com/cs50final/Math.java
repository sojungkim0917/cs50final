package cs50final.com.cs50final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.AlertDialog;
import java.lang.String;
import android.content.DialogInterface;


public class Math extends AppCompatActivity {


    // Initialize buttons, textviews, and scores
    private Button mAnswer1;
    private Button mAnswer2;
    private Button mAnswer3;
    private Button mAnswer4;

    private TextView mQuestion;

    public MathQuestions mQuestions = new MathQuestions();

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionIndex = 0;
    private int mQuestionsLength = mQuestions.length();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math);

        // Set texts of buttons and textview
        mAnswer1 = findViewById(R.id.answer1);
        mAnswer2 = findViewById(R.id.answer2);
        mAnswer3 = findViewById(R.id.answer3);
        mAnswer4 = findViewById(R.id.answer4);

        mQuestion = findViewById(R.id.question);

        // Initialize first question
        updateQuestion(mQuestionIndex);

        // Upon clicking answer, if at the end of question set, game over dialog pops up
        // If not, if answer is correct, score is added but shown at the end
        // If answer is incorrect, does not acknowledge that fact but just proceed to next question
        mAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mQuestionIndex == mQuestionsLength - 1) {
                    gameOver();
                    }
                else {
                    if (mAnswer1.getText() == mAnswer) {
                        mScore++;
                    }
                    mQuestionIndex++;
                    updateQuestion(mQuestionIndex);
                }
            }
        });

        mAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (mQuestionIndex == mQuestionsLength - 1) {
                gameOver();
            }
            else {
                if (mAnswer2.getText() == mAnswer) {
                    mScore++;
                }
                mQuestionIndex++;
                updateQuestion(mQuestionIndex);
            }
        }
    });

        mAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mQuestionIndex == mQuestionsLength - 1) {
                    gameOver();
                }
                else {
                    if (mAnswer3.getText() == mAnswer) {
                        mScore++;
                    }
                    mQuestionIndex++;
                    updateQuestion(mQuestionIndex);
                }
            }
        });


        mAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mQuestionIndex == mQuestionsLength - 1) {
                    gameOver();
                }
                else {
                    if (mAnswer4.getText() == mAnswer) {
                        mScore++;
                    }
                    mQuestionIndex++;
                    updateQuestion(mQuestionIndex);
                }
            }
        });
    }

    // Function to proceed to next question
    private void updateQuestion(int num) {
        mQuestion.setText(mQuestions.getQuestion(num));
        mAnswer1.setText(mQuestions.getChoice1(num));
        mAnswer2.setText(mQuestions.getChoice2(num));
        mAnswer3.setText(mQuestions.getChoice3(num));
        mAnswer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer(num);

    }


    // Gameover dialog shows the score when all 20 questions are answered
    // User can either go back to main page to select literacy/math game or try again
    private void gameOver() {
       AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Math.this);
          alertDialogBuilder
                .setMessage("Game Over! Your score is " + mScore + " points.")
                .setCancelable(false)
                .setPositiveButton(R.string.positive_button, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), Math.class));
                    }
                })
                .setNegativeButton(R.string.negative_button,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), Homepage.class));
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}