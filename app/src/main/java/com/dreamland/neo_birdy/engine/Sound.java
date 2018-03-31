package com.dreamland.neo_birdy.engine;


import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import com.dreamland.neo_birdy.R;

public class Sound {
    public static int JUMP;
    public static int PONTUATION;
    public static int COLLISION;
    private SoundPool soundPool;

    public Sound(Context context) {
        this.soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        this.JUMP = this.soundPool.load(context, R.raw.pulo, 1);
        this.PONTUATION = this.soundPool.load(context, R.raw.pontos, 1);
        this.COLLISION = this.soundPool.load(context, R.raw.colisao, 1);
    }

    public void play(int sound) {
        this.soundPool.play(sound, 1, 1, 1, 0, 1);
    }
}
