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

package com.stream_pi.action_api.action;

import com.stream_pi.action_api.i18n.I18N;

import java.io.Serializable;

public enum DisplayTextAlignment implements Serializable
{
    TOP, CENTER, BOTTOM;

    private static final long serialVersionUID = 2039570019687656L;

    public String getUIName()
    {
        if (this == TOP)
        {
            return I18N.getString("action.DisplayTextAlignment.top");
        }
        else if(this == CENTER)
        {
            return I18N.getString("action.DisplayTextAlignment.center");
        }
        else
        {
            return I18N.getString("action.DisplayTextAlignment.bottom");
        }
    }
}
