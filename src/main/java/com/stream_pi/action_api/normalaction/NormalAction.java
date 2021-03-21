package com.stream_pi.action_api.normalaction;

import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.util.exception.MinorException;

public abstract class NormalAction extends ExternalPlugin
{
    public NormalAction()
    {
        super(ActionType.NORMAL);
    }

    public abstract void onActionClicked() throws Exception;

    public void setDefaultIcon(byte[] icon, boolean sync) throws MinorException
    {
        addIcon("default",icon);

        if(sync)
            saveIcon("toggle_on");
    }

    public void setDefaultIcon(byte[] icon) throws MinorException
    {
        setDefaultIcon(icon, true);
    }

    public byte[] getDefaultIcon() throws MinorException
    {

        return getIcon("default");
    }
}
