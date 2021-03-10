package com.stream_pi.action_api.actionproperty.property;

import java.io.Serializable;

public class FileExtensionFilter implements Serializable
{
    private final String description;
    private final String[] extensions;

    public FileExtensionFilter(String description, String... extensions)
    {
        this.description = description;
        this.extensions = extensions;
    }

    public String getDescription()
    {
        return description;
    }

    public String[] getExtensions()
    {
        return extensions;
    }
}
