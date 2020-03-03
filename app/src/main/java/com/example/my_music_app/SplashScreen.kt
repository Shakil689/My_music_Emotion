package com.example.my_music_app

import androidx.appcompat.app.AppCompatActivity


import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ProgressBar

import com.example.my_music_app.MainActivity

class SplashScreen : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var progress: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_Splash_Screen);

        progressBar = findViewById(R.id.progressBarID) as ProgressBar

        val thread = Thread(Runnable {
            doWork()
            startApp()
        })

        thread.start()
    }

    fun doWork() {
        progress = 20
        while (progress <= 100) {
            try {
                Thread.sleep(1000)
                progressBar!!.progress = progress
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            progress = progress + 20
        }
    }

    fun startApp() {
        val intent = Intent(this@SplashScreen, MainActivity::class.java)
        startActivity(intent)
        finish()

    }
}