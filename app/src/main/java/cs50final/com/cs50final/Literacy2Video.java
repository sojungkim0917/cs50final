package cs50final.com.cs50final;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

// Reward for 15+ in literacy level 2

public class Literacy2Video extends AppCompatActivity {

    VideoView literacy2Video;
    MediaController mediaControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.literacy2video);

        literacy2Video = (VideoView) findViewById(R.id.videoView4);

        if (mediaControls == null) {
            // Create media controller
            mediaControls = new MediaController(Literacy2Video.this);
            mediaControls.setAnchorView(literacy2Video);
        }
        // Set media controller
        literacy2Video.setMediaController(mediaControls);
        // Set URI for video
        literacy2Video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.toystory));
        // Start a video
        literacy2Video.start();

        // Implement on completion listener on video view
        literacy2Video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(), "Great work", Toast.LENGTH_LONG).show(); // display a toast when an video is completed
            }
        });
        literacy2Video.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), "Oops An Error Occured While Playing Video", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;
            }
        });
    }

}
