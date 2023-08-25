package com.ethernet389.bookshelf.application

import android.app.Application
import com.ethernet389.bookshelf.di.appModule
import com.ethernet389.bookshelf.di.dataModule
import com.ethernet389.bookshelf.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(applicationContext)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}