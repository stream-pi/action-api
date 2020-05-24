package com.StreamPi.ActionAPI;

import java.util.HashMap;

public abstract class Action {
    String name, author, repo, version, description, ID;

    final String versionPlugin = "0.0.1";

    public Action(String name, String ID, String author, String repo, String version, String description)
    {
        this.name = name;
        this.author = author;
        this.repo = repo;
        this.version = version;
        this.description = description;
        this.ID = ID;
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

    public abstract void actionOnServer();
}
