package com.vrjco.v.vbackgroundvideoview;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by VRUSHABH on 19-06-2017.
 */

public class VVideoBackground extends SurfaceView implements SurfaceHolder.Callback {

    private Context context;
    private MediaPlayer mp;
    private int bgVideo = 0;

    public VVideoBackground(Context context) {
        super(context);
        init(context);
    }

    public VVideoBackground(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        getHolder().addCallback(this);
    }

    public void setBackgroundVideo(int rawResource) {
        if (rawResource != 0) {
            bgVideo = rawResource;
        }
    }

    public void removeBackgroundVideo() {
        if (bgVideo != 0 && mp != null) {
            bgVideo = 0;
            mp.release();
            mp = null;
        }
    }

    public MediaPlayer getMediaPlayer() {
        return mp;
    }


    public void changeToScreenWidth(){
        if(mp!=null){
            int videoWidth = mp.getVideoWidth();
            int videoHeight = mp.getVideoHeight();
            int screenHeight = getHeight();
            android.view.ViewGroup.LayoutParams lp = getLayoutParams();
            lp.height = screenHeight;
            lp.width = (int) (((float)videoWidth / (float)videoHeight) * (float)screenHeight);
            setLayoutParams(lp);
        }
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (bgVideo != 0) {
            mp = new MediaPlayer();
            AssetFileDescriptor afd = context.getResources().openRawResourceFd(bgVideo);
            try {
                mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
                mp.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int videoWidth = mp.getVideoWidth();
            int videoHeight = mp.getVideoHeight();
            int screenHeight = getHeight();
            android.view.ViewGroup.LayoutParams lp = getLayoutParams();

            lp.height = screenHeight;

            setLayoutParams(lp);
            mp.setDisplay(getHolder());

            mp.setLooping(true);
            mp.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (mp != null) {
            mp.release();
        }
        mp = null;
    }
}
