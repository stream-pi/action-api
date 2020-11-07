/*
ActionAPI for StreamPi
Written by Debayan Sutradhar (dubbadhar)
 */
package com.StreamPi.ActionAPI.Action;


import com.StreamPi.ActionAPI.ActionProperty.ClientProperties;
import com.StreamPi.ActionAPI.ActionProperty.ServerProperties;
import com.StreamPi.Util.Version.Version;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import org.kordamp.ikonli.javafx.FontIcon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Action {
    private ActionType actionType;
    private String name, actionName, ID;
    private Version version;
    private byte[] icon = null;
    private boolean hasIcon = false;
    private Location location = null;
    private boolean showIcon = false;


    private String fontColourHex = null;
    private String bgColourHex = null;

    private String displayText = null;
    private boolean showDisplayText = true;
    private DisplayTextAlignment displayTextAlignment = DisplayTextAlignment.CENTER;

    private Logger logger = LoggerFactory.getLogger(Action.class);

    private Node serverButtonGraphic = null;


    private ServerProperties serverProperties;
    private ClientProperties clientProperties;
    private String category;

    public String moduleName;

    public boolean invalid;

    public Action(String name, String ID, ActionType actionType)
    {
        this.serverProperties = new ServerProperties();
        this.name = name;
        setCategory("Others");
        this.ID = ID;
        this.actionType = actionType;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public void setShowDisplayText(boolean showDisplayText) {
        this.showDisplayText = showDisplayText;
    }

    public void setDisplayTextAlignment(DisplayTextAlignment displayTextAlignment) {
        this.displayTextAlignment = displayTextAlignment;
    }

    public void setFontColourHex(String fontColourHex) {
        this.fontColourHex = fontColourHex;
    }

    public String getFontColourHex() {
        return fontColourHex;
    }

    public void setBgColourHex(String bgColourHex) {
        this.bgColourHex = bgColourHex;
    }

    public String getBgColourHex() {
        return bgColourHex;
    }

    public DisplayTextAlignment getDisplayTextAlignment() {
        return displayTextAlignment;
    }

    public String getDisplayText() {
        return displayText;
    }

    public boolean isShowDisplayText()
    {
        return showDisplayText;
    }

    public void setServerButtonGraphic(String iconName)
    {
        try
        {
            this.serverButtonGraphic = new FontIcon(iconName);
        }
        catch (Exception e)
        {
            this.serverButtonGraphic = null;
            logger.error("ICON FALLBACK BECAUSE INVALID ICON SUPPLIED");
        }
    }

    public void setServerButtonGraphic(ImageView graphic)
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
        this.serverProperties = new ServerProperties();
        this.category = "Others";
        this.ID = ID;
        this.actionType = actionType;
    }

    public Action(ActionType actionType)
    {
        this.serverProperties = new ServerProperties();
        setCategory("Others");
        this.actionType = actionType;
    }

    public Action()
    {
        this.serverProperties = new ServerProperties();
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

    public void setClientProperties(ClientProperties properties)
    {
        this.clientProperties = properties;
    }

    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    public void setShowIcon(boolean value)
    {
        this.showIcon = value;
    }

    public boolean isShowIcon()
    {
        return showIcon;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setIcon(byte[] icon)
    {
        this.hasIcon = true;
        this.icon = icon;
    }

    public boolean isHasIcon()
    {
        return hasIcon;
    }

    public void setHasIcon(boolean hasIcon) {
        this.hasIcon = hasIcon;
    }

    public byte[] getIconAsByteArray() {
        return icon;
    }

    public ServerProperties getServerProperties()
    {
        return serverProperties;
    }

    public ClientProperties getClientProperties()
    {
        return clientProperties;
    }

    public String getModuleName()
    {
        return moduleName;
    }


    public void setVersion(Version version)
    {
        this.version = version;
    }


    public Version getVersion()
    {
        return version;
    }
}
