package com.StreamPi.ActionAPI.NormalAction;

import com.StreamPi.ActionAPI.Action.Action;
import com.StreamPi.ActionAPI.Action.ActionType;
import com.StreamPi.ActionAPI.ActionProperty.Property.Property;
import com.StreamPi.ActionAPI.ActionProperty.Property.Type;
import com.StreamPi.Util.Version.Version;

public abstract class ToggleAction extends Action {
    private String author, repo;

    private boolean currentStatus = false;
    private String offStatusDisplayText = null;
    private String onStatusDisplayText = null;

    private byte[] offStatusIcon = null;
    private byte[] onStatusIcon = null;

    public ToggleAction(String name, String author, String repo, Version version) {
        super(ActionType.TOGGLE);
        setName(name);
        this.author = author;
        this.repo = repo;
        setVersion(version);
    }

    public void setOffStatusDisplayText(String offStatusDisplayText) {
        this.offStatusDisplayText = offStatusDisplayText;
    }

    public void setOnStatusDisplayText(String onStatusDisplayText) {
        this.onStatusDisplayText = onStatusDisplayText;
    }

    public String getOffStatusDisplayText() {
        return offStatusDisplayText;
    }

    public String getOnStatusDisplayText() {
        return onStatusDisplayText;
    }

    public void setOffStatusIcon(byte[] offStatusIcon) {
        this.offStatusIcon = offStatusIcon;
    }

    public byte[] getOffStatusIcon() {
        return offStatusIcon;
    }

    public void setOnStatusIcon(byte[] onStatusIcon) {
        this.onStatusIcon = onStatusIcon;
    }

    public byte[] getOnStatusIcon() {
        return onStatusIcon;
    }

    public void setCurrentStatus(boolean currentStatus) {
        this.currentStatus = currentStatus;
    }

    public boolean getCurrentStatus()
    {
        return currentStatus;
    }

    public ToggleAction()
    {
        super(ActionType.NORMAL);
        setModuleName(getClass().getModule().getName());
    }

    public void addServerProperties(Property... properties)
    {
        for (Property property : properties)
        {
            if(property.getType() == Type.LIST || property.getType() == Type.INTEGER || property.getType() == Type.DOUBLE)
                property.setRawValue("0");
            else if(property.getType() == Type.BOOLEAN)
                property.setRawValue("false");
            else if(property.getType() == Type.STRING)
                property.setRawValue("");

            getServerProperties().addProperty(property);
        }
    }


    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setRepo(String repo)
    {
        this.repo = repo;
    }


    public void setCommonBackgroundService(CommonBackgroundService commonBackgroundService)
    {
        CommonBackgroundServices.getInstance().addBgService(commonBackgroundService);
    }

    public CommonBackgroundService getCommonBackgroundService()
    {
        return CommonBackgroundServices.getInstance().getBgService(moduleName);
    }

    public String getAuthor()
    {
        return author;
    }

    public String getRepo()
    {
        return repo;
    }


    public abstract void initAction() throws Exception;

    public abstract void onToggleTurnedOn() throws Exception;

    public abstract void onToggleTurnedOff() throws Exception;
}
