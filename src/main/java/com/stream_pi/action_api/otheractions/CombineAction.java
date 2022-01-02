/*
 * Stream-Pi - Free, Open-Source, Modular, Cross-Platform and Programmable Macro Pad
 * Copyright (C) 2019-2022 Debayan Sutradhar (rnayabed),  Samuel Quiñones (SamuelQuinones)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package com.stream_pi.action_api.otheractions;

import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.action_api.actionproperty.ClientProperties;
import com.stream_pi.action_api.actionproperty.property.Property;
import com.stream_pi.action_api.actionproperty.property.Type;
import com.stream_pi.action_api.i18n.I18N;
import com.stream_pi.util.exception.MinorException;

import java.util.LinkedList;
import java.util.List;


public class CombineAction extends OtherAction
{
    public CombineAction()
    {
        super(getUIName(), ActionType.COMBINE);
        setDisplayText(I18N.getString("otheractions.CombineAction.defaultDisplayText"));
        setClientProperties(new ClientProperties());
    }

    public static String getUIName()
    {
        return I18N.getString("otheractions.CombineAction.combine");
    }

    public List<String> getChildrenIDSequential() throws MinorException
    {
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

    public void removeChild(String actionID) throws MinorException
    {

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


            Property property = new Property(id+"", Type.STRING);
            property.setRawValue(ids.get(j));
            clientProperties.addProperty(property);
        }

        setClientProperties(clientProperties);

    }
}
