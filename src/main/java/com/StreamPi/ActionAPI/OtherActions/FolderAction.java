package com.StreamPi.ActionAPI.OtherActions;

import com.StreamPi.ActionAPI.Action.Action;
import com.StreamPi.ActionAPI.Action.ActionType;
import com.StreamPi.ActionAPI.ActionProperty.ClientProperties;
import com.StreamPi.Util.Exception.MinorException;

import java.util.LinkedList;
import java.util.List;

public class FolderAction extends OtherAction {
    public FolderAction(String name, String ID) {
        super(name, ID, ActionType.FOLDER);

        setActionName("Folder");
        setClientProperties(new ClientProperties());
    }

    public List<String> getChildrenID() throws MinorException {

        return new LinkedList<>(getClientProperties().getKeySet());
    }

    public void addChild(String actionID)
    {
        getClientProperties().addProperty(actionID, "");
    }
}
