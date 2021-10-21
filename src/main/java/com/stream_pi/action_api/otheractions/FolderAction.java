package com.stream_pi.action_api.otheractions;

import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.action_api.actionproperty.ClientProperties;
import com.stream_pi.action_api.i18n.I18N;

public class FolderAction extends OtherAction
{
    public FolderAction()
    {
        super(getUIName(), ActionType.FOLDER);
        setDisplayText(I18N.getString("otheractions.FolderAction.defaultDisplayText"));
        setClientProperties(new ClientProperties());
        getClientProperties().setDuplicatePropertyAllowed(true);
    }

    public static String getUIName()
    {
        return I18N.getString("otheractions.FolderAction.folder");
    }
}
