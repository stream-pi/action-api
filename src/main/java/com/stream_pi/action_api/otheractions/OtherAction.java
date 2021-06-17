package com.stream_pi.action_api.otheractions;

import com.stream_pi.action_api.action.Action;
import com.stream_pi.action_api.action.ActionType;

import java.util.ArrayList;

public class OtherAction extends Action
{
    ArrayList<Action> actions;

    public OtherAction(String name, ActionType actionType)
    {
        super(name, null, actionType);

        setCategory("Stream-Pi");
    }

    public void setActions(ArrayList<Action> actions)
    {
        this.actions = actions;
    }

    public ArrayList<Action> getActions()
    {
        return actions;
    }
}
