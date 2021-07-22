package com.example.workmanagerpractice

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

// Your worker class needs to be a class that takes in a Context and a WorkerParameters.
// It must implement/derive (not sure yet) from Worker.
class UploadWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {

    // The only method you need to override is "doWork" which returns a Result (So many of these!  THIS IS NOT THE RESULT FROM THE API!)
    override fun doWork(): Result {

        // Do the work here.
        Log.d("TAG_X", "HELLO FROM WORKMANAGER")

        // Indicate whether the work finished successfully with the Result.
        // This is handled by the developer.
        return Result.success()
    }
}