package com.StreamPi.ActionAPI.OtherActions;

import com.StreamPi.ActionAPI.Action.Action;
import com.StreamPi.ActionAPI.Action.ActionType;
import com.StreamPi.ActionAPI.ActionProperty.ClientProperties;
import com.StreamPi.ActionAPI.ActionProperty.Property.ControlType;
import com.StreamPi.ActionAPI.ActionProperty.Property.Property;
import com.StreamPi.ActionAPI.ActionProperty.Property.Type;
import com.StreamPi.Util.Exception.MinorException;

import java.util.LinkedList;
import java.util.List;

public class FolderAction extends OtherAction {
    public FolderAction(String name, String ID) {
        super(name, ID, ActionType.FOLDER);

        setActionName("Folder");
        setClientProperties(new ClientProperties());
        getClientProperties().setDuplicatePropertyAllowed(true);
    }

    public List<Property> getChildrenID() throws MinorException {
        return getClientProperties().getMultipleProperties("child");
    }

    public void addChild(String actionID)
    {
        try {
            Property property = new Property("child", Type.STRING, ControlType.TEXT_FIELD);
            property.setStringValue(actionID);
            getClientProperties().addProperty(property);
        } catch (MinorException e) {
            e.printStackTrace();
        }
    }
}
