/*
ActionAPI for StreamPi
Written by Debayan Sutradhar (dubbadhar)
 */
package com.StreamPi.ActionAPI;

import com.StreamPi.Util.Version.Version;

import java.util.*;

public abstract class Action {
    final ActionType actionType;
    final String name, author, repo, description, ID;

    final Version version;

    private final Properties properties;

    final String moduleName = getClass().getModule().getName();

    public Action(String name, String ID, String author, String repo, Version version, String description, ActionType actionType, Properties properties)
    {
        this.name = name;
        this.author = author;
        this.repo = repo;
        this.version = version;
        this.description = description;
        this.ID = ID;
        this.actionType = actionType;
        this.properties = properties;

        properties.finalizeProperties();
    }

    public ActionType getActionType() {
        return actionType;
    }

    public String getName()
    {
        return name;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getRepo()
    {
        return repo;
    }

    public Version getVersion()
    {
        return version;
    }

    public String getDescription()
    {
        return description;
    }

    public String getModuleName() {
        return moduleName;
    }

    public Properties getProperties()
    {
        return properties;
    }

    public abstract void actionOnServer();
}
