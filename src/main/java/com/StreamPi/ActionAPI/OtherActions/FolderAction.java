package com.StreamPi.ActionAPI.OtherActions;

import com.StreamPi.ActionAPI.Action.ActionType;

public class FolderAction extends OtherAction {
    public FolderAction(String name, String ID) {
        super(name, ID, ActionType.FOLDER);

        setCategory("StreamPi");
    }
}
