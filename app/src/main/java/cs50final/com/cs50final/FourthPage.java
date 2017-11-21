package cs50final.com.cs50final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class FourthPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_page);
    }

    public void goToFifthActivity(View v) {
        Intent intent = new Intent(this, FifthPage.class);
        startActivity(intent);
    }


}