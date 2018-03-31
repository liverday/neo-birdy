package com.dreamland.neo_birdy.engine;


import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class MainDisplay {

    private DisplayMetrics metrics;

    public MainDisplay(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (wm != null) {
            Display display = wm.getDefaultDisplay();
            this.metrics = new DisplayMetrics();
            display.getMetrics(this.metrics);
        }
    }

    public int getHeight() {
        return this.metrics.heightPixels;
    }
    public int getWidth() { return this.metrics.widthPixels; }
}
