package id.arieridwan.maverickssample

import android.app.Application
import android.support.v7.app.AppCompatDelegate
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import id.arieridwan.maverickssample.data.ApiService
import id.arieridwan.maverickssample.repository.MovieRepository
import id.arieridwan.maverickssample.usecase.MovieUseCase
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by arieridwan on 31/08/18.
 */

class BaseApp: Application() {

    private val module : Module = applicationContext {
        bean {
            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            retrofit.create(ApiService::class.java)
        }
        factory { MovieRepository(get()) }
        factory { MovieUseCase(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        startKoin(this, listOf(module))
    }

}