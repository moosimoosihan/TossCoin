package com.example.tosscoin

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    var state : Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tossButton = findViewById(R.id.toss_button) as Button
        var coinImage = findViewById(R.id.coin_image) as ImageView

        tossButton.setOnClickListener{
            var animation: Animation = AnimationUtils.loadAnimation(this,R.anim.coin_effect)
            coinImage.startAnimation(animation)

            var mediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.coin_effect)
            mediaPlayer?.start()

            Timer().schedule(2200){
              state = (0..1).random()

              if(state == 0){
                  coinImage.setImageResource(R.drawable.coin_back)
              } else {
                  coinImage.setImageResource(R.drawable.coin_front)
              }
            }
        }
    }
}