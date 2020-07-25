package com.StreamPi.ActionAPI;

import java.util.List;

public class Property {
    private final PropertyType propertyType;
    private Object value;

    public Property( PropertyType propertyType)
    {
        this.propertyType = propertyType;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public Object getValue()
    {
        return value;
    }

    public PropertyType getPropertyType()
    {
        return propertyType;
    }
}
