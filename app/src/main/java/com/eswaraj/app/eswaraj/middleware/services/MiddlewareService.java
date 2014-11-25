package com.eswaraj.app.eswaraj.middleware.services;

import com.eswaraj.app.eswaraj.handlers.OnCategoryLoad;
import com.eswaraj.web.dto.RegisterFacebookAccountRequest;

/**
 * Created by Ravi on 25/11/2014.
 */
public interface MiddlewareService {
    /**
     * This service will load categories from either Local cache or from Server
     * and on success will call OnCategoryLoad.onCategoryLoadSuccess
     * and on failure will call OnCategoryLoad.onCategoryLoadFail
     * @param onCategoryLoad
     */
    void loadCategoriesAsync(OnCategoryLoad onCategoryLoad);



    void registerFacebookUser(RegisterFacebookAccountRequest registerFacebookAccountRequest);
}
