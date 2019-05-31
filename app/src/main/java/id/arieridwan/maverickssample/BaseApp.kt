package id.arieridwan.maverickssample

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import id.arieridwan.maverickssample.repository.MovieRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import id.arieridwan.maverickssample.data.ApiService

/**
 * Created by arieridwan on 31/08/18.
 */

class BaseApp: Application() {

    private val appModule = module {
        single { Moshi.Builder().add(KotlinJsonAdapterFactory()).build() }
        single {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create(get()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            retrofit.create(ApiService::class.java)
        }
        factory { MovieRepository(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        startKoin {
            // Android context
            androidContext(this@BaseApp)
            // modules
            modules(appModule)
        }
    }

}