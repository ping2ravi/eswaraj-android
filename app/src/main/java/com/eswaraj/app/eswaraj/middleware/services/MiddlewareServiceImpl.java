package com.eswaraj.app.eswaraj.middleware.services;

import com.eswaraj.app.eswaraj.handlers.OnCategoryLoad;
import com.eswaraj.app.eswaraj.service.Listeners.OnCategoryLoadFromServer;
import com.eswaraj.app.eswaraj.service.ServerApi;
import com.eswaraj.web.dto.CategoryWithChildCategoryDto;
import com.eswaraj.web.dto.RegisterFacebookAccountRequest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import de.greenrobot.event.EventBus;

/**
 * Created by Ravi on 25/11/2014.
 */
public class MiddlewareServiceImpl implements  MiddlewareService{

    @Inject
    ServerApi serverApi;
    @Inject
    LocalCacheService localCacheService;
    @Inject @Named("default")
    EventBus eventBus;



    public void loadCategoriesAsync(OnCategoryLoad onCategoryLoad){
        List<CategoryWithChildCategoryDto> cachedCategories = localCacheService.getAllCategories();
        if(cachedCategories != null){
            onCategoryLoad.onCategoryLoadSuccess(cachedCategories);
            return;
        }
        OnCategoryLoadFromServer onCategoryLoadFromServer = new OnCategoryLoadFromServer(onCategoryLoad, localCacheService, eventBus);
        serverApi.loadCategoriesAsync(onCategoryLoadFromServer);
    }

    public void registerFacebookUser(RegisterFacebookAccountRequest registerFacebookAccountRequest){

    }
}
