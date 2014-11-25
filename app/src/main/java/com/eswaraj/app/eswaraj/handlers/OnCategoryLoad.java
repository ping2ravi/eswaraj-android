package com.eswaraj.app.eswaraj.handlers;

import com.eswaraj.web.dto.CategoryWithChildCategoryDto;

import java.util.List;

/**
 * Created by Ravi on 25/11/2014.
 */
public interface OnCategoryLoad {

    void onCategoryLoadSuccess(List<CategoryWithChildCategoryDto> categories);

    void onCategoryLoadFail(String error);
}
