package com.dreamland.neo_birdy.engine;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.dreamland.neo_birdy.element.Colors;

public class GameOver {
    private final Paint COLOR = Colors.getGameOverColor();
    private final Paint RETRY_COLOR = Colors.getRetryColor();
    private final MainDisplay display;
    public GameOver(MainDisplay display) {
        this.display = display;
    }

    public void drawGameOver(Canvas canvas) {
        canvas.drawText("Game Over", centerText("Game Over", COLOR), this.display.getHeight() / 2, COLOR);
        canvas.drawText("Press anywhere to play", centerText("Press anywhere to play", RETRY_COLOR), this.display.getHeight() / 2 + 100, RETRY_COLOR);
    }

    public int centerText(String text, Paint color) {
        Rect textLimit = new Rect();
        color.getTextBounds(text, 0, text.length(), textLimit);
        return this.display.getWidth()/2 - (textLimit.right - textLimit.left)/2;
    }
}
