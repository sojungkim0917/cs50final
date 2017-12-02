package cs50final.com.cs50final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ABCMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc_main);
    }

    public void goToHomepage(View v) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }

    public void goToLiteracyHome(View v) {
        Intent intent = new Intent(this, LiteracyHome.class);
        startActivity(intent);
    }

    public void goToFlashcard_Lit(View v) {
        Intent intent = new Intent(this, Flashcard_Lit.class);
        startActivity(intent);
    }

    public void goToABCMain(View v) {
        Intent intent = new Intent(this, ABCMain.class);
        startActivity(intent);
    }

    public void goToLiteracy(View v) {
        Intent intent = new Intent(this, Literacy.class);
        startActivity(intent);
    }
    public void goToMath(View v) {
        Intent intent = new Intent(this, Math.class);
        startActivity(intent);
    }
}
