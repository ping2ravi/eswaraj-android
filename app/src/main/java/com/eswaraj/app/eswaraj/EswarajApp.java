package com.eswaraj.app.eswaraj;

import android.app.Application;

import com.eswaraj.app.eswaraj.middleware.MiddlewareGraph;
import com.eswaraj.app.eswaraj.service.local.LocalServiceGraph;

import java.util.Arrays;

import dagger.ObjectGraph;

/**
 * Created by Ravi on 25/11/2014.
 */
public class EswarajApp extends Application{

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(getModules());
    }

    public void inject(Object target) {
        objectGraph.inject(target);
    }

    public Object[] getModules() {
        return Arrays.asList(new LocalServiceGraph(), new MiddlewareGraph(this)).toArray();
    }
}
