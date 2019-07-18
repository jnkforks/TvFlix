package com.android.ashwiask.tvmaze.network.backend

import com.android.ashwiask.tvmaze.network.NetworkModule
import com.android.ashwiask.tvmaze.network.TvMazeApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class TvMazeBackendModule {

    @Provides
    @Singleton
    fun provideTvMazeApi(
        okHttpClient: OkHttpClient,
        @Named(NetworkModule.TVMAZE_BASE_URL) baseUrl: String
    ): TvMazeApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build().create(TvMazeApi::class.java)
    }
}
