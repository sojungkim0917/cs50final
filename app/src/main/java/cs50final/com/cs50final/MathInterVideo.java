package cs50final.com.cs50final;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
        // Find your VideoView in your video_main.xml layout
        mathInterVideo = (VideoView) findViewById(R.id.videoView3);

        if (mediaControls == null) {
            // create an object of media controller class
            mediaControls = new MediaController(MathInterVideo.this);
            mediaControls.setAnchorView(mathInterVideo);
        }
        // set the media controller for video view
        mathInterVideo.setMediaController(mediaControls);
        // set the uri for the video view
        mathInterVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lou));
        // start a video
        mathInterVideo.start();

        // implement on completion listener on video view
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
