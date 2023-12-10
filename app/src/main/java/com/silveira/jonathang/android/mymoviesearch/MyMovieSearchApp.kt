package com.silveira.jonathang.android.mymoviesearch

import android.app.Application
import com.silveira.jonathang.android.domain.di.domainKoinModule
import com.silveira.jonathang.android.mymoviesearch.di.appKoinModule
import com.silveira.jonathang.android.remote.di.remoteKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MyMovieSearchApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyMovieSearchApp)
            loadKoinModules(
                listOf(remoteKoinModule, domainKoinModule, appKoinModule)
            )
        }
    }
}