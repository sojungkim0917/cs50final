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

}
