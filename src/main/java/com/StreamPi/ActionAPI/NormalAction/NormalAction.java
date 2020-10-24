package com.StreamPi.ActionAPI.NormalAction;

import com.StreamPi.ActionAPI.Action.Action;
import com.StreamPi.ActionAPI.Action.ActionType;
import com.StreamPi.Util.Exception.MinorException;
import com.StreamPi.Util.Version.Version;

public abstract class NormalAction extends Action {

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
