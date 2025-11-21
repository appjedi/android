package com.cs211d.movietracker

import android.app.Application
import com.cs211d.movietracker.data.AppContainer
import com.cs211d.movietracker.data.DefaultAppContainer

class MoviesApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
