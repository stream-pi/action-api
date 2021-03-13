package com.stream_pi.action_api.action;

public class Icon
{
    private String state;
    private byte[] icon;

    public Icon(String state, byte[] icon)
    {
        this.state = state;
        this.icon = icon;
    }

    public String getState()
    {
        return state;
    }

    public byte[] getIcon()
    {
        return icon;
    }

    public void setIcon(byte[] icon)
    {
        this.icon = icon;
    }

    public void setState(String state)
    {
        this.state = state;
    }
}
