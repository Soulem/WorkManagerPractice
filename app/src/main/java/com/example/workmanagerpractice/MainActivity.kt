package com.example.workmanagerpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity() : AppCompatActivity() {
    var counter = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myView : TextView = findViewById(R.id.string_textView)
        myView.text = "0"

        val uploadWorkRequest =
            PeriodicWorkRequestBuilder<UploadWorker>(15, TimeUnit.MINUTES)
                .setInitialDelay(5, TimeUnit.SECONDS)
                .build()

        WorkManager
            .getInstance(this)
            .enqueueUniquePeriodicWork("My Work", ExistingPeriodicWorkPolicy.KEEP, uploadWorkRequest)
    }
}