package com.stream_pi.action_api.normalaction;

import com.stream_pi.action_api.action.ActionType;

public abstract class NormalAction extends ExternalPlugin
{
    public NormalAction()
    {
        super(ActionType.NORMAL);
    }

    public abstract void onActionClicked() throws Exception;
}
