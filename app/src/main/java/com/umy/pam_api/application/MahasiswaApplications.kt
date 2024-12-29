package com.umy.pam_api.application

import android.app.Application
import com.umy.pam_api.dependenciesinjection.AppContainer
import com.umy.pam_api.dependenciesinjection.MahasiswaContainer

class MahasiswaApplications : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}