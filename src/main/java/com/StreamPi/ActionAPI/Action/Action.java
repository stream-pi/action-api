/*
ActionAPI for StreamPi
Written by Debayan Sutradhar (dubbadhar)
 */
package com.StreamPi.ActionAPI.Action;


import com.StreamPi.ActionAPI.ActionProperty.Properties;
import javafx.scene.Node;
import javafx.scene.image.Image;

import java.util.UUID;

public class Action {
    private ActionType actionType;
    private String name, actionName, ID;
    private Image icon = null;
    private Location location = null;
    private boolean hasIcon = false;

    private Node serverButtonGraphic = null;


    private Properties properties;
    private String category;

    public String moduleName;

    public boolean invalid;

    public Action(String name, String ID, ActionType actionType)
    {
        this.name = name;
        setCategory("Others");
        this.ID = ID;
        this.actionType = actionType;
    }

    public void setServerButtonGraphic(Node graphic)
    {
        this.serverButtonGraphic = graphic;
    }

    public Node getServerButtonGraphic()
    {
        return serverButtonGraphic;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public Action(String ID, ActionType actionType)
    {
        this.category = "Others";
        this.ID = ID;
        this.actionType = actionType;
    }

    public Action(ActionType actionType)
    {
        setCategory("Others");
        this.actionType = actionType;
    }

    public void setIDRandom()
    {
        setID(UUID.randomUUID().toString());
    }


    public void setActionName(String actionName)
    {
        this.actionName = actionName;
    }

    public String getActionName()
    {
        return actionName;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getCategory()
    {
        return category;
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

    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    public void setHasIcon(boolean value)
    {
        hasIcon = value;
    }

    public boolean isHasIcon()
    {
        return hasIcon;
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

    public String getModuleName()
    {
        return moduleName;
    }
}
