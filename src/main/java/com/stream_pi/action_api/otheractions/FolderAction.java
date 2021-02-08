package com.stream_pi.action_api.otheractions;

import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.action_api.actionproperty.ClientProperties;

public class FolderAction extends OtherAction {
    public FolderAction() {
        super("Folder", null, ActionType.FOLDER);
        setDisplayText("Folder");
        setClientProperties(new ClientProperties());
        getClientProperties().setDuplicatePropertyAllowed(true);
    }
}
