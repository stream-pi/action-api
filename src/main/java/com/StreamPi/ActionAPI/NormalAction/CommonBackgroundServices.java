package com.StreamPi.ActionAPI.NormalAction;


import java.util.ArrayList;

public class CommonBackgroundServices {
    private ArrayList<CommonBackgroundService> commonBackgroundServices = null;

    private static CommonBackgroundServices instance = null;

    private CommonBackgroundServices()
    {
        commonBackgroundServices = new ArrayList<>();
    }

    public void addBgService(CommonBackgroundService serverService)
    {
        if(getBgService(serverService) != null)
            commonBackgroundServices.add(serverService);
    }

    public void removeBgService(CommonBackgroundService serverService)
    {
        commonBackgroundServices.remove(serverService);
    }

    public static synchronized CommonBackgroundServices getInstance()
    {
        if(instance == null)
        {
            instance = new CommonBackgroundServices();
        }
        return instance;
    }

    public CommonBackgroundService getBgService(String serviceModuleName)
    {
        for(CommonBackgroundService s : commonBackgroundServices)
        {
            if(s.getModuleName().equals(serviceModuleName))
                return s;
        }

        return null;
    }


    public CommonBackgroundService getBgService(CommonBackgroundService serverService)
    {
        return getBgService(serverService.getModuleName());
    }
}
