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

import com.stream_pi.action_api.action.Action;
import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.action_api.action.ServerConnection;
import com.stream_pi.action_api.actionproperty.property.ControlType;
import com.stream_pi.action_api.actionproperty.property.Property;
import com.stream_pi.action_api.actionproperty.property.Type;
import com.stream_pi.action_api.externalplugin.inputevent.StreamPiInputEvent;
import com.stream_pi.action_api.i18n.I18N;
import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.platform.Platform;
import com.stream_pi.util.platform.PlatformType;
import com.stream_pi.util.version.Version;
import javafx.application.HostServices;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.*;
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

    public void onServerPropertiesSavedByUser() throws MinorException
    {

    }

    public void initClientActionSettingsButtonBar()
    {

    }

    public void onShutDown() throws MinorException
    {
        //Runs when server shuts down
    }

    public ExternalPlugin clone() throws CloneNotSupportedException
    {
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

    private Node[] serverSettingsNodes = null;
    public void setServerSettingsNodes(Node... nodes)
    {
        serverSettingsNodes = nodes;
    }

    public Node[] getServerSettingsNodes()
    {
        return serverSettingsNodes;
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
        // This method is called when the action is first created and send to the client
    }

    public void onActionSavedFromServer() throws MinorException
    {
        // This method is called when action is saved from the server
    }

    public void onActionDeleted() throws MinorException
    {
        // This method is called when action is deleted from client
    }

    public void onClientDisconnected() throws MinorException
    {
        // This method is called when client is disconnected
    }

    public void onClientConnected() throws MinorException
    {
        // This method is called when client is connected
    }

    private ServerConnection serverConnection = null;

    public void setServerConnection(ServerConnection serverConnection)
    {
        this.serverConnection = serverConnection;
    }

    public void saveServerProperties()
    {
        serverConnection.saveServerProperties(getUniqueID());
    }

    public boolean saveServerPropertiesProvidedByUser()
    {
        return serverConnection.saveServerPropertiesProvidedByUser(getUniqueID());
    }

    public void saveClientAction(boolean sendIcons, boolean runAsync)
    {
        serverConnection.saveClientAction(getProfileID(), getID(), getSocketAddressForClient(), sendIcons, runAsync);
    }

    public void saveClientAction()
    {
        serverConnection.saveClientAction(getProfileID(), getID(), getSocketAddressForClient(), true, false);
    }

    public void updateTemporaryDisplayText(String displayText) throws MinorException
    {
        serverConnection.updateTemporaryDisplayText(getProfileID(), getID(), getSocketAddressForClient(), displayText);
    }

    public void saveAllIcons()
    {
        serverConnection.saveAllIcons(getProfileID(), getID(), getSocketAddressForClient());
    }

    public void saveIcon(String state)
    {
        serverConnection.saveIcon(state, getProfileID(), getID(), getSocketAddressForClient());
    }

    public void throwMinorException(MinorException exception)
    {
        serverConnection.sendActionFailed(exception, getSocketAddressForClient(), getProfileID(), this);
    }

    public Platform getPlatform()
    {
        return serverConnection.getPlatform();
    }

    public void throwMinorException(String message)
    {
        throwMinorException(new MinorException(message));
    }

    public Logger getLogger()
    {
        return Logger.getLogger(getClass().getCanonicalName());
    }

    public Locale getCurrentLanguageLocale()
    {
        return serverConnection.getCurrentLanguageLocale();
    }

    public Future<?> submitToExecutorService(Runnable command)
    {
        return serverConnection.getExecutorService().submit(command);
    }

    public Future<?> submitToExecutorService(Callable<?> callable)
    {
        return serverConnection.getExecutorService().submit(callable);
    }

    public Future<?> submitToExecutorService(Runnable task, Object result)
    {
        return serverConnection.getExecutorService().submit(task, result);
    }

    public HostServices getHostServices()
    {
        return serverConnection.getHostServices();
    }

    public void onInputEventReceived(StreamPiInputEvent streamPiInputEvent) throws MinorException
    {
        // This method is called when a InputEvent is received from the client
    }

    public boolean isConnectedToClient()
    {
        return serverConnection.isConnected(getSocketAddressForClient());
    }
}
