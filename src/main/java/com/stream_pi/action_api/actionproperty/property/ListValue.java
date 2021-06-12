package com.stream_pi.action_api.actionproperty.property;

import java.io.Serializable;

public class ListValue implements Serializable
{
    private final Object name;
    private final String displayName;

    public ListValue(Object name)
    {
        this(name, name.toString());
    }

    public ListValue(Object name, String displayName)
    {
        this.name = name;
        this.displayName = displayName;
    }

    public Object getName()
    {
        return name;
    }

    public String getDisplayName()
    {
        return displayName;
    }
}
