package com.stream_pi.action_api.actionproperty.property;

public class ListValue
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
