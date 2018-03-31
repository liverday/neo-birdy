package com.dreamland.neo_birdy.element;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.dreamland.neo_birdy.engine.Sound;

public class Score {
    private static final Paint COLOR = Colors.getScoreColor();
    private int score = 0;
    private Sound sound;
    public Score(Sound sound) {
        this.sound = sound;
    }
    public void increase() {
        this.sound.play(Sound.PONTUATION);
        this.score++;
    }

    public void drawScore(Canvas canvas) {
        canvas.drawText(String.valueOf(this.score), 100, 100, COLOR);
    }
}
