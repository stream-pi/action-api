package com.StreamPi.ActionAPI.ActionProperty.Property;

import com.StreamPi.Util.Exception.MinorException;

import java.util.ArrayList;
import java.util.List;

public class Property {
    private final String name;
    private ControlType controlType;
    private final Type type;
    private boolean visible = true;

    private String value;

    public Property(String name, Type type, ControlType controlType) throws MinorException
    {
        this.name = name;
        this.type = type;
        this.controlType = controlType;

        if(type==Type.INTEGER)
        {
            maxIntValue = 100;
            minIntValue = 0;
            value="0";
            controlTypeCheck(ControlType.SLIDER_INTEGER, ControlType.TEXT_FIELD);
        }
        else if(type == Type.DOUBLE)
        {
            maxDoubleValue = 100;
            minDoubleValue = 0;
            value="0";
            controlTypeCheck(ControlType.SLIDER_DOUBLE, ControlType.TEXT_FIELD);
        }
        else if(type==Type.STRING)
        {
            value="";
            controlTypeCheck(ControlType.TEXT_FIELD);
        }
        else if(type==Type.BOOLEAN)
        {
            value="false";
            controlTypeCheck(ControlType.TOGGLE);
        }
        else if (type==Type.LIST)
        {
            value="0";
            controlTypeCheck(ControlType.COMBO_BOX);
        }
    }

    public Property(String name, Type type)
    {
        this.name = name;
        this.type = type;

        if(type==Type.INTEGER)
        {
            maxIntValue = 100;
            minIntValue = 0;
            value="0";
            this.controlType = ControlType.TEXT_FIELD;
        }
        else if(type == Type.DOUBLE)
        {
            maxDoubleValue = 100;
            minDoubleValue = 0;
            value="0";
            this.controlType = ControlType.TEXT_FIELD;
        }
        else if(type==Type.STRING)
        {
            value="";
            this.controlType = ControlType.TEXT_FIELD;
        }
        else if(type==Type.BOOLEAN)
        {
            value="false";
            this.controlType = ControlType.TOGGLE;
        }
        else if (type==Type.LIST)
        {
            value="0";
            this.controlType = ControlType.COMBO_BOX;
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
        typeCheck(Type.STRING);

        this.value = value;
    }


    public String getStringValue() throws MinorException
    {
        typeCheck(Type.STRING);

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
            throw new MinorException("Property '"+name+"' has non integer value for type INTEGER");
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
            throw new MinorException("Property '"+name+"' has non double value for type DOUBLE");
        }
    }



    //Type Check
    private void typeCheck(Type required) throws MinorException
    {
        if(type != required)
            throw new MinorException("Property '"+name+"' cannot have "+required+" related value because TYPE is set to "+type);
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
            throw new MinorException("Property '"+name+"' cannot have ControlType '"+controlType+"' because Type is set to "+type);
    }
}