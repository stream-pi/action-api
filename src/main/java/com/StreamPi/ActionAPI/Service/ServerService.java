package com.StreamPi.ActionAPI.Service;

import com.StreamPi.ActionAPI.ActionProperty.Properties;
import com.StreamPi.ActionAPI.ActionProperty.Property;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class ServerService {
    private Properties properties;
    final private String moduleName;

    public ServerService(Properties properties, String moduleName)
    {
        this.moduleName = moduleName;
        this.properties = properties;
    }

    public String getModuleName()
    {
        return moduleName;
    }

    public Properties getProperties()
    {
        return properties;
    }

    public void setProperties(Properties properties)
    {
        this.properties = properties;
    }
}
