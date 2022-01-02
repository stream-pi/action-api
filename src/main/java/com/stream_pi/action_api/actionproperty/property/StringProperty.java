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
