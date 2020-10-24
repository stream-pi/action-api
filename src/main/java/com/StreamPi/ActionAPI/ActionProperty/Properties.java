package com.StreamPi.ActionAPI.ActionProperty;

import com.StreamPi.Util.Exception.MinorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Set;

class Properties {
    private HashMap<String, String> properties;

    public Properties()
    {
        properties = new HashMap<>();
    }

    public Properties(String... propertyNames)
    {
        properties = new HashMap<>();

        for(String each : propertyNames)
        {
            properties.put(each, null);
        }
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

    private HashMap<String, String> get()
    {
        return properties;
    }

    public Set<String> getKeySet()
    {
        return properties.keySet();
    }

    public int getSize()
    {
        return properties.size();
    }
}
