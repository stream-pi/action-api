/*
ActionAPI for StreamPi
Written by Debayan Sutradhar (dubbadhar)
 */
package com.StreamPi.ActionAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ServiceLoader;

public abstract class Action {
    final ActionType actionType;
    final String name, author, repo, version, description, ID;

    final String moduleName = getClass().getModule().getName();

    public Action(String name, String ID, String author, String repo, String version, String description, ActionType actionType)
    {
        this.name = name;
        this.author = author;
        this.repo = repo;
        this.version = version;
        this.description = description;
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

    public String getAuthor()
    {
        return author;
    }

    public String getRepo()
    {
        return repo;
    }

    public String getVersion()
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

    public abstract void actionOnServer();
}
