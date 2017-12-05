package cs50final.com.cs50final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class ABCMain extends AppCompatActivity {
    ImageButton mImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc_main);
        mImageButton=(ImageButton) findViewById(R.id.b_mathhome);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHomepage(v);
            }
        });
    }

    public void goToHomepage(View v) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }
}


