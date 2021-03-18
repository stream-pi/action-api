package com.stream_pi.action_api.normalaction;

import com.stream_pi.action_api.action.Action;
import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.action_api.actionproperty.ClientProperties;
import com.stream_pi.action_api.actionproperty.property.Property;
import com.stream_pi.action_api.actionproperty.property.Type;
import com.stream_pi.util.version.Version;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public abstract class NormalAction extends PluginActionBase
{

    public NormalAction()
    {
        super(ActionType.NORMAL);
    }

    public abstract void onActionClicked() throws Exception;
}
