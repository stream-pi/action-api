package com.stream_pi.action_api.otheractions;

import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.action_api.actionproperty.ClientProperties;
import com.stream_pi.action_api.actionproperty.property.Property;
import com.stream_pi.action_api.actionproperty.property.Type;
import com.stream_pi.util.exception.MinorException;

import java.util.LinkedList;
import java.util.List;


public class CombineAction extends OtherAction {

    public CombineAction() {
        super("Combine", ActionType.COMBINE);
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

        System.out.println("INDEX TO BE REMOVED : "+indexToBeRemoved);

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


            Property property = new Property(id+"", Type.STRING);
            property.setRawValue(ids.get(j));
            clientProperties.addProperty(property);
        }

        setClientProperties(clientProperties);

    }
}
