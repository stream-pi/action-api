package com.stream_pi.action_api.actionproperty.property;

import com.stream_pi.util.exception.MinorException;

public class IntegerProperty extends Property
{
    public IntegerProperty(String name)
    {
        super(name, Type.INTEGER);
    }

    public void setMaxValue(int maxValue) throws MinorException
    {
        this.maxIntValue = maxValue;
    }

    public void setMinValue(int minValue) throws MinorException
    {
        this.minIntValue = minValue;
    }

    public void setValue(int value)
    {
        setRawValue(value+"");
    }

    public int getMaxValue()
    {
        return maxIntValue;
    }

    public int getMinValue()
    {
        return minIntValue;
    }

    public int getValue()
    {
        return Integer.parseInt(getRawValue());
    }

    public void setDefaultValue(int value)
    {
        setDefaultRawValue(value+"");
    }

}
