package cs50final.com.cs50final;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MathBeginnerVideo extends AppCompatActivity {

    VideoView mathBegVideo;
    MediaController mediaControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathbeginnervideo);

        mathBegVideo = (VideoView) findViewById(R.id.videoView2);

        if (mediaControls == null) {
            // Create media controller
            mediaControls = new MediaController(MathBeginnerVideo.this);
            mediaControls.setAnchorView(mathBegVideo);
        }
        // Set media controller
        mathBegVideo.setMediaController(mediaControls);
        // Set URI for video
        mathBegVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.laluna));
        // Start a video
        mathBegVideo.start();

        // Implement on completion listener on video view
        mathBegVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(getApplicationContext(), "Great work", Toast.LENGTH_LONG).show(); // display a toast when an video is completed
            }
        });
        mathBegVideo.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(getApplicationContext(), "Oops An Error Occured While Playing Video", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;
            }
        });
    }

}
