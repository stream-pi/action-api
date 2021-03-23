package com.stream_pi.action_api.actionproperty;

import com.stream_pi.action_api.actionproperty.property.Property;
import com.stream_pi.util.exception.MinorException;

import java.io.Serializable;
import java.util.*;

class Properties implements Cloneable, Serializable
{

    private List<Property> properties;
    private boolean isDuplicatePropertyAllowed;

    public Properties()
    {
        properties = new ArrayList<>();
    }

    public Properties(List<Property> properties)
    {
        this.properties = properties;
    }

    public void set(List<Property> properties)
    {
        this.properties = properties;
    }

    public void setDuplicatePropertyAllowed(boolean value)
    {
        isDuplicatePropertyAllowed = value;
    }

    public boolean isDuplicatePropertyAllowed()
    {
        return isDuplicatePropertyAllowed;
    }

    public void addProperty(Property property) {
        if(!isDuplicatePropertyAllowed)
            removeProperty(property.getName());

        properties.add(property.chaap());
    }

    public void clear()
    {
        properties.clear();
    }

    public void set(Properties properties)
    {
        this.properties = properties.get();
    }

    public int getPropertyIndex(String name) {
        for (int i=0; i<properties.size(); i++)
        {
            if (properties.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Property getSingleProperty(String propertyName) throws MinorException {
        if(isDuplicatePropertyAllowed)
            throw new MinorException("DO NOT USE THIS");

        int index = getPropertyIndex(propertyName);
        if(index == -1)
            return null;
        else
            return properties.get(index);
    }

    public List<Property> getMultipleProperties(String propertyName){
        ArrayList<Property> tbr = new ArrayList<>();

        for(Property property : properties)
        {
            if(property.getName().equals(propertyName))
                tbr.add(property);
        }

        return tbr;
    }

    public void removeProperty(String propertyName)
    {
        int index = getPropertyIndex(propertyName);
        if(index!=-1)
            properties.remove(index);
    }

    public List<Property> get()
    {
        return properties;
    }

    // TODO: What is this method doing?
    public List<String> getNames()
    {
        ArrayList<String> names = new ArrayList<>();
        for(Property property : properties)
        {
            if(!names.contains(property.getName()))
                names.add(property.getName());
        }
        return names;
    }

    public int getSize()
    {
        return properties.size();
    }

    public Properties clone() throws CloneNotSupportedException
    {
        Properties tbr = (Properties) super.clone();

        List<Property> newList = new ArrayList<>();

        for(Property eachProperty : properties)
        {
            newList.add(eachProperty.chaap());
        }

        tbr.set(newList);

        return tbr;
    }
}
