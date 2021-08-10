package com.example.angrybirds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton,imageButtonAbout;
    ImageView imageView;
    int position;
    Random generator = new Random();

    int[] picture={R.drawable.black,R.drawable.blue_1,R.drawable.blue_2,R.drawable.blue_3,
            R.drawable.blue_4,R.drawable.blue_5,R.drawable.green,R.drawable.pink,R.drawable.red_1,
            R.drawable.red_2,R.drawable.red_3,R.drawable.red_4,R.drawable.red_5,R.drawable.red_6,
            R.drawable.yellow_1,R.drawable.yellow_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView) findViewById(R.id.imageView);
        position=generator.nextInt(16);
        imageView.setImageResource(picture[position]);
        imageButton=(ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GamePlay.class);
                intent.putExtra("Key",position);
                startActivity(intent);
            }
        });
        imageButtonAbout=(ImageButton) findViewById(R.id.imageButtonAbout);
        imageButtonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbout=new Intent(MainActivity.this,About.class);
                startActivity(intentAbout);
            }
        });
    }
}