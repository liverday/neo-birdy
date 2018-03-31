package com.dreamland.neo_birdy.element;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.dreamland.neo_birdy.R;
import com.dreamland.neo_birdy.engine.MainDisplay;

public class Pipe {
    private static final int PIPE_HEIGHT = 500;
    private static final int PIPE_WIDTH = 100;
    private static final int PIPE_DIFFERENCE = 450;
    private static final Paint COLOR = Colors.getPipeColor();
    private int downPipeHeight;
    private int upperPipeHeight;
    private MainDisplay display;
    private int position;
    private Bitmap downPipe;
    private Bitmap upperPipe;

    public Pipe(Context context, MainDisplay display, int position) {
        this.display = display;
        this.position = position;
        this.downPipeHeight = display.getHeight() - PIPE_HEIGHT + randomValue();
        this.upperPipeHeight = downPipeHeight - PIPE_DIFFERENCE;
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.pipe);
        this.downPipe = Bitmap.createScaledBitmap(bp, PIPE_WIDTH, this.downPipeHeight, false);
        this.upperPipe = Bitmap.createScaledBitmap(bp, PIPE_WIDTH, this.upperPipeHeight, false);
    }

    public int getPosition() {
        return this.position;
    }

    public void drawPipe(Canvas canvas) {
        drawUpperPipe(canvas);
        drawDownPipe(canvas);
    }

    private void drawDownPipe(Canvas canvas) {
        canvas.drawBitmap(this.downPipe, this.position, this.downPipeHeight, null);
    }

    private void drawUpperPipe(Canvas canvas) {
        canvas.drawBitmap(this.upperPipe, this.position, 0, null);
    }

    public void move() {
        this.position -= 5;
    }

    public int randomValue() {
        return (int) (Math.random() * 350);
    }

    public boolean outOfDisplay() {
        return this.position + PIPE_WIDTH < 0;
    }

    public boolean crossedVertically(Bird bird) {
        return  (bird.getHeight() - Bird.RADIUS < this.upperPipeHeight)
                || (bird.getHeight() + Bird.RADIUS > this.downPipeHeight);
    }

    public boolean crossedHorizontically() {
        return (this.position + Bird.X > Bird.X - Bird.RADIUS) && this.position - Bird.X < Bird.RADIUS;
    }
}
