package com.eswaraj.app.eswaraj.service.local;

import com.eswaraj.app.eswaraj.service.ServerApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ravi on 25/11/2014.
 */
@Module
public class LocalServiceGraph {


    @Provides @Singleton
    ServerApi provideServerApi() {
        return new LocalServerApiImpl();
    }


}
