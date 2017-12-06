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

public class Literacy2Video extends AppCompatActivity {

    VideoView literacy2Video;
    MediaController mediaControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.literacy2video);
        // Find your VideoView in your video_main.xml layout
        literacy2Video = (VideoView) findViewById(R.id.videoView4);

        if (mediaControls == null) {
            // create an object of media controller class
            mediaControls = new MediaController(Literacy2Video.this);
            mediaControls.setAnchorView(literacy2Video);
        }
        // set the media controller for video view
        literacy2Video.setMediaController(mediaControls);
        // set the uri for the video view
        literacy2Video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.toystory));
        // start a video
        literacy2Video.start();

        // implement on completion listener on video view
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
