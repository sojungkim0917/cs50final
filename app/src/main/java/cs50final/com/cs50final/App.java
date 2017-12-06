package cs50final.com.cs50final;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.firebase.client.Firebase;

// Allows Android Application to use Firebase for Literacy quizzes

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}