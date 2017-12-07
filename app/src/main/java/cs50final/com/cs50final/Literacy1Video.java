package cs50final.com.cs50final;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

// Reward for 15+ in literacy level 1

public class Literacy1Video extends AppCompatActivity {

    VideoView literacy1Video;
    MediaController mediaControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.literacy1video);

        literacy1Video = (VideoView) findViewById(R.id.videoView);

        if (mediaControls == null) {
            // Create media controller
            mediaControls = new MediaController(Literacy1Video.this);
            mediaControls.setAnchorView(literacy1Video);
        }
        // Set media controller
        literacy1Video.setMediaController(mediaControls);
        // Set URI for video
        literacy1Video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cars2));
        // Start a video
        literacy1Video.start();

        // Implement on completion listener on video view
        literacy1Video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(), "Great work", Toast.LENGTH_LONG).show(); // display a toast when an video is completed
            }
        });
        literacy1Video.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), "Oops An Error Occured While Playing Video", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;
            }
        });
    }

}
