package com.stream_pi.action_api.actionproperty.property;

import com.stream_pi.util.exception.MinorException;

public class DoubleProperty extends Property
{
    public DoubleProperty(String name)
    {
        super(name, Type.DOUBLE);
    }

    public void setMaxValue(double maxValue)
    {
        this.maxDoubleValue = maxValue;
    }

    public void setMinValue(double minValue)
    {
        this.minDoubleValue = minValue;
    }

    public void setDoubleValue(double value)
    {
        setRawValue(value+"");
    }

    public double getMaxDoubleValue()
    {
        return maxDoubleValue;
    }

    public double getMinDoubleValue()
    {
        return minDoubleValue;
    }

    public double getValue()
    {
        return Double.parseDouble(getRawValue());
    }

    public void setDefaultValue(double value)
    {
        setDefaultRawValue(value+"");
    }
}
