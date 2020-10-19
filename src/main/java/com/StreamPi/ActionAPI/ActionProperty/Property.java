package com.StreamPi.ActionAPI.ActionProperty;

public class Property {
    private Object value;

    private String name;

    public Property(String name)
    {
        this.name = name;
    }

    public void setName()
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public Object getValue()
    {
        return value;
    }

    public String getString()
    {
        return value.toString();
    }

    public int getInt()
    {
        return Integer.parseInt(getString());
    }

    public byte[] getByteArr()
    {
        return (byte[]) value;
    }
}
