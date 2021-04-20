package com.stream_pi.action_api.actionproperty.property;

import com.stream_pi.util.exception.MinorException;

public class StringProperty extends Property
{
    public StringProperty(String name)
    {
        super(name, Type.STRING);
    }

    public void setDefaultValue(String defaultValue) throws MinorException
    {
        if(!isCanBeBlank() && defaultValue.isBlank())
            throw new MinorException("property '"+getName()+"' is set to cannot be blank. Default property cannot be blank.");

        setDefaultRawValue(defaultValue);
    }

    public void setCanBeBlank(boolean canBeBlank) throws MinorException
    {
        if(getDefaultRawValue().isEmpty() && !canBeBlank)
        {
            throw new MinorException("No default value given.");
        }

        this.canBeBlank = canBeBlank;
    }

    public void setValue(String value)
    {
        setRawValue(value);
    }


    public String getValue()
    {
        return getRawValue();
    }
}
