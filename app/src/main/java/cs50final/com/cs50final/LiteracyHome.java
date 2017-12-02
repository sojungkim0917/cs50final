// Choose study or test

package cs50final.com.cs50final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LiteracyHome extends AppCompatActivity {

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.literacyhome);
    }

    public void goToFlashcard_Lit(View v) {
        Intent intent = new Intent(this, Flashcard_Lit.class);
        startActivity(intent);
    }

    public void goToLiteracy(View v) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }
}
