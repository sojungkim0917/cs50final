package cs50final.com.cs50final;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.lang.String;
import java.util.Locale;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Literacy2 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    // THIS IS HARDER DIFFICULTY QUIZ FOR LITERACY

    // Define question field and buttons for page
    private TextView mQuestion;

    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private int mScore = 0;
    private int mQuestionNumber = 0;
    // Change the Length as you decide how many questions will be done
    private int mQuestionLength = 20;
    private String mAnswer;
    private String mCompAnswer;
    // Used for TTS system
    private TextToSpeech myTTS;
    private int MY_DATA_CHECK_CODE = 0;
    // Define variables to use from Firebase
    private Firebase mQuestionRef, mchoice1Ref, mchoice2Ref, mchoice3Ref, mchoice4Ref, mAnswerRef, mCompAnswerRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.literacy);
        // "Attaches" mQuestion variable name to textbox defined in layout page
        mQuestion = (TextView) findViewById(R.id.question);
        // "Attaches" Button variables to buttons defined in layout page
        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);
        mButtonChoice4 = findViewById(R.id.choice4);

        updateQuestion();

        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
        // OnClick Listeners defined for all 4 buttons. Here it's advancing to next question
        // Also adds to score if answered correctly
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mQuestionNumber == mQuestionLength - 1) {
                    gameOver();
                } else {
                    // Checks if chosen answer is equivalent to defined answer in database
                    if (mButtonChoice1.getText().equals(mAnswer)) {
                        mScore++;
                        readWord();
                    } else {
                        mQuestionNumber++;
                        updateQuestion();
                    }
                }
            }
        });
        // Listener for Button 2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mQuestionNumber == mQuestionLength - 1) {
                    gameOver();
                } else {
                    if (mButtonChoice2.getText().equals(mAnswer)) {
                        mScore++;
                        readWord();
                    } else {
                        mQuestionNumber++;
                        updateQuestion();
                    }
                }
            }
        });
        // Listener for Button 3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mQuestionNumber == mQuestionLength - 1) {
                    gameOver();
                } else {
                    if (mButtonChoice3.getText().equals(mAnswer)) {
                        mScore++;
                        readWord();
                    } else {
                        mQuestionNumber++;
                        updateQuestion();
                    }
                }
            }
        });
        // Listener for Button 4
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mQuestionNumber == mQuestionLength - 1) {
                    gameOver();
                } else {
                    if (mButtonChoice4.getText().equals(mAnswer)) {
                        mScore++;
                        readWord();
                    } else {
                        mQuestionNumber++;
                        updateQuestion();
                    }
                }
            }
        });
    }
    // updateQuestion function refined, pulling from FireBase database
    public void updateQuestion() {
        mQuestionRef = new Firebase("https://cs50final-7bf22.firebaseio.com/quiz2/"+ mQuestionNumber +"/question");
        mQuestionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue(String.class);
                mQuestion.setText(question);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        // Button 1 answer choices defined. Coming from firebase
        mchoice1Ref= new Firebase("https://cs50final-7bf22.firebaseio.com/quiz2/"+ mQuestionNumber +"/choice1");
        mchoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice1.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        // Button 2 answer choices defined. Coming from firebase
        mchoice2Ref= new Firebase("https://cs50final-7bf22.firebaseio.com/quiz2/"+ mQuestionNumber +"/choice2");
        mchoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice2.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        // Button 3 answer choices defined. Coming from firebase
        mchoice3Ref= new Firebase("https://cs50final-7bf22.firebaseio.com/quiz2/"+ mQuestionNumber +"/choice3");
        mchoice3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice3.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        // Button 4 answer choices defined. Coming from firebase
        mchoice4Ref= new Firebase("https://cs50final-7bf22.firebaseio.com/quiz2/"+ mQuestionNumber +"/choice4");
        mchoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice4.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        // Answer is defined in firebase. Function brings answer from database and compared with chosen answer in quiz
        mAnswerRef = new Firebase("https://cs50final-7bf22.firebaseio.com/quiz2/"+ mQuestionNumber +"/answer");
        mAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAnswer = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mCompAnswerRef = new Firebase("https://cs50final-7bf22.firebaseio.com/quiz2/"+ mQuestionNumber +"/companswer");
        mCompAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mCompAnswer = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
    // TTS function that brings up alert if right answer is chosen. Will read answer and then advance question
    private void readWord() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Literacy2.this);
        alertDialogBuilder.setMessage("That was correct answer!").setCancelable(false)
                .setPositiveButton("Listen and move to next", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String words = mCompAnswer;
                        speakWords(words);
                        mQuestionNumber++;
                        updateQuestion();
                    }
                }).setNegativeButton("Next", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i){
                mQuestionNumber++;
                updateQuestion();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    // TTS function con't
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
    }

    // Gameover dialog shows the score when all 20 questions are answered
    // User can either go back to main page to select literacy/math game or try again
    private void gameOver() {
        if (mScore < 15) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Literacy2.this);
            alertDialogBuilder.setMessage("Game Over! Your score is " + mScore + " points.").setCancelable(false).setPositiveButton(R.string.positive_button, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(getApplicationContext(), Literacy2.class));
                }
            }).setNegativeButton(R.string.negative_button, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(getApplicationContext(), Homepage.class));
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Literacy2.this);
            alertDialogBuilder.setMessage("Great job! Your score is " + mScore + " points.").setCancelable(false).setPositiveButton("Get the reward!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(getApplicationContext(), Literacy2Video.class));
                }
            }).setNegativeButton(R.string.negative_button, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(getApplicationContext(), Homepage.class));
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }
}
