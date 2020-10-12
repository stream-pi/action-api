package com.StreamPi.ActionAPI.NormalAction;

import com.StreamPi.ActionAPI.Action.Action;
import com.StreamPi.ActionAPI.Action.ActionType;
import com.StreamPi.ActionAPI.ActionProperty.Properties;
import com.StreamPi.Util.Version.Version;

public abstract class NormalAction extends Action {

    final String author, repo, description;

    final Version version;

    private final Properties properties;

    final String moduleName = getClass().getModule().getName();

    public NormalAction(String name, String ID, String author, String repo, Version version, String description, Properties properties) {
        super(name, ID, ActionType.NORMAL);

        this.author = author;
        this.repo = repo;
        this.description = description;
        this.version = version;
        this.properties = properties;

        properties.finalizeProperties();
    }

    public String getAuthor()
    {
        return author;
    }

    public String getRepo()
    {
        return repo;
    }

    public String getDescription()
    {
        return description;
    }

    public Version getVersion()
    {
        return version;
    }

    public Properties getProperties()
    {
        return properties;
    }

    public String getModuleName() {
        return moduleName;
    }

    public abstract void onActionClicked();
}
