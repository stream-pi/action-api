package com.stream_pi.action_api.normalaction;

import com.stream_pi.action_api.action.ActionType;

public abstract class ToggleAction extends ExternalPlugin
{
    public ToggleAction()
    {
        super(ActionType.TOGGLE);
    }

    public abstract void onToggleOn() throws Exception;
    public abstract void onToggleOff() throws Exception;
}
