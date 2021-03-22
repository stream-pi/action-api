package com.stream_pi.action_api.externalplugin;

import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.util.exception.MinorException;

public abstract class NormalAction extends ExternalPlugin
{
    public NormalAction()
    {
        super(ActionType.NORMAL);
    }

    public abstract void onActionClicked() throws Exception;

    public void setDefaultIcon(byte[] icon, boolean send) throws MinorException
    {
        addIcon("default",icon);

        if(send)
            saveIcon("toggle_on");
    }

    public void setDefaultIcon(byte[] icon) throws MinorException
    {
        setDefaultIcon(icon, false);
    }

    public byte[] getDefaultIcon() throws MinorException
    {

        return getIcon("default");
    }
}
