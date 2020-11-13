package com.StreamPi.ActionAPI.OtherActions;

import com.StreamPi.ActionAPI.Action.ActionType;
import com.StreamPi.ActionAPI.ActionProperty.ClientProperties;
import com.StreamPi.ActionAPI.ActionProperty.Property.ControlType;
import com.StreamPi.ActionAPI.ActionProperty.Property.Property;
import com.StreamPi.ActionAPI.ActionProperty.Property.Type;
import com.StreamPi.Util.Exception.MinorException;

import java.util.LinkedList;
import java.util.List;


public class CombineAction extends OtherAction {

    public CombineAction() {
        super("Combine", null, ActionType.COMBINE);
        setDisplayText("Combine");
        setClientProperties(new ClientProperties());
    }

    public List<String> getChildrenIDSequential() throws MinorException {
        int size = getClientProperties().getSize();

        LinkedList<String> children = new LinkedList<>();
        for(int i = 0;i<size; i++)
        {
            children.add(getClientProperties().getSingleProperty(i+"").getRawValue());
        }

        return children;
    }

    public void addChild(String actionID, int index)
    {
        try {
            Property property = new Property(index+"", Type.STRING);
            property.setStringValue(actionID);
            getClientProperties().addProperty(property);
        } catch (MinorException e) {
            e.printStackTrace();
        }
    }

    public void addChild(String actionID)
    {
        addChild(actionID, getClientProperties().getSize());
    }

    public void removeChild(String actionID) throws MinorException {

        int indexToBeRemoved = 0;

        List<String> ids = getChildrenIDSequential();

        for(int i = 0;i<ids.size();i++)
        {
            if(ids.get(i).equals(actionID))
                indexToBeRemoved = i;
        }

        ClientProperties clientProperties = new ClientProperties();

        for(int i =0;i<indexToBeRemoved;i++)
        {
            Property property = new Property(i+"",Type.STRING);
            property.setRawValue(ids.get(i));
            clientProperties.addProperty(property);
        }

        for(int j = (indexToBeRemoved+1); j<ids.size();j++)
        {
            String id = (j-1)+"";
            if(indexToBeRemoved == 0)
                id= j+"";

            Property property = new Property(id+"", Type.STRING);
            property.setRawValue(ids.get(j));
            clientProperties.addProperty(property);
        }

        setClientProperties(clientProperties);

    }
}
