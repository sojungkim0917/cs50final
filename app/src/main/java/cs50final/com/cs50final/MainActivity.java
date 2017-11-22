package cs50final.com.cs50final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToCardFlipActivity(View v) {
        Intent intent = new Intent(this, CardFlipActivity.class);
        startActivity(intent);
    }

    public void goToSecondPage(View v) {
        Intent intent = new Intent(this, SecondPage.class);
        startActivity(intent);
    }
}
