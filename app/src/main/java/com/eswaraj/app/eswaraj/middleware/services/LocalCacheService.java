package com.eswaraj.app.eswaraj.middleware.services;

import com.eswaraj.web.dto.CategoryWithChildCategoryDto;

import java.util.List;

/**
 * This is a service to handle cache but Must not be used in any activity Directly
 * always use it via MiddlewareService Methods
 * Created by Ravi on 25/11/2014.
 */
public interface LocalCacheService {
    List<CategoryWithChildCategoryDto> getAllCategories();

    void saveCategoriesInCache(List<CategoryWithChildCategoryDto> categories);
}
