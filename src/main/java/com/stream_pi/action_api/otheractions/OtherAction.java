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

package com.stream_pi.action_api.otheractions;

import com.stream_pi.action_api.action.Action;
import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.action_api.i18n.I18N;

import java.util.ArrayList;

public class OtherAction extends Action
{
    ArrayList<Action> actions;

    public OtherAction(String name, ActionType actionType)
    {
        super(name, null, actionType);

        setCategory(I18N.getString("otheractions.OtherAction.category"));
    }

    public void setActions(ArrayList<Action> actions)
    {
        this.actions = actions;
    }

    public ArrayList<Action> getActions()
    {
        return actions;
    }
}
