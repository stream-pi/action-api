package com.StreamPi.ActionAPI.NormalAction;

import com.StreamPi.ActionAPI.Action.Action;
import com.StreamPi.ActionAPI.Action.ActionType;
import com.StreamPi.ActionAPI.ActionProperty.Property.Property;
import com.StreamPi.ActionAPI.ActionProperty.Property.Type;
import com.StreamPi.Util.Exception.MinorException;
import com.StreamPi.Util.Version.Version;

public abstract class NormalAction extends Action{

    private String author, repo;


    public NormalAction(String name, String author, String repo, Version version) {
        super(ActionType.NORMAL);
        setName(name);
        this.author = author;
        this.repo = repo;
        setVersion(version);
    }

    public NormalAction()
    {
        super(ActionType.NORMAL);
        setModuleName(getClass().getModule().getName());
    }

    public void addServerProperties(Property... properties)
    {
        for (Property property : properties)
        {
            if(property.getType() == Type.LIST || property.getType() == Type.INTEGER || property.getType() == Type.DOUBLE)
                property.setRawValue("0");
            else if(property.getType() == Type.BOOLEAN)
                property.setRawValue("false");
            else if(property.getType() == Type.STRING)
                property.setRawValue("");

            getServerProperties().addProperty(property);
        }
    }

    public void addClientProperties(Property... properties)
    {
        for (Property property : properties)
        {
            if(property.getType() == Type.LIST || property.getType() == Type.INTEGER || property.getType() == Type.DOUBLE)
                property.setRawValue("0");
            else if(property.getType() == Type.BOOLEAN)
                property.setRawValue("false");
            else if(property.getType() == Type.STRING)
                property.setRawValue("");

            getClientProperties().addProperty(property);
        }
    }


    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setRepo(String repo)
    {
        this.repo = repo;
    }


    public void setCommonBackgroundService(CommonBackgroundService commonBackgroundService)
    {
        CommonBackgroundServices.getInstance().addBgService(commonBackgroundService);
    }

    public CommonBackgroundService getCommonBackgroundService()
    {
        return CommonBackgroundServices.getInstance().getBgService(moduleName);
    }

    public String getAuthor()
    {
        return author;
    }

    public String getRepo()
    {
        return repo;
    }


    public abstract void initAction() throws Exception;

    public abstract void onActionClicked() throws Exception;
}
