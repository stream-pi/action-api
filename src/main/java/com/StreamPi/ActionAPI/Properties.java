package com.StreamPi.ActionAPI;

import java.util.HashMap;

public class Properties {
    private HashMap<String, Property> properties;
    boolean finalize = false;

    public void addProperty(String propertyName, Property property)
    {
        if(finalize)
            throw new UnsupportedOperationException("Cannot add new properties");

        properties.put(propertyName, property);
    }

    public void setPropertyValue(String propertyName, Property property)
    {
        properties.replace(propertyName, property);
    }

    public Property getProperty(String propertyName)
    {
        return properties.get(propertyName);
    }

    public void removeProperty(String propertyName, Property property)
    {
        if(finalize)
            throw new UnsupportedOperationException("Cannot add new properties");

        properties.remove(propertyName);
    }

    public void finalizeProperties()
    {
        finalize = true;
    }
}
