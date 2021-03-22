package com.stream_pi.action_api.externalplugin;

import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.util.exception.MinorException;

public abstract class ToggleAction extends ExternalPlugin
{
    public ToggleAction()
    {
        super(ActionType.TOGGLE);
    }

    public abstract void onToggleOn() throws Exception;
    public abstract void onToggleOff() throws Exception;

    public void setToggleOnIcon(byte[] icon, boolean send) throws MinorException
    {
        addIcon("toggle_on",icon);

        if(send)
            saveIcon("toggle_on");
    }

    public void setToggleOnIcon(byte[] icon) throws MinorException
    {
        setToggleOnIcon(icon, true);
    }

    public byte[] getToggleOnIcon() throws MinorException
    {
        return getIcon("toggle_on");
    }

    public void setToggleOffIcon(byte[] icon, boolean send) throws MinorException
    {
        addIcon("toggle_off",icon);

        if(send)
            saveIcon("toggle_on");
    }

    public void setToggleOffIcon(byte[] icon) throws MinorException
    {
        setToggleOffIcon(icon, true);
    }

    public byte[] getToggleOffIcon() throws MinorException
    {
        return getIcon("toggle_off");
    }
}
