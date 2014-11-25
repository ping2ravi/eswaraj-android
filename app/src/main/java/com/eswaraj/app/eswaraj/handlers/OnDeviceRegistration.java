package com.eswaraj.app.eswaraj.handlers;


import com.eswaraj.web.dto.UserDto;

public interface OnDeviceRegistration {

    public void onDeviceRegistrationSuccess(UserDto userDto);

    public void onDeviceRegistrationFail(String error);
}
