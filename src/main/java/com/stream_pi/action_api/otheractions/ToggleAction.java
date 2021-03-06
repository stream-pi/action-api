package com.stream_pi.action_api.otheractions;

import com.stream_pi.action_api.action.ActionType;

public class ToggleAction extends OtherAction
{
    public ToggleAction()
    {
        super("Toggle", ActionType.TOGGLE);
        setDisplayText("OFF");
    }
}
