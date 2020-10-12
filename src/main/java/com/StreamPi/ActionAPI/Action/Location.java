package com.StreamPi.ActionAPI.Action;

public class Location {
    int x,y;

    public Location(int x, int y)
    {
        setLocation(x,y);
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
