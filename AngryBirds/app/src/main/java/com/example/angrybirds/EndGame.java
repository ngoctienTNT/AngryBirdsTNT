package com.example.angrybirds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {

    TextView textView;
    ImageButton imageButton;
    int point=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Intent intent=getIntent();
        point=intent.getIntExtra("Key",0);
        textView=(TextView) findViewById(R.id.textView3);
        textView.setText("Điểm của bạn:\n"+point);
        imageButton=(ImageButton) findViewById(R.id.imageButton4);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExitGame();
            }
        });
    }

    private void ExitGame()
    {
        finish();
    }
}