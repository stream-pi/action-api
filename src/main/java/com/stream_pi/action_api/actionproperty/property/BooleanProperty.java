package com.stream_pi.action_api.actionproperty.property;

public class BooleanProperty extends Property
{
    public BooleanProperty(String name)
    {
        super(name, Type.BOOLEAN);
    }

    public void setDefaultValue(boolean defaultValueBoolean)
    {
        setDefaultRawValue(defaultValueBoolean+"");
    }

    public void setValue(boolean value)
    {
        if(value)
            setRawValue("true");
        else
            setRawValue("false");
    }


    public boolean getValue()
    {
        return getRawValue().equals("true");
    }
}
