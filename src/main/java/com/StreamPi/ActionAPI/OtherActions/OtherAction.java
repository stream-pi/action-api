package com.StreamPi.ActionAPI.OtherActions;

import com.StreamPi.ActionAPI.Action.Action;
import com.StreamPi.ActionAPI.Action.ActionType;

import java.util.ArrayList;

public class OtherAction extends Action{
    ArrayList<Action> actions;

    public OtherAction(String name, String ID, ActionType actionType) {
        super(name, ID, actionType);
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
