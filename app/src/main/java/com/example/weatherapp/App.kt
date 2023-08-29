package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.network.Api
import com.example.weatherapp.network.HeaderInterceptor
import okhttp3.OkHttpClient
import org.koin.android.ext.android.get
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.dsl.single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(module{
                single{
                    val client = OkHttpClient.Builder()
                        .addInterceptor(HeaderInterceptor())
                        .build()
                    Retrofit
                        .Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .baseUrl("http://dataservice.accuweather.com/")
                        .build()
                }
               single {
                   val retrofit:Retrofit = get()
                   retrofit.create<Api>()
                //   retrofit.create(Api::class.java)
               }
            })
        }
    }
}
