package com.dreamland.neo_birdy.engine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.dreamland.neo_birdy.R;
import com.dreamland.neo_birdy.element.Bird;
import com.dreamland.neo_birdy.element.Pipe;
import com.dreamland.neo_birdy.element.Pipes;
import com.dreamland.neo_birdy.element.Score;

public class Game extends SurfaceView implements Runnable, 	View.OnTouchListener {
    private Bitmap background;
    private final SurfaceHolder holder = getHolder(); //class that allow access to each pixel of the application;
    private boolean isRunning = true;
    private Bird bird;
    private Pipes pipes;
    private Pipe pipe;
    private MainDisplay display;
    private Score score;
    private CollisionVerifier collisionVerifier;
    private Context context;
    private Sound sound;
    private Time time;
    public Game(Context context) {
        super(context);
        this.context = context;
        this.sound = new Sound(context);
        this.display = new MainDisplay(context);
        setOnTouchListener(this);
        initializeElem();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (isRunning) this.bird.jump();
        else {
            recreateActivity(context);
        }
        return false;
    }

    private void recreateActivity(Context context) {
        Activity act = (Activity) context;
        act.recreate();
    }

    @Override
    public void run() {
        while (this.isRunning) {

            if (!this.holder.getSurface().isValid()) continue;

            Canvas canvas = this.holder.lockCanvas(); //grant access to canvas;

            this.time.increase();

            canvas.drawBitmap(this.background, 0, 0, null); //draw a new background to each iterate

            this.bird.drawBird(canvas); //draw bird
            this.bird.fly(); //bird fall to each draw

            this.pipes.drawPipe(canvas); //draw pipe
            this.pipes.move();

            if (this.collisionVerifier.hasCollided()) {
                this.sound.play(Sound.COLLISION);
                new GameOver(this.display).drawGameOver(canvas);
                this.cancel();
            }

            if (this.bird.gameOver) {
                this.sound.play(Sound.COLLISION);
                new GameOver(this.display).drawGameOver(canvas);
                this.cancel();
            }

            this.score.drawScore(canvas); //draw score



            this.holder.unlockCanvasAndPost(canvas); //unlock canvas to the app;
        }
    }

    public void cancel() {
        this.isRunning = false;
    }

    public void initialize() {
        this.isRunning = true;
    }

    public void initializeElem() {
        drawBackground();
        this.time = new Time();
        this.bird = new Bird(this.display, this.context, this.sound, this.time);
        this.score = new Score(this.sound);
        this.pipes = new Pipes(this.context, this.display, this.score);
        this.collisionVerifier = new CollisionVerifier(this.bird, this.pipes);
    }

    public void drawBackground() {
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        this.background = Bitmap.createScaledBitmap(back, back.getWidth(), this.display.getHeight(), false);
    }
}
