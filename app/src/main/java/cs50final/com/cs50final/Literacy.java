package cs50final.com.cs50final;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by sishiryeety on 12/2/17.
 */

public class Literacy extends AppCompatActivity {

    private TextView mQuestion;

    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private int mScore = 0;
    private int mQuestionNumber = 0;
    private String mAnswer;

    private Firebase mQuestionRef, mchoice1Ref, mchoice2Ref, mchoice3Ref, mchoice4Ref, mAnswerRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.abc_main);

        mQuestion = (TextView) findViewById(R.id.question);

        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);
        mButtonChoice4 = findViewById(R.id.choice4);

        updateQuestion();

    }

    public void updateQuestion() {
        mQuestionRef = new Firebase("https://cs50final-7bf22.firebaseio.com/"+ mQuestionNumber +"/question");
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

        mchoice1Ref= new Firebase("https://cs50final-7bf22.firebaseio.com/"+ mQuestionNumber +"/choice1");
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

        mchoice2Ref= new Firebase("https://cs50final-7bf22.firebaseio.com/"+ mQuestionNumber +"/choice2");
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

        mchoice3Ref= new Firebase("https://cs50final-7bf22.firebaseio.com/"+ mQuestionNumber +"/choice3");
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

        mchoice4Ref= new Firebase("https://cs50final-7bf22.firebaseio.com/"+ mQuestionNumber +"/choice4");
        mchoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice1.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mAnswerRef = new Firebase("https://cs50final-7bf22.firebaseio.com/"+ mQuestionNumber +"/answer");
        mAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mAnswer = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mQuestionNumber++;

    }
}
