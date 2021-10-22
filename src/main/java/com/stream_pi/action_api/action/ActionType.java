package com.stream_pi.action_api.action;

import java.io.Serializable;

public enum ActionType implements Serializable
{
    FOLDER, NORMAL, COMBINE, TOGGLE, GAUGE;

    private static final long serialVersionUID = 2765570019667976L;
}
