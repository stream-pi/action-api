package com.StreamPi.ActionAPI.NormalAction;

import com.StreamPi.ActionAPI.Action.Action;
import com.StreamPi.ActionAPI.Action.ActionType;
import com.StreamPi.ActionAPI.ActionProperty.Properties;
import com.StreamPi.Util.Exception.MinorException;
import com.StreamPi.Util.Version.Version;

public abstract class NormalAction extends Action {

    private String author, repo;

    private Version version;


    public NormalAction(String name, String author, String repo, Version version) {
        super(ActionType.NORMAL);
        setName(name);
        this.author = author;
        this.repo = repo;
        this.version = version;
    }

    public NormalAction()
    {
        super(ActionType.NORMAL);
        setModuleName(getClass().getModule().getName());
    }


    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setRepo(String repo)
    {
        this.repo = repo;
    }

    public void setVersion(Version version)
    {
        this.version = version;
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

    public Version getVersion()
    {
        return version;
    }

    public abstract void initAction() throws MinorException;

    public abstract void onActionClicked() throws MinorException;
}
