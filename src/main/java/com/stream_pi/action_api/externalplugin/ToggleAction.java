package com.stream_pi.action_api.externalplugin;

import com.stream_pi.action_api.action.ActionType;
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

    public abstract void onToggleOn() throws Exception;
    public abstract void onToggleOff() throws Exception;


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
        toggleValueChangeChecks("setCurrentStatus");

        setCurrentToggleStatus(currentStatus);

        getToggleExtras().setToggleStatus(currentStatus, getProfileID(), getID(), getSocketAddressForClient());
    }

    public boolean getCurrentStatus() throws MinorException
    {
        toggleValueChangeChecks("getCurrentStatus");

        return getCurrentToggleStatus();
    }

    private void toggleValueChangeChecks(String methodName)
            throws ClientNotFoundException, ProfileNotFoundException, ActionNotFoundException
    {
        if(getSocketAddressForClient() == null)
            throw new ClientNotFoundException(methodName+" failed because no client connected.");

        if(getProfileID() == null)
            throw new ProfileNotFoundException(methodName+"failed because no profile assigned");

        if(getID() == null)
            throw new ActionNotFoundException(methodName+"failed because no ID assigned");
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
