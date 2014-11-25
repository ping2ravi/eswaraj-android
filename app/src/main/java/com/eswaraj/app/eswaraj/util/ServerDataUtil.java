package com.eswaraj.app.eswaraj.util;

import com.eswaraj.app.eswaraj.config.ServerAccessEnums;
import com.eswaraj.app.eswaraj.datastore.Cache;
import com.eswaraj.app.eswaraj.datastore.Server;
import com.eswaraj.app.eswaraj.helpers.SharedPreferencesHelper;
import com.eswaraj.app.eswaraj.interfaces.ServerDataInterface;
/*
TODO This CLASS NEED TO BE DELETED
 */
@Deprecated
public class ServerDataUtil {
    private Cache cache;
    private Server server;

    public ServerDataUtil(ServerDataInterface context, SharedPreferencesHelper sharedPreferencesHelper) {
        this.cache = Cache.getInstance();
        this.server = Server.getInstance();
    }

    public void getData(ServerAccessEnums resource, Boolean dontGetFromCache) {

    }
}
