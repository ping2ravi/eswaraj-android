package com.eswaraj.app.eswaraj.middleware;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.eswaraj.app.eswaraj.helpers.SharedPreferencesHelper;
import com.eswaraj.app.eswaraj.location.LocationUtil;
import com.eswaraj.app.eswaraj.middleware.services.LocalCacheService;
import com.eswaraj.app.eswaraj.middleware.services.LocalCacheServiceImpl;
import com.eswaraj.app.eswaraj.util.FacebookLoginUtil;
import com.eswaraj.app.eswaraj.util.InternetServicesCheckUtil;
import com.eswaraj.app.eswaraj.util.LocationServicesCheckUtil;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * Created by Ravi on 25/11/2014.
 */
@Module
public class MiddlewareGraph {

    private Context appContext;
    public MiddlewareGraph(Context appContext) {
        this.appContext = appContext;
    }


    @Provides
    public Context provideAppContext() {
        return appContext;
    }

    @Provides @Singleton
    SplashActivityController provideSplashActivityController() {
        return new SplashActivityControllerImpl();
    }

    @Provides
    FacebookLoginUtil provideFacebookLoginUtil() {
        return new FacebookLoginUtil();
    }

    @Provides @Singleton
    SharedPreferencesHelper provideSharedPreferencesHelper() {
        return new SharedPreferencesHelper();
    }

    @Provides @Singleton
    LocalCacheService provideLocalCacheService() {
        return new LocalCacheServiceImpl();
    }


    @Provides @Singleton
    LocationUtil provideLocationUtil(Context context) {
        return new LocationUtil(context);
    }


    @Provides @Singleton @Named("default")
    EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public RequestQueue provideRequestQueue(Context context) {
        /** Set up to use OkHttp */
        return Volley.newRequestQueue(context);
    }

    @Provides
    InternetServicesCheckUtil provideInternetServicesCheckUtil() {
        return new InternetServicesCheckUtil();
    }

    @Provides
    LocationServicesCheckUtil provideLocationServicesCheckUtil() {
        return new LocationServicesCheckUtil();
    }

}
