package com.stream_pi.action_api.actionproperty;

public class ServerProperties extends Properties implements Cloneable
{
    public ServerProperties clone() throws CloneNotSupportedException
    {
        return (ServerProperties) super.clone();
    }
}
