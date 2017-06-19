package com.vrjco.v.videobackgroundsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.vrjco.v.vbackgroundvideoview.VVideoBackground;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        VVideoBackground videoBG = (VVideoBackground) findViewById(R.id.videobg);
        videoBG.setBackgroundVideo(R.raw.video);

    }

}
