package com.stream_pi.action_api.actionproperty.property;

import com.stream_pi.action_api.i18n.I18N;

public class PropertyValidation 
{
    public static String cannotBeBlank(Object... objs)
    {
        return I18N.getString("actionproperty.property.PropertyValidation.cannotBeBlank", objs);
    }

    public static String defaultValueRequired(Object... objs)
    {
        return I18N.getString("actionproperty.property.PropertyValidation.defaultValueRequired", objs);
    }

    public static String integerValueRequired(Object... objs)
    {
        return I18N.getString("actionproperty.property.PropertyValidation.integerValueRequired", objs);
    }
    
    public static String doubleValueRequired(Object... objs)
    {
        return I18N.getString("actionproperty.property.PropertyValidation.doubleValueRequired", objs);
    }

    public static String invalidType(Object... objs)
    {
        return I18N.getString("actionproperty.property.PropertyValidation.invalidType", objs);
    }

    public static String invalidControlType(Object... objs)
    {
        return I18N.getString("actionproperty.property.PropertyValidation.invalidControlType", objs);
    }
}
