/*
ActionAPI for StreamPi
Written by Debayan Sutradhar (dubbadhar)
 */
package com.stream_pi.action_api.action;

import com.stream_pi.action_api.actionproperty.ClientProperties;
import com.stream_pi.action_api.actionproperty.ServerProperties;
import com.stream_pi.util.version.Version;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import org.kordamp.ikonli.javafx.FontIcon;

import java.io.Serializable;
import java.util.UUID;

public class Action implements Cloneable, Serializable
{
    private ActionType actionType=null;
    private String name ="Unknown action", ID=null;
    private Version version=new Version(0,0,0);
    private byte[] icon = null;
    private boolean hasIcon = false;
    private Location location = null;
    private boolean showIcon = false;
    private String parent = null;

    private int delayBeforeExecuting = 0;

    public void setDelayBeforeExecuting(int delayBeforeExecuting)
    {
        this.delayBeforeExecuting = delayBeforeExecuting;
    }

    public int getDelayBeforeExecuting()
    {
        return delayBeforeExecuting;
    }

    private static final DataFormat dataFormat = new DataFormat("com.stream_pi.action_api.action");

    public static DataFormat getDataFormat() {
        return dataFormat;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getParent() {
        return parent;
    }

    private String displayTextFontColourHex = null;
    private String bgColourHex = null;
    private String displayText = null;
    private boolean showDisplayText = true;
    private DisplayTextAlignment displayTextAlignment = DisplayTextAlignment.CENTER;

    private Node serverButtonGraphic = null;

    private String helpLink = null;

    public String getHelpLink()
    {
        return helpLink;
    }

    public void setHelpLink(String helpLink)
    {
        this.helpLink = helpLink;
    }

    private ServerProperties serverProperties;
    private ClientProperties clientProperties;
    private String category;

    public String moduleName;

    public boolean invalid;

    public Action(String name, String ID, ActionType actionType)
    {
        this.serverProperties = new ServerProperties();
        this.clientProperties = new ClientProperties();
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

    public void setDisplayTextFontColourHex(String displayTextFontColourHex) {
        this.displayTextFontColourHex = displayTextFontColourHex;
    }

    public String getDisplayTextFontColourHex() {
        return displayTextFontColourHex;
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
        this.clientProperties = new ClientProperties();
        this.category = "Others";
        this.ID = ID;
        this.actionType = actionType;
    }

    public Action(ActionType actionType)
    {
        this.serverProperties = new ServerProperties();
        this.clientProperties = new ClientProperties();
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

    public Action clone() throws CloneNotSupportedException {
        Action action = (Action) super.clone();
        action.setClientProperties((ClientProperties) action.getClientProperties().clone());
        return action;
    }

    private PropertySaver propertySaver = null;

    public void setPropertySaver(PropertySaver propertySaver)
    {
        this.propertySaver = propertySaver;
    }

    public void saveServerProperties()
    {
        propertySaver.saveServerProperties();
    }
    
    private ServerConnection serverConnection = null;

    public void setServerConnection(ServerConnection serverConnection)
    {
        this.serverConnection = serverConnection;
    }

    public ServerConnection getServerConnection()
    {
        return serverConnection;
    }
}
