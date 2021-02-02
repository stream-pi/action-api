package com.stream_pi.actionapi.normalaction;

import com.stream_pi.actionapi.action.Action;
import com.stream_pi.actionapi.action.ActionType;
import com.stream_pi.actionapi.actionproperty.ClientProperties;
import com.stream_pi.actionapi.actionproperty.property.Property;
import com.stream_pi.actionapi.actionproperty.property.Type;
import com.stream_pi.util.version.Version;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public abstract class NormalAction extends Action{

    private String author = "Unknown Author";

    public NormalAction(String name, String author, String helpLink, Version version) {
        super(ActionType.NORMAL);
        setName(name);
        this.author = author;
        setHelpLink(helpLink);
        setVersion(version);
    }

    private boolean visibileInPluginsPane = true;
    private boolean visibileInServerSettingsPane = true;

    public void setVisibilityInPluginsPane(boolean visibileInPluginsPane) 
    {
        this.visibileInPluginsPane = visibileInPluginsPane;
    }

    public void setVisibilityInServerSettingsPane(boolean visibileInServerSettingsPane) 
    {
        this.visibileInServerSettingsPane = visibileInServerSettingsPane;
    }

    public boolean isVisibleInPluginsPane() 
    {
        return visibileInPluginsPane;
    }

    public boolean isVisibleInServerSettingsPane() 
    {
        return visibileInServerSettingsPane;
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


    public String getAuthor()
    {
        return author;
    }


    public abstract void initProperties() throws Exception;


    public abstract void initAction() throws Exception;

    public abstract void onActionClicked() throws Exception;

    public abstract void onShutDown() throws Exception;

    public NormalAction clone() throws CloneNotSupportedException {
        NormalAction action = (NormalAction) super.clone();
        action.setClientProperties((ClientProperties) action.getClientProperties().clone());
        return action;
    }

    private VBox buttonBar = null;
    public void setButtonBar(Button... buttons)
    {
        buttonBar = new VBox(buttons);
        buttonBar.setSpacing(5.0);
    }

    public VBox getButtonBar()
    {
        return buttonBar;
    }
}
