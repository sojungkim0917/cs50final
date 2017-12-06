package cs50final.com.cs50final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by sojungkim on 2017. 12. 5..
 */

public class MathHome extends AppCompatActivity {

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathhome);
    }

    public void goToBeginner(View v) {
        Intent intent = new Intent(this, BeginnerMath.class);
        startActivity(intent);
    }

    public void goToIntermediate(View v) {
        Intent intent = new Intent(this, IntermediateMath.class);
        startActivity(intent);
    }
}