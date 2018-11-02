package com.example.carlos.menuheroes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class resultadoActivity extends AppCompatActivity {

    boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        TextView scoreLabel = (TextView)findViewById(R.id.scoreLabel);
        TextView highScoreLabel = (TextView)findViewById(R.id.highScoreLabel);

        int score = getIntent().getIntExtra("SCORE", 0);
        running = getIntent().getBooleanExtra("RUNNING", false);

        scoreLabel.setText(score + "");
        SharedPreferences setting = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore = setting.getInt("HIGH_SCORE",0);

        if (score > highScore){
            highScoreLabel.setText("HIGH SCORE :" + score);

            //SAVE
            SharedPreferences.Editor editor = setting.edit();
            editor.putInt("HIGH_SCORE",score);
            editor.commit();
        }
        else {
            highScoreLabel.setText("HIGH SCORE :" + highScore);
        }
    }

    public void tryAgain(View view) {

        Intent intent = new Intent(getApplicationContext(),juegoActivity.class);
        intent.putExtra("RUNNING",running);
        startActivity(intent);
    }

    //disable return
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

}
