package com.dreamland.neo_birdy.element;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.dreamland.neo_birdy.R;
import com.dreamland.neo_birdy.engine.MainDisplay;
import com.dreamland.neo_birdy.engine.Sound;
import com.dreamland.neo_birdy.engine.Time;

public class Bird {
    public static final int X = 100;
    public static final int RADIUS = 50;
    public static final int JUMP_DISPLACEMENT = 10;
    private final Bitmap bird;
    private int height;
    private MainDisplay display;
    private Sound sound;
    private Time time;
    public boolean gameOver;
    private boolean isFirstJump = true;


    public Bird(MainDisplay display, Context context, Sound sound, Time time) {
        this.display = display;
        this.height = 100;
        this.sound = sound;
        this.time = time;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.bird);
        this.bird = Bitmap.createScaledBitmap(bp, RADIUS*2, RADIUS*2, false);
    }

    public void drawBird(Canvas canvas) { canvas.drawBitmap(this.bird, X - RADIUS, this.height - RADIUS, null); }

    public void fly() {
        double time = this.time.getActual();
        double newHeight = (isFirstJump) ? ((10 * (time * time)) /2.0) : -JUMP_DISPLACEMENT + ((10 * (time * time)) /2.0);

        boolean reachedFloor = this.height + RADIUS > display.getHeight();

        if (!reachedFloor) {
            this.height += newHeight;
       } else {
            this.gameOver = true;
        }
    }

    public void jump() {
        if (this.height > RADIUS) {
            this.isFirstJump = false;
            this.sound.play(Sound.JUMP);
            this.time.restart();

        }
    }

    public int getHeight() {
        return this.height;
    }
}
