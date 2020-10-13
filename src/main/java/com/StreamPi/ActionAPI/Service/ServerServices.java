package com.StreamPi.ActionAPI.Service;

import com.StreamPi.Util.Exception.MinorException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ServerServices {
    ArrayList<ServerService> serverServices;

    public ServerServices()
    {
        serverServices = new ArrayList<>();
    }

    public void addService(ServerService serverService)
    {
        if(!isServicePresent(serverService))
            serverServices.add(serverService);
    }

    public boolean isServicePresent(ServerService serverService)
    {
        for(ServerService s : serverServices)
        {
            if(s.getModuleName().equals(serverService.getModuleName()))
                return true;
        }

        return false;
    }
}
