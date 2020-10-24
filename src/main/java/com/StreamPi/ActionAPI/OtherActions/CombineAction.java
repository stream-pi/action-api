package com.StreamPi.ActionAPI.OtherActions;

import com.StreamPi.ActionAPI.Action.ActionType;
import com.StreamPi.ActionAPI.ActionProperty.ClientProperties;
import com.StreamPi.Util.Exception.MinorException;

import java.util.LinkedList;
import java.util.List;


public class CombineAction extends OtherAction {
    public CombineAction(String name, String ID, ActionType actionType) {
        super(name, ID, ActionType.COMBINE);

        setActionName("Combine");
        setClientProperties(new ClientProperties());
    }

    public List<String> getChildrenIDSequential() throws MinorException {
        int size = getClientProperties().getSize();

        LinkedList<String> children = new LinkedList<>();
        for(int i = 1;i<=size; i++)
        {
            children.add(getClientProperties().getProperty(i+"").toString());
        }

        return children;
    }

    public void addChild(String actionID, int index)
    {
        getClientProperties().addProperty(index+"", actionID);
    }

    public void addChild(String actionID)
    {
        addChild(actionID, getClientProperties().getSize()+1);
    }
}
