package com.StreamPi.ActionAPI.ActionProperty;

import com.StreamPi.Util.Exception.MinorException;

import java.util.HashMap;

public class Properties {
    private HashMap<String, Property> properties;
    boolean finalize = false;

    public void addProperty(String propertyName, Property property) throws MinorException {
        if(finalize)
            throw new MinorException("Cannot add new properties");

        properties.put(propertyName, property);
    }

    public void setPropertyValue(String propertyName, Property property)
    {
        properties.replace(propertyName, property);
    }

    public Property getProperty(String propertyName) throws MinorException {
        try
        {
            return properties.get(propertyName);
        }
        catch (Exception e)
        {
            throw new MinorException("Unable to get property '"+propertyName+"'. Check stacktrace! ");
        }
    }

    public void removeProperty(String propertyName, Property property) throws MinorException {
        if(finalize)
            throw new MinorException("Cannot add new properties");

        properties.remove(propertyName);
    }

    public void finalizeProperties()
    {
        finalize = true;
    }
}
