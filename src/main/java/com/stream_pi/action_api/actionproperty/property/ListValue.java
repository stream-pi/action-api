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
