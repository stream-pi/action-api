package com.StreamPi.ActionAPI.ActionProperty;

public class Property {
    private Object value;

    public Property(Object value)
    {
        this.value = value;
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
