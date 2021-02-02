package com.stream_pi.actionapi.otheractions;

import com.stream_pi.actionapi.action.ActionType;
import com.stream_pi.actionapi.actionproperty.ClientProperties;

public class FolderAction extends OtherAction {
    public FolderAction() {
        super("Folder", null, ActionType.FOLDER);
        setDisplayText("Folder");
        setClientProperties(new ClientProperties());
        getClientProperties().setDuplicatePropertyAllowed(true);
    }
}
