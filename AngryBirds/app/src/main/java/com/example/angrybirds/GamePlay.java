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
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;

public class GamePlay extends AppCompatActivity {

    ImageView imageView,imageViewMain;
    CountDownTimer countDownTimer;
    ImageButton imageButtonYes,imageButtonNo,imageButtonExit;
    int positionPre,position,point,kt,dem,time=30;
    Random generator = new Random();
    TextView textView,textViewTime;
    int[] picture={R.drawable.black,R.drawable.blue_1,R.drawable.blue_2,R.drawable.blue_3,
            R.drawable.blue_4,R.drawable.blue_5,R.drawable.green,R.drawable.pink,R.drawable.red_1,
            R.drawable.red_2,R.drawable.red_3,R.drawable.red_4,R.drawable.red_5,R.drawable.red_6,
            R.drawable.yellow_1,R.drawable.yellow_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        imageView=(ImageView) findViewById(R.id.imageView2);
        kt=generator.nextInt(1000);
        dem=0;
        if (kt%2==1) position=generator.nextInt(16);
        else position=positionPre;
        Intent intent=getIntent();
        positionPre= intent.getIntExtra("Key",0);
        imageView.setImageResource(picture[position]);
        textView=(TextView) findViewById(R.id.textView);
        textViewTime=(TextView) findViewById(R.id.textView2);
        imageButtonYes=(ImageButton) findViewById(R.id.imageButton1);
        countDownTimer=new CountDownTimer(31000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewTime.setText("Thời gian: " + time);
                time--;
            }

            @Override
            public void onFinish() { NewActivity();}
        }.start();
        imageButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==positionPre)
                {
                    if (dem<5) dem++;
                    point+=10*dem;
                }
                else
                {
                    point-=10;
                    dem=0;
                }
                textView.setText("Điểm: "+point);
                positionPre=position;
                kt=generator.nextInt(1000);
                if (kt%2==1) position=generator.nextInt(16);
                else position=positionPre;
                imageView.setImageResource(picture[position]);
            }
        });
        imageButtonNo=(ImageButton) findViewById(R.id.imageButton2);
        imageButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position!=positionPre)
                {
                    if (dem<5) dem++;
                    point+=10*dem;
                }
                else
                {
                    point-=10;
                    dem=0;
                }
                textView.setText("Điểm: "+point);
                positionPre=position;
                kt=generator.nextInt(1000);
                if (kt%2==1) position=generator.nextInt(16);
                else position=positionPre;
                imageView.setImageResource(picture[position]);
            }
        });
        imageButtonExit=(ImageButton) findViewById(R.id.imageButton3);
        imageButtonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ExitGame();
            }
        });
    }

    private void ExitGame()
    {
        finish();
    }

    private void NewActivity()
    {
        Intent intentNew=new Intent(GamePlay.this,EndGame.class);
        intentNew.putExtra("Key",point);
        startActivity(intentNew);
        finish();
    }
}