package cs50final.com.cs50final;

/*
 * Created by sojungkim on 2017. 11. 29..
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Homepage extends ABCMain {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
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
