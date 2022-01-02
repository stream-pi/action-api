/*
 * Stream-Pi - Free, Open-Source, Modular, Cross-Platform and Programmable Macro Pad
 * Copyright (C) 2019-2022 Debayan Sutradhar (rnayabed),  Samuel Quiñones (SamuelQuinones)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package com.stream_pi.action_api.actionproperty.property;

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
