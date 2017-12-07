package cs50final.com.cs50final;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MathInterVideo extends AppCompatActivity {

    VideoView mathInterVideo;
    MediaController mediaControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathintervideo);

        mathInterVideo = (VideoView) findViewById(R.id.videoView3);

        if (mediaControls == null) {
            // Create media controller
            mediaControls = new MediaController(MathInterVideo.this);
            mediaControls.setAnchorView(mathInterVideo);
        }
        // Set media controller
        mathInterVideo.setMediaController(mediaControls);
        // Set URI for video
        mathInterVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lou));
        // Start a video
        mathInterVideo.start();

        // Implement on completion listener on video view
        mathInterVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(), "Great work", Toast.LENGTH_LONG).show(); // display a toast when an video is completed
            }
        });
        mathInterVideo.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), "Oops An Error Occured While Playing Video", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;
            }
        });
    }

}
