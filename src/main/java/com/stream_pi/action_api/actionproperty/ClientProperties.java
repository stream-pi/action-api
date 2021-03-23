package com.stream_pi.action_api.actionproperty;

public class ClientProperties extends Properties implements Cloneable
{
    public ClientProperties clone() throws CloneNotSupportedException
    {
        return (ClientProperties) super.clone();
    }
}
