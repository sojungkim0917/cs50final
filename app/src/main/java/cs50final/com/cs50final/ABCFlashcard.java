package cs50final.com.cs50final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ABCFlashcard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc_flashcard);
    }
    public void goToLiteracyHome(View v) {
        Intent intent = new Intent(this, ABCFlashcard.class);
        startActivity(intent);
    }

}
