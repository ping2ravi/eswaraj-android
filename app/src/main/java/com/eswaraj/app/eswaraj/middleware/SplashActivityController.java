package com.eswaraj.app.eswaraj.middleware;

/**
 * Created by Ravi on 25/11/2014.
 *
 * Any Logic required by Splash Activity will live here as function
 */
public interface SplashActivityController {

    /**
     * This method will be called on application startup and will decide if Splash Screen need to be shown
     * @return
     */
    boolean isShowSplashActivity();
}
