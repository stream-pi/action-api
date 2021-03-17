package com.stream_pi.action_api.actionproperty.property;

import com.stream_pi.util.exception.MinorException;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class Property implements Cloneable, Serializable
{
    private final String name;
    private ControlType controlType;
    private final Type type;
    private boolean visible = true;
    private String defaultValue=null;
    private String helpLink=null;
    private String displayName;

    public void setDefaultValueStr(String defaultValue) throws MinorException {
        typeCheck(Type.STRING, Type.PASSWORD);

        if(!isCanBeBlank() && defaultValue.isBlank())
            throw new MinorException("property '"+name+"' is set to cannot be blank. Default property cannot be blank.");

        this.defaultValue = defaultValue;
    }

    public void setDefaultValueInt(int valueInt) throws MinorException{
        typeCheck(Type.INTEGER);
        this.defaultValue = valueInt + "";
    }

    public void setHelpLink(String URL)
    {
        this.helpLink = URL;
    }

    public String getHelpLink()
    {
        return helpLink;
    }

    public void setDefaultValueDouble(double defaultValueDouble) throws MinorException
    {
        typeCheck(Type.DOUBLE);
        this.defaultValue = defaultValueDouble + "";
    }

    public void setDefaultValueBoolean(boolean defaultValueBoolean) throws MinorException
    {
        typeCheck(Type.BOOLEAN);
        this.defaultValue = defaultValueBoolean+"";
    }

    public void setDefaultValueList(int index) throws MinorException
    {
        typeCheck(Type.LIST);
        this.defaultValue = index+"";
    }

    public String getDefaultRawValue() {
        return defaultValue;
    }

    private String value;

    private boolean canBeBlank = true;

    public boolean isCanBeBlank() {
        return canBeBlank;
    }

    public void setCanBeBlank(boolean canBeBlank) throws MinorException{
        typeCheck(Type.STRING, Type.PASSWORD);

        if(getDefaultRawValue().isEmpty() && !canBeBlank)
        {
            throw new MinorException("No default value given.");
        }

        this.canBeBlank = canBeBlank;
    }

    public void setControlType(ControlType controlType) throws MinorException
    {
        if(type == Type.INTEGER)
            controlTypeCheck(ControlType.SLIDER_INTEGER, ControlType.TEXT_FIELD);
        else if(type == Type.DOUBLE)
            controlTypeCheck(ControlType.SLIDER_DOUBLE, ControlType.TEXT_FIELD);
        else if(type == Type.STRING || type == Type.PASSWORD)
            controlTypeCheck(ControlType.TEXT_FIELD, ControlType.FILE_PATH);
        else if(type == Type.BOOLEAN)
            controlTypeCheck(ControlType.TOGGLE);
        else if(type == Type.LIST)
            controlTypeCheck(ControlType.COMBO_BOX);

        this.controlType = controlType;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public Property(String name, Type type)
    {
        this.name = name;
        this.displayName = name;
        this.type = type;

        try
        {
            if(type==Type.INTEGER)
            {
                setDefaultValueInt(0);
                maxIntValue = 100;
                minIntValue = 0;
                //value="0";
                this.controlType = ControlType.TEXT_FIELD;
            }
            else if(type == Type.DOUBLE)
            {
                setDefaultValueDouble(0.0);
                maxDoubleValue = 100;
                minDoubleValue = 0;
                //value="0";
                this.controlType = ControlType.TEXT_FIELD;
            }
            else if(type==Type.STRING || type==Type.PASSWORD)
            {
                setDefaultValueStr("");
                //value="";
                this.controlType = ControlType.TEXT_FIELD;
            }
            else if(type==Type.BOOLEAN)
            {
                setDefaultValueBoolean(false);
                //value="false";
                this.controlType = ControlType.TOGGLE;
            }
            else if (type==Type.LIST)
            {
                setDefaultValueList(0);
                //value="0";
                this.controlType = ControlType.COMBO_BOX;
            }
        }
        catch (MinorException e)
        {
            e.printStackTrace();
        }
    }

    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }

    public boolean isVisible()
    {
        return visible;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getRawValue()
    {
        return value;
    }

    public void setRawValue(String value)
    {
        this.value = value;
    }

    //Type

    public Type getType()
    {
        return type;
    }

    //ControlType

    public ControlType getControlType()
    {
        return controlType;
    }

    //For Type BOOLEAN
    public void setBoolValue(boolean value) throws MinorException
    {
        typeCheck(Type.BOOLEAN);

        if(value)
            this.value = "true";
        else
            this.value = "false";
    }

    public boolean getBoolValue() throws MinorException
    {
        typeCheck(Type.BOOLEAN);

        return value.equals("true");
    }

    //For Type STRING
    public void setStringValue(String value) throws MinorException
    {
        typeCheck(Type.STRING, Type.PASSWORD);

        this.value = value;
    }


    public String getStringValue() throws MinorException
    {
        typeCheck(Type.STRING, Type.PASSWORD);

        return value;
    }

    //For Type LIST
    private List<String> list;

    public void setListValue(List<String> list) throws MinorException
    {
        typeCheck(Type.LIST);

        this.list = list;
        this.value = "0";
    }

    public void setSelectedIndex(int index) throws MinorException {
        typeCheck(Type.LIST);

        this.value = index+"";
    }

    public int getSelectedIndex() throws MinorException
    {
        typeCheck(Type.LIST);
        return Integer.parseInt(this.value);
    }


    public List<String> getListValue() throws MinorException
    {
        typeCheck(Type.LIST);

        return list;
    }

    //For Type INTEGER
    private int maxIntValue, minIntValue;

    public void setMaxIntValue(int maxValue) throws MinorException
    {
        typeCheck(Type.INTEGER);

        this.maxIntValue = maxValue;
    }

    public void setMinIntValue(int minValue) throws MinorException
    {
        typeCheck(Type.INTEGER);

        this.minIntValue = minValue;
    }

    public void setIntValue(int value) throws MinorException
    {
        typeCheck(Type.INTEGER);

        this.value = value+"";
    }

    public int getMaxIntValue() throws MinorException
    {
        typeCheck(Type.INTEGER);

        return maxIntValue;
    }

    public int getMinIntValue() throws MinorException
    {
        typeCheck(Type.INTEGER);

        return minIntValue;
    }

    public int getIntValue() throws MinorException
    {
        typeCheck(Type.INTEGER);


        try
        {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException e)
        {
            throw new MinorException("property '"+name+"' has non integer value for type INTEGER");
        }
    }


    //For Type DOUBLE
    private double maxDoubleValue, minDoubleValue;

    public void setMaxDoubleValue(double maxValue) throws MinorException
    {
        typeCheck(Type.DOUBLE);

        this.maxDoubleValue = maxValue;
    }

    public void setMinDoubleValue(double minValue) throws MinorException
    {
        typeCheck(Type.DOUBLE);

        this.minDoubleValue = minValue;
    }

    public void setDoubleValue(double value) throws MinorException
    {
        typeCheck(Type.DOUBLE);

        this.value = value+"";
    }

    public double getMaxDoubleValue() throws MinorException
    {
        typeCheck(Type.DOUBLE);

        return maxDoubleValue;
    }

    public double getMinDoubleValue() throws MinorException
    {
        typeCheck(Type.DOUBLE);

        return minDoubleValue;
    }

    public double getDoubleValue() throws MinorException
    {
        typeCheck(Type.DOUBLE);

        try
        {
            return Double.parseDouble(value);
        }
        catch (NumberFormatException e)
        {
            throw new MinorException("property '"+name+"' has non double value for type DOUBLE");
        }
    }



    //Type Check
    private void typeCheck(Type... required) throws MinorException
    {
        boolean isFail = true;
        for(Type c : required)
        {
            if (type == c)
            {
                isFail = false;
                break;
            }
        }

        if(isFail)
            throw new MinorException("property '"+name+"' cannot have "+type+"!");
    }

    //ControlType Check
    private void controlTypeCheck(ControlType... required) throws MinorException
    {
        boolean isFail = true;
        for(ControlType c : required)
        {
            if (controlType == c)
            {
                isFail = false;
                break;
            }
        }

        if(isFail)
            throw new MinorException("property '"+name+"' cannot have ControlType '"+controlType+"!");
    }

    public Property clone() throws CloneNotSupportedException
    {
        return (Property)super.clone();
    }

    private FileExtensionFilter[] extensionFilters = null;

    public void setExtensionFilters(FileExtensionFilter... extensionFilters) throws MinorException
    {
        controlTypeCheck(ControlType.FILE_PATH);
        this.extensionFilters = extensionFilters;
    }

    public FileExtensionFilter[] getExtensionFilters()
    {
        return extensionFilters;
    }
}
