package com.StreamPi.ActionAPI.NormalAction;

import com.StreamPi.ActionAPI.ActionProperty.Properties;

public abstract class CommonBackgroundService{
    private Properties properties;
    final private String moduleName;

    public CommonBackgroundService(Properties properties, String moduleName)
    {
        this.moduleName = moduleName;
        this.properties = properties;
        init();
    }

    public abstract void init();

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
