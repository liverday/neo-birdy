package com.dreamland.neo_birdy.element;

import android.graphics.Paint;
import android.graphics.Typeface;

public class Colors {
    public static Paint getBirdColor() {
        Paint color= new Paint();
        color.setColor(0xFFFF0000); //red
        return color;
    }

    public static Paint getPipeColor() {
        Paint color = new Paint();
        color.setColor(0xFF00FF00); //green
        return color;
    }

    public static Paint getScoreColor() {
        Paint color = new Paint();
        color.setColor(0xFFFFFFFF);
        color.setTextSize(90);
        color.setTypeface(Typeface.DEFAULT_BOLD);
        color.setShadowLayer(3,5,5, 0xFF000000);
        return color;
    }

    public static Paint getGameOverColor() {
        Paint color = new Paint();
        color.setColor(0xFFFF0000);
        color.setTextSize(100);
        color.setTypeface(Typeface.DEFAULT_BOLD);
        color.setShadowLayer(2, 3, 3, 0xFF000000);
        return color;
    }

    public static Paint getRetryColor() {
        Paint color = new Paint();
        color.setColor(0xFFFFFFFF);
        color.setTextSize(80);
        color.setTypeface(Typeface.DEFAULT_BOLD);
        color.setShadowLayer(2,3,3,0xFF000000);
        return color;
    }
}
