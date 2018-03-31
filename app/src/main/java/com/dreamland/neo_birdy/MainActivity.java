package com.dreamland.neo_birdy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.dreamland.neo_birdy.engine.Game;

public class MainActivity extends Activity {

    private Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container = findViewById(R.id.container);

        this.game = new Game(this);
        container.addView(this.game);
    }

    @Override
    protected void onPause(){
        super.onPause();
        this.game.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.game.initialize();
        new Thread(this.game).start();
    }
}
