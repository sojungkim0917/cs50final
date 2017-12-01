package cs50final.com.cs50final;

/* Need to work on how to set the end of questions and pop dialog alert up*/

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlertDialog;
import java.lang.String;
import android.content.DialogInterface;
import java.util.Locale;
import android.widget.Toast;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View.OnClickListener;


public class Math extends AppCompatActivity /*implements OnInitListener*/ {

    private Button mAnswer1;
    private Button mAnswer2;
    private Button mAnswer3;
    private Button mAnswer4;

    private TextView mQuestion;

    private MathQuestions mQuestions = new MathQuestions();

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLength = mQuestions.mQuestions.length;
    private int mQuestionIndex = 0;

    /*private TextToSpeech myTTS;
    private int MY_DATA_CHECK_CODE = 0;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math);

        mAnswer1 = findViewById(R.id.answer1);
        mAnswer2 = findViewById(R.id.answer2);
        mAnswer3 = findViewById(R.id.answer3);
        mAnswer4 = findViewById(R.id.answer4);

        mQuestion = findViewById(R.id.question);

        updateQuestion(mQuestionIndex);

        /*Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);*/

        mAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswer1.getText() == mAnswer) {
                    mScore++;
                    /*readNumber();
                } else {*/}
                if (mQuestionIndex < mQuestionsLength + 1) {
                    mQuestionIndex++;
                    updateQuestion(mQuestionIndex);
                    } else {
                    gameOver();
                }
            }
        });

        mAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (mAnswer2.getText() == mAnswer) {
                mScore++;
                /*readNumber();
            } else {*/}
            if (mQuestionIndex < mQuestionsLength + 1) {
                mQuestionIndex++;
                updateQuestion(mQuestionIndex);
            }
            else {
                gameOver();
            }
        }
    });

        mAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswer3.getText() == mAnswer) {
                    mScore++;
                    /*readNumber();
                }
                else {*/}
                if (mQuestionIndex < mQuestionsLength + 1) {
                    mQuestionIndex++;
                    updateQuestion(mQuestionIndex);
                }
                else {
                    gameOver();
                }
            }
        });


        mAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswer4.getText() == mAnswer) {
                    mScore++;
                    /*readNumber();
                }
                else {*/}
                if (mQuestionIndex < mQuestionsLength + 1) {
                    mQuestionIndex++;
                    updateQuestion(mQuestionIndex);
                }
                else {
                    gameOver();
                }
            }
        });
    }

    private void updateQuestion(int num) {
        mQuestion.setText(mQuestions.getQuestion(num));
        mAnswer1.setText(mQuestions.getChoice1(num));
        mAnswer2.setText(mQuestions.getChoice2(num));
        mAnswer3.setText(mQuestions.getChoice3(num));
        mAnswer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer(num);
    }

    /*private void readNumber() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Math.this);
        alertDialogBuilder.setMessage("Correct answer!").setCancelable(false).setPositiveButton("Listen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String words = mAnswer;
                speakWords(words);
            }
        }).setNegativeButton("Next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                updateQuestion(mQuestionIndex + 1);
                mQuestionIndex++;
            }
        });
    }

    private void speakWords(String speech) {
        myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                myTTS = new TextToSpeech(this, this);
            } else {
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }
    }

    public void onInit(int initStatus) {
        if (initStatus == TextToSpeech.SUCCESS) {
            if (myTTS.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE) myTTS.setLanguage(Locale.US);
        } else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(this, "Cannot read this word", Toast.LENGTH_LONG).show();
        }
    }*/

    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Math.this);
        alertDialogBuilder
                .setMessage("Game Over! Your score is " + mScore + " points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), Math.class));
                    }
                })
                .setNegativeButton("EXIT",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}