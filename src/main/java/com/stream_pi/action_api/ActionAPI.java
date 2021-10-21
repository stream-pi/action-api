package com.stream_pi.action_api;


import com.stream_pi.util.i18n.I18N;
import com.stream_pi.util.version.Version;

import java.util.Locale;

public class ActionAPI
{
    public static final Version VERSION = new Version(1,0,0);

    public static void setLocale(Locale locale)
    {
        I18N.init(locale);
    }
}
