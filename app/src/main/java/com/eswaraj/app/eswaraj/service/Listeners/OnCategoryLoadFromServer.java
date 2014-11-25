package com.eswaraj.app.eswaraj.service.Listeners;

import com.eswaraj.app.eswaraj.handlers.OnCategoryLoad;
import com.eswaraj.app.eswaraj.middleware.services.LocalCacheService;
import com.eswaraj.web.dto.CategoryWithChildCategoryDto;

import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by Ravi on 25/11/2014.
 */
public class OnCategoryLoadFromServer {
    private OnCategoryLoad onCategoryLoad;
    private LocalCacheService localCacheService;
    private EventBus eventBus;
    public OnCategoryLoadFromServer(OnCategoryLoad onCategoryLoad, LocalCacheService localCacheService, EventBus eventBus){
        this.onCategoryLoad = onCategoryLoad;
        this.localCacheService = localCacheService;
        this.eventBus = eventBus;
    }
    public void onCategoryLoadSuccess(List<CategoryWithChildCategoryDto> categories){
        //If Local cache Service not null then Save it in cache
        if(localCacheService != null){
            localCacheService.saveCategoriesInCache(categories);
        }
        //If onCategoryLoad Not null then call success method
        if(onCategoryLoad != null){
            onCategoryLoad.onCategoryLoadSuccess(categories);
        }
        //if eventBus not null the post event and any listener can be notified
        if(eventBus != null){
            eventBus.post(categories);
        }
    }

    public void onCategoryLoadFail(String error){
    //If onCategoryLoad Not null then call Fail method
        if(onCategoryLoad != null){
            onCategoryLoad.onCategoryLoadFail(error);
        }
    }

}
