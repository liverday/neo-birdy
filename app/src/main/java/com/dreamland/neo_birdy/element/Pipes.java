package com.dreamland.neo_birdy.element;


import android.content.Context;
import android.graphics.Canvas;

import com.dreamland.neo_birdy.MainActivity;
import com.dreamland.neo_birdy.engine.MainDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Pipes {

    private static final int PIPE_QTTY = 5;
    private static final int PIPE_DISTANCE = 400;
    private static final int PIPE_INITIAL_POSITION = 1000;
    private List<Pipe> pipeList = new ArrayList<Pipe>();
    private MainDisplay display;
    private Score score;
    private Context context;

    public Pipes(Context context, MainDisplay display, Score score) {
        this.context = context;
        this.score = score;
        this.display = display;
        int position = PIPE_INITIAL_POSITION;

        for(int i = 0; i < PIPE_QTTY; i++) {
            position += PIPE_DISTANCE;
            this.pipeList.add(new Pipe(context, this.display, position));
        }
    }

    public void move() {
        ListIterator<Pipe> iterator = this.pipeList.listIterator();
        while(iterator.hasNext()) {
            Pipe pipe = iterator.next();
            pipe.move();
            if (pipe.outOfDisplay()) {
                this.score.increase();
                iterator.remove();
                Pipe newPipe = new Pipe(context, display, higherPosition() + PIPE_DISTANCE);
                iterator.add(newPipe);
            }
        }
    }

    public void drawPipe(Canvas canvas) {
        for(Pipe pipe: pipeList) {
            pipe.drawPipe(canvas);
        }
    }

    public int higherPosition() {
        int higher = 0;
        for (Pipe pipe: pipeList) {
            higher = Math.max(pipe.getPosition(), higher);
        }
        return higher;
    }

    public boolean hasCollidedWith(Bird bird) {
        for (Pipe pipe: this.pipeList) {
            if (pipe.crossedHorizontically() && pipe.crossedVertically(bird)) {
                return true;
            }
        }
        return false;
    }
}
