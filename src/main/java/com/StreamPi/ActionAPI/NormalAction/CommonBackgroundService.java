package com.StreamPi.ActionAPI.NormalAction;

import com.StreamPi.ActionAPI.ActionProperty.ServerProperties;
import com.StreamPi.ActionAPI.ActionProperty.ClientProperties;

public abstract class CommonBackgroundService{
    private ServerProperties serverProperties;
    private ClientProperties clientProperties;
    final private String moduleName;

    public CommonBackgroundService(ServerProperties serverProperties, ClientProperties clientProperties, String moduleName)
    {
        this.moduleName = moduleName;
        this.serverProperties = serverProperties;
        this.clientProperties = clientProperties;
        init();
    }

    public abstract void init();

    public String getModuleName()
    {
        return moduleName;
    }

    public ServerProperties getServerProperties()
    {
        return serverProperties;
    }

    public ClientProperties getClientProperties()
    {
        return clientProperties;
    }

    public void setServerProperties(ServerProperties properties)
    {
        this.serverProperties = properties;
    }

    public void setClientProperties(ClientProperties properties)
    {
        this.clientProperties = properties;
    }
}
