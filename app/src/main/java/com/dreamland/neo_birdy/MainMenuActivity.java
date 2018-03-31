package com.dreamland.neo_birdy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        TextView play = findViewById(R.id.main_menu_play);
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent main = new Intent(MainMenuActivity.this, MainActivity.class);
                startActivity(main);
            }
        });
    }

}
