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
        // Work Manager has a hard time doing work for the activity.
        // Will need to send it a bundle
        /*val input: Bundle = Bundle().apply {
            putString("some_key", "some_value")
        }*/

        // The worker and request
        // using PeriodWorkRequestBuilder<T> will give us a WorkRequest.
        // This is what we are going to use to give to the work manager.
        // The minimum interval is 15 minutes.  if you're testing this I hope
        // you have made time.
        val uploadWorkRequest =
            PeriodicWorkRequestBuilder<UploadWorker>(15, TimeUnit.MINUTES)
                .build()

        // Queue it up in the work manager.
        // The WorkManager is a singleton that needs a context.
        WorkManager
            .getInstance(this)
            .enqueueUniquePeriodicWork("My Work", ExistingPeriodicWorkPolicy.KEEP, uploadWorkRequest)
    }
}