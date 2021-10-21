package com.stream_pi.action_api.action;

import com.stream_pi.action_api.i18n.I18N;

import java.io.Serializable;

public enum DisplayTextAlignment implements Serializable
{
    TOP, CENTER, BOTTOM;

    public String getUIName()
    {
        if (this == TOP)
        {
            return I18N.getString("action.DisplayTextAlignment.top");
        }
        else if(this == CENTER)
        {
            return I18N.getString("action.DisplayTextAlignment.center");
        }
        else
        {
            return I18N.getString("action.DisplayTextAlignment.bottom");
        }
    }
}
