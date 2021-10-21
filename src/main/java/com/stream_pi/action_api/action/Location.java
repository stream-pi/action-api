package com.stream_pi.action_api.action;

import java.io.Serializable;

public class Location implements Serializable
{
    int row,col;

    public Location(int row, int col)
    {
        setLocation(row,col);
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public void setCol(int col)
    {
        this.col = col;
    }

    public void setLocation(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}
