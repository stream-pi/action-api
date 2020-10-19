package com.StreamPi.ActionAPI.ActionProperty;

import com.StreamPi.Util.Exception.MinorException;

import java.util.ArrayList;
import java.util.HashMap;

public class Properties {
    private ArrayList<Property> properties;

    public void addProperty(Property property)
    {
        properties.add(property);
    }

    public Property getProperty(String propertyName) throws MinorException {

        for(Property property : properties)
        {
            if(property.getName().equals(propertyName))
                return property;
        }

        throw new MinorException("Cannot find property '"+propertyName+"'.");
    }

    public void removeProperty(Property property)
    {
        properties.remove(property);
    }

    public int getSize()
    {
        return properties.size();
    }

    public ArrayList<Property> get()
    {
        return properties;
    }
}
