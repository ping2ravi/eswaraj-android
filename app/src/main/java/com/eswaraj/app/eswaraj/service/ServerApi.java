package com.eswaraj.app.eswaraj.service;

import com.eswaraj.app.eswaraj.handlers.OnDeviceRegistration;
import com.eswaraj.app.eswaraj.service.Listeners.OnCategoryLoadFromServer;
import com.eswaraj.web.dto.RegisterDeviceRequest;


/**
 * Created by Ravi on 25/11/2014.
 *
 * THis s Server API
 */
public interface ServerApi {
    void loadCategoriesAsync(OnCategoryLoadFromServer onCategoryLoadFromServer);

    void registerDevice(RegisterDeviceRequest registerDeviceRequest,OnDeviceRegistration onDeviceRegistration);
}
