package com.example.workmanagerpractice

import android.content.Context
import android.util.Log
import android.widget.TextView
import androidx.work.Worker
import androidx.work.WorkerParameters

class UploadWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {

    override fun doWork(): Result {

        // Do the work here--in this case, upload the images.
        Log.d("TAG_X", "HELLO FROM WORKMANAGER")

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }
}