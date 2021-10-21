package com.stream_pi.action_api.externalplugin;

import com.stream_pi.action_api.action.Action;
import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.action_api.action.PropertySaver;
import com.stream_pi.action_api.actionproperty.ClientProperties;
import com.stream_pi.action_api.actionproperty.property.ControlType;
import com.stream_pi.action_api.actionproperty.property.Property;
import com.stream_pi.action_api.actionproperty.property.Type;
import com.stream_pi.action_api.i18n.I18N;
import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.platform.Platform;
import com.stream_pi.util.platform.PlatformType;
import com.stream_pi.util.version.Version;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.logging.Logger;

public abstract class ExternalPlugin extends Action
{
    private String author;

    public ExternalPlugin(String name, String author, String helpLink, Version version)
    {
        super(ActionType.NORMAL);
        setName(name);
        setAuthor(author);
        setName(I18N.getString("externalplugin.ExternalPlugin.defaultDisplayText"));
        setHelpLink(helpLink);
        setVersion(version);
        setCategory(I18N.getString("externalplugin.ExternalPlugin.defaultCategory"));
    }

    private boolean visibleInPluginsPane = true;
    private boolean visibleInServerSettingsPane = true;

    public ExternalPlugin(ActionType normal)
    {
        super(normal);
        setAuthor(I18N.getString("externalplugin.ExternalPlugin.defaultAuthor"));
        setName(I18N.getString("externalplugin.ExternalPlugin.defaultDisplayText"));
        setModuleName(getClass().getModule().getName());
        setCategory(I18N.getString("externalplugin.ExternalPlugin.defaultCategory"));
    }



    public void setVisibilityInPluginsPane(boolean visibleInPluginsPane)
    {
        this.visibleInPluginsPane = visibleInPluginsPane;
    }

    public void setVisibilityInServerSettingsPane(boolean visibleInServerSettingsPane)
    {
        this.visibleInServerSettingsPane = visibleInServerSettingsPane;
    }

    public boolean isVisibleInPluginsPane()
    {
        return visibleInPluginsPane;
    }

    public boolean isVisibleInServerSettingsPane()
    {
        return visibleInServerSettingsPane;
    }


    public void addServerProperties(Property... properties) throws MinorException
    {
        addProperties(PlatformType.SERVER, properties);
    }

    private void addProperties(PlatformType platformType, Property... properties) throws MinorException
    {
        for (Property property : properties)
        {
            if(property.getType() == Type.LIST || property.getType() == Type.INTEGER || property.getType() == Type.DOUBLE)
                property.setRawValue("0");
            else if(property.getType() == Type.BOOLEAN)
                property.setRawValue("false");
            else if(property.getType() == Type.STRING)
            {
                property.setRawValue("");
                if(property.getControlType() == ControlType.FILE_PATH && property.getExtensionFilters() == null)
                {
                    throw new MinorException(I18N.getString("externalplugin.ExternalPlugin.noFileExtensionsSpecified", property.getName()));
                }
            }

            if(platformType == PlatformType.SERVER)
            {
                getServerProperties().addProperty(property);
            }
            else if(platformType == PlatformType.CLIENT)
            {
                getClientProperties().addProperty(property);
            }
        }
    }

    public void addClientProperties(Property... properties) throws MinorException
    {
        addProperties(PlatformType.CLIENT, properties);
    }


    public void setAuthor(String author)
    {
        this.author = author;
    }


    public String getAuthor()
    {
        return author;
    }


    public void initProperties() throws MinorException
    {

    }


    public void initAction() throws MinorException
    {

    }

    public void initClientActionSettingsButtonBar()
    {

    }

    public void onShutDown() throws MinorException
    {
        //Runs when server shuts down
    }

    public ExternalPlugin clone() throws CloneNotSupportedException {
        ExternalPlugin action = (ExternalPlugin) super.clone();
        action.setClientProperties(getClientProperties().clone());
        return action;
    }

    private VBox serverSettingsButtonBar = null;
    public void setServerSettingsButtonBar(Button... buttons)
    {
        serverSettingsButtonBar = new VBox(buttons);
        serverSettingsButtonBar.setSpacing(5.0);
    }

    public VBox getServerSettingsButtonBar()
    {
        return serverSettingsButtonBar;
    }

    private VBox clientActionSettingsButtonBar = null;
    public void setClientActionSettingsButtonBar(Button... buttons)
    {
        clientActionSettingsButtonBar = new VBox(buttons);
        clientActionSettingsButtonBar.setSpacing(5.0);
    }

    public VBox getClientActionSettingsButtonBar()
    {
        return clientActionSettingsButtonBar;
    }

    public void onActionCreate() throws MinorException
    {
        // This method is called when the action is first created and send to the Client
    }

    public void onActionSavedFromServer() throws MinorException
    {
        // This method is called when action is saved from the server
    }

    public void onActionDeleted() throws MinorException
    {
        // This method is called when action is deleted from client.
    }

    public void onClientDisconnected() throws MinorException
    {
        // This method is called when client is disconnected
    }

    public void onClientConnected() throws MinorException
    {
        // This method is called when client is connected
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


    public void saveClientAction(boolean sendIcons, boolean runAsync)
    {
        propertySaver.saveClientAction(getProfileID(), getID(), getSocketAddressForClient(), sendIcons, runAsync);
    }

    public void saveClientAction()
    {
        propertySaver.saveClientAction(getProfileID(), getID(), getSocketAddressForClient(), true, false);
    }

    public void saveAllIcons()
    {
        propertySaver.saveAllIcons(getProfileID(), getID(), getSocketAddressForClient());
    }

    public void saveIcon(String state)
    {
        propertySaver.saveIcon(state, getProfileID(), getID(), getSocketAddressForClient());
    }

    public void throwMinorException(MinorException exception)
    {
        getServerConnection().sendActionFailed(exception, getSocketAddressForClient(), getProfileID(), getID());
    }

    public Platform getPlatform()
    {
        return getServerConnection().getPlatform();
    }

    public void throwMinorException(String message)
    {
        throwMinorException(new MinorException(message));
    }

    public Logger getLogger()
    {
        return Logger.getLogger(getModuleName());
    }
}
