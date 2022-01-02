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
import com.stream_pi.action_api.i18n.I18N;
import com.stream_pi.util.exception.ActionNotFoundException;
import com.stream_pi.util.exception.ClientNotFoundException;
import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.exception.ProfileNotFoundException;

public abstract class ToggleAction extends ExternalPlugin
{
    public ToggleAction()
    {
        super(ActionType.TOGGLE);
    }

    public abstract void onToggleOn() throws MinorException;
    public abstract void onToggleOff() throws MinorException;


    private ToggleExtras toggleExtras = null;

    public void setToggleExtras(ToggleExtras toggleExtras)
    {
        this.toggleExtras = toggleExtras;
    }

    public ToggleExtras getToggleExtras()
    {
        return toggleExtras;
    }


    public void setCurrentStatus(boolean currentStatus) throws MinorException
    {
        if(getActionType() != ActionType.TOGGLE)
            throw new MinorException(I18N.getString("externalplugin.ToggleAction.actionTypeIsNotToggle"));

        toggleValueChangeChecks("setCurrentStatus");

        setCurrentToggleStatus(currentStatus);

        getToggleExtras().setToggleStatus(currentStatus, getProfileID(), getID(), getSocketAddressForClient());
    }

    public boolean getCurrentStatus() throws MinorException
    {
        if(getActionType() != ActionType.TOGGLE)
            throw new MinorException(I18N.getString("externalplugin.ToggleAction.actionTypeIsNotToggle"));

        toggleValueChangeChecks("getCurrentStatus");

        return getCurrentToggleStatus();
    }

    private void toggleValueChangeChecks(String methodName)
            throws ClientNotFoundException, ProfileNotFoundException, ActionNotFoundException
    {
        if(getSocketAddressForClient() == null)
            throw new ClientNotFoundException(I18N.getString("externalplugin.ToggleAction.methodFailedBecauseNoClientConnected", methodName));

        if(getProfileID() == null)
            throw new ProfileNotFoundException(I18N.getString("externalplugin.ToggleAction.methodFailedBecauseNoProfileAssigned", methodName));

        if(getID() == null)
            throw new ActionNotFoundException(I18N.getString("externalplugin.ToggleAction.methodFailedBecauseNoIDAssigned", methodName));
    }

    public void setToggleOnIcon(byte[] icon, boolean send) throws MinorException
    {
        addIcon("toggle_on",icon);

        if(send)
            saveIcon("toggle_on");
    }

    public void setToggleOnIcon(byte[] icon) throws MinorException
    {
        setToggleOnIcon(icon, false);
    }

    public byte[] getToggleOnIcon() throws MinorException
    {
        return getIcon("toggle_on");
    }

    public void setToggleOffIcon(byte[] icon, boolean send) throws MinorException
    {
        addIcon("toggle_off",icon);

        if(send)
            saveIcon("toggle_on");
    }

    public void setToggleOffIcon(byte[] icon) throws MinorException
    {
        setToggleOffIcon(icon, false);
    }

    public byte[] getToggleOffIcon() throws MinorException
    {
        return getIcon("toggle_off");
    }
}
