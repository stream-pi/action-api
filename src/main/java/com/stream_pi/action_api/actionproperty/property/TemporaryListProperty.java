package com.stream_pi.action_api.actionproperty.property;

import com.stream_pi.util.exception.MinorException;

import java.util.List;

public class TemporaryListProperty extends Property
{
    public TemporaryListProperty(String name)
    {
        super(name, Type.TEMPORARY_LIST);
    }

    public void setList(List<String> list)
    {
        this.list = list;
        this.rawValue = list.get(0);
    }

    public void setValue(String value)
    {
        setRawValue(value);
    }

    public String getValue()
    {
        return getRawValue();
    }

    public List<String> getList()
    {
        return list;
    }
}
