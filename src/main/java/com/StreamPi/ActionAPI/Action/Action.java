/*
ActionAPI for StreamPi
Written by Debayan Sutradhar (dubbadhar)
 */
package com.StreamPi.ActionAPI.Action;


import com.StreamPi.ActionAPI.ActionProperty.Properties;
import javafx.scene.image.Image;

public class Action {
    private final ActionType actionType;
    private String name, ID;
    private Image icon = null;
    private Location location = null;

    public Properties properties;

    public Action(String name, String ID, ActionType actionType)
    {
        this.name = name;
        this.ID = ID;
        this.actionType = actionType;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getID()
    {
        return ID;
    }

    public void setProperties(Properties properties)
    {
        this.properties = properties;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setIcon(Image icon)
    {
        this.icon = icon;
    }

    public Image getIcon() {
        return icon;
    }

    public Properties getProperties()
    {
        return properties;
    }
}
