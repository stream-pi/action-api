package com.StreamPi.ActionAPI.ActionProperty;

import com.StreamPi.Util.Exception.MinorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Properties {
    private HashMap<String, String> properties;

    public Properties()
    {
        properties = new HashMap<>();
    }

    public void set(HashMap<String, String> properties)
    {
        this.properties = properties;
    }

    public void addProperty(String keyName, String property)
    {
        properties.put(keyName, property);
    }

    public Object getProperty(String propertyName) throws MinorException {
        try
        {
            return properties.get(propertyName);
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
            throw new MinorException("Cannot find property '"+propertyName+"'.");
        }
    }

    public void removeProperty(String propertyName)
    {
        properties.remove(propertyName);
    }

    public int getSize()
    {
        return properties.size();
    }

    public HashMap<String, String> get()
    {
        return properties;
    }
}
