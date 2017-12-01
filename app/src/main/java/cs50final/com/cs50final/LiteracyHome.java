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

    public void goToABCFlashcard(View v) {
        Intent intent = new Intent(this, ABCFlashcard.class);
        startActivity(intent);
    }

    public void goToLiteracy(View v) {
        Intent intent = new Intent(this, Literacy.class);
        startActivity(intent);
    }
}
