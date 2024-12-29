package com.umy.pam_api.dependenciesinjection

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.umy.pam_api.repository.MahasiswaRepository
import com.umy.pam_api.repository.NetworkMahasiswaRepository
import com.umy.pam_api.service_api.MahasiswaService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val kontakRepository : MahasiswaRepository
}

class MahasiswaContainer : AppContainer {
    private val baseUrl = "http://10.0.2.2:8090/umyTI/" //http://10.0.2.2:8080/umyTI/ untuk lokal
    private val json = Json { ignoreUnknownKeys = true}
    private val retrofit: Retrofit = Retrofit.Builder()

        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val mahasiswaService: MahasiswaService by lazy {
        retrofit.create(MahasiswaService::class.java)
    }
    override val kontakRepository: MahasiswaRepository by lazy {
        NetworkMahasiswaRepository (mahasiswaService)
    }
}