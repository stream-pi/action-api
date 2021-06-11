package com.stream_pi.action_api.actionproperty.property;

import com.stream_pi.util.exception.MinorException;

import java.util.List;

public class ListProperty extends Property
{
    public ListProperty(String name)
    {
        super(name, Type.LIST);
    }

    public void setValue(List<ListValue> list)
    {
        this.list = list;
        this.rawValue = "0";
    }

    public void setDefaultSelectedIndex(int index)
    {
        setDefaultRawValue(index+"");
    }

    public void setSelectedIndex(int index)
    {
        this.rawValue = index+"";
    }

    public int getSelectedIndex()
    {
        return Integer.parseInt(this.rawValue);
    }


    public List<ListValue> getList()
    {
        return list;
    }
}
