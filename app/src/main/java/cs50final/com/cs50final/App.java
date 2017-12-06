package cs50final.com.cs50final;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.firebase.client.Firebase;

/**
 * Created by sishiryeety on 12/5/17.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}