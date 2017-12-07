package cs50final.com.cs50final;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class Flashcard_Lit extends AppCompatActivity {

    /*define buttons*/
    Button b_prev, b_next;

    /*define imageswitcher*/
    private ImageSwitcher imageSwitcher;

    /* create array of images to be loaded into the image switcher*/
    private static final Integer[] images = {R.drawable.a_1, R.drawable.b_1, R.drawable.c_1, R.drawable.d_1, R.drawable.e_1, R.drawable.f_1,
            R.drawable.g_1, R.drawable.h_1, R.drawable.i_1, R.drawable.j_1, R.drawable.k_1, R.drawable.l_1,
            R.drawable.m_1, R.drawable.n_1, R.drawable.o_1, R.drawable.p_1, R.drawable.q_1, R.drawable.r_1,
            R.drawable.s_1, R.drawable.t_1, R.drawable.u_1, R.drawable.v_1, R.drawable.w_1, R.drawable.x_1,
            R.drawable.y_1, R.drawable.z_1};

    /*start for flashcard, -1 so it begins on the letter A (i0)*/
    int i = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flashcard_lit);

        /*set image in ImageSwitcher by using findViewbyID method*/
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);


        /*setFactory Sets the factory used to create the views between which the ViewSwitcher will flip*/
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            /*set parameters for the ImageSwitcher*/
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(
                        new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });

        /* add object of animation to imageswitcher by using AnimationUtils class*/
        Animation in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.in);
        Animation out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.out);

        /* set the Animation on ImageSwitcher */
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);

        /*define button actions when clicked*/
        b_prev = (Button) findViewById(R.id.b_prev);
        b_next = (Button) findViewById(R.id.b_next);

        b_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i > 0) {
                    i--;
                    imageSwitcher.setImageResource(images[i]);
                }

            }
        });

        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < images.length - 1) {
                    i++;
                    imageSwitcher.setImageResource(images[i]);
                }

            }
        });
    }

}
