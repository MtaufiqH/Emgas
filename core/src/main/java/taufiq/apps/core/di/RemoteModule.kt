package taufiq.apps.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import taufiq.apps.core.data.source.remote.service.ApiService
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created By Taufiq on 5/18/2021.
 *
 */
@Module
@InstallIn(ApplicationComponent::class)
class RemoteModule {

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val hostname = "api.rawg.io"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/UGwY2lttaRoHnGd1gpeydmov1LzioQpzYTywtNSJkAU=")
            .add(hostname, "sha256/R+V29DqDnO269dFhAAB5jMlZHepWpDGuoejXJjprh7A=")
            .build()
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
            certificatePinner(certificatePinner)
            connectTimeout(5, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
        }
        return client.build()
    }

    @Singleton
    @Provides
    fun providesApiService(client: OkHttpClient): ApiService =
        Retrofit.Builder()
            .baseUrl("https://api.rawg.io/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}