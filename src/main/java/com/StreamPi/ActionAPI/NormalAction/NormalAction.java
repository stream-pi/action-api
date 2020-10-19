package com.StreamPi.ActionAPI.NormalAction;

import com.StreamPi.ActionAPI.Action.Action;
import com.StreamPi.ActionAPI.Action.ActionType;
import com.StreamPi.ActionAPI.ActionProperty.Properties;
import com.StreamPi.Util.Version.Version;

public abstract class NormalAction extends Action {

    final String author, repo;

    final Version version;

    final String moduleName = getClass().getModule().getName();

    public NormalAction(String name, String ID, String author, String repo, Version version, Properties properties) {
        super(name, ID, ActionType.NORMAL);

        this.author = author;
        this.repo = repo;
        this.version = version;
        this.properties = properties;

        initAction();
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


    public String getModuleName() {
        return moduleName;
    }

    public abstract void initAction();

    public abstract void actionClicked();
}
