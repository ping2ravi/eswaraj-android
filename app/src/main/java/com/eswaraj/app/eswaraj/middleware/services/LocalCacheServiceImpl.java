package com.eswaraj.app.eswaraj.middleware.services;

import com.eswaraj.app.eswaraj.config.Constants;
import com.eswaraj.app.eswaraj.config.PreferenceConstants;
import com.eswaraj.app.eswaraj.helpers.SharedPreferencesHelper;
import com.eswaraj.web.dto.CategoryWithChildCategoryDto;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Ravi on 25/11/2014.
 */
public class LocalCacheServiceImpl implements LocalCacheService{
    @Inject
    SharedPreferencesHelper sharedPreferencesHelper;
    public List<CategoryWithChildCategoryDto> getAllCategories(){
        if(sharedPreferencesHelper.getBoolean(PreferenceConstants.FILE_SERVER_DATA, PreferenceConstants.DATA_AVAILABLE, false)) {
            if((new Date().getTime() - sharedPreferencesHelper.getLong(PreferenceConstants.FILE_SERVER_DATA, PreferenceConstants.DATA_DOWNLOAD_TIME_IN_MS, 0L)) < Constants.SERVER_DATA_UPDATE_INTERVAL_IN_MS) {
                //TODO return actual categories
                return null;
            }
        }
        return null;//No Local categories available
    }

    public void saveCategoriesInCache(List<CategoryWithChildCategoryDto> categories){
        //TODO implement this method
    }
}
