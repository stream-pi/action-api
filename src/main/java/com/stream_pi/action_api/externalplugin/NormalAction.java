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

package com.stream_pi.action_api.externalplugin;

import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.util.exception.MinorException;

public abstract class NormalAction extends ExternalPlugin
{
    public NormalAction()
    {
        super(ActionType.NORMAL);
    }

    public void onActionClicked() throws MinorException
    {
        // This method is called when Action is clicked
    }

    public void setDefaultIcon(byte[] icon, boolean send)
    {
        addIcon("default",icon);

        if(send)
            saveIcon("default");
    }

    public void setDefaultIcon(byte[] icon)
    {
        setDefaultIcon(icon, true);
    }

    public byte[] getDefaultIcon()
    {

        return getIcon("default");
    }
}
