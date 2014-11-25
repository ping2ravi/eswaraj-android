package com.eswaraj.app.eswaraj.service.local;

import com.eswaraj.app.eswaraj.handlers.OnDeviceRegistration;
import com.eswaraj.app.eswaraj.service.Listeners.OnCategoryLoadFromServer;
import com.eswaraj.app.eswaraj.service.ServerApi;
import com.eswaraj.web.dto.CategoryWithChildCategoryDto;
import com.eswaraj.web.dto.RegisterDeviceRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi on 25/11/2014.
 */
public class LocalServerApiImpl implements ServerApi{
    public void loadCategoriesAsync(OnCategoryLoadFromServer onCategoryLoadFromServer) throws Exception{
        List<CategoryWithChildCategoryDto> allCategories = new ArrayList<CategoryWithChildCategoryDto>();
        Long id = 1L;
        CategoryWithChildCategoryDto waterCategory = createCategory(id++,"Water","Water Category","https://s3-us-west-2.amazonaws.com/eswaraj-dev/mobile/images/ic_issue_water.png","https://s3-us-west-2.amazonaws.com/eswaraj-dev/mobile/images/banner_water.png", null);
        CategoryWithChildCategoryDto waterSubCategory1 = createCategory(id++,"No 24 Water","No Water Category","","", waterCategory);
        CategoryWithChildCategoryDto waterSubCategory2 = createCategory(id++,"Poor caliberation of water meters","No Water Category","","", waterCategory);
        onCategoryLoadFromServer.onCategoryLoadSuccess(allCategories);
    }
    private CategoryWithChildCategoryDto createCategory(Long id,String name, String description, String imageUrl, String headerImageUrl, CategoryWithChildCategoryDto parent){
        CategoryWithChildCategoryDto category = new CategoryWithChildCategoryDto();
        category.setDescription(description);
        category.setId(id);
        category.setName(name);
        category.setHeaderImageUrl(headerImageUrl);
        category.setImageUrl(imageUrl);
        if(parent == null){
            category.setRoot(true);
        }else{
            category.setRoot(false);
            if(parent.getChildCategories() == null){
                parent.setChildCategories(new ArrayList<CategoryWithChildCategoryDto>());
            }
            parent.getChildCategories().add(category);
        }

        return category;
    }

    public void registerDevice(RegisterDeviceRequest registerDeviceRequest,OnDeviceRegistration onDeviceRegistration) throws Exception{

    }
}
