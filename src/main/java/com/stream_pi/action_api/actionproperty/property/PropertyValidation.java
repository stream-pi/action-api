package com.stream_pi.action_api.actionproperty.property;

import com.stream_pi.action_api.i18n.I18N;

public class PropertyValidation 
{
    public static String cannotBeBlank(Object... strings)
    {
        return I18N.getString("actionproperty.property.PropertyValidation.cannotBeBlank", strings);
    }

    public static String defaultValueRequired(Object... strings)
    {
        return I18N.getString("actionproperty.property.PropertyValidation.defaultValueRequired", strings);
    }

    public static String integerValueRequired(Object... strings)
    {
        return I18N.getString("actionproperty.property.PropertyValidation.integerValueRequired", strings);
    }
    
    public static String doubleValueRequired(Object... strings)
    {
        return I18N.getString("actionproperty.property.PropertyValidation.doubleValueRequired", strings);
    }

    public static String cannotHaveType(Object... strings)
    {
        return I18N.getString("actionproperty.property.PropertyValidation.cannotHaveType", strings);
    }

    public static String cannotHaveControlType(Object... strings)
    {
        return I18N.getString("actionproperty.property.PropertyValidation.cannotHaveControlType", strings);
    }
}
