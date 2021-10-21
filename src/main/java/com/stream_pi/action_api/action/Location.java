package com.stream_pi.action_api.action;

import java.io.Serializable;

public class Location implements Serializable
{
    int row,col, rowSpan, colSpan;

    public Location(int row, int col)
    {
        this(row, col, 1, 1);
    }

    public Location(int row, int col, int rowSpan, int colSpan)
    {
        setLocation(row, col);
        setSpan(rowSpan, colSpan);
    }

    public void setLocation(int row, int col)
    {
        setRow(row);
        setCol(col);
    }

    public void setSpan(int rowSpan, int colSpan)
    {
        this.rowSpan = rowSpan;
        this.colSpan = colSpan;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public void setCol(int col)
    {
        this.col = col;
    }

    public void setRowSpan(int rowSpan)
    {
        this.rowSpan = rowSpan;
    }

    public void setColSpan(int colSpan)
    {
        this.colSpan = colSpan;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public int getRowSpan()
    {
        return rowSpan;
    }

    public int getColSpan()
    {
        return colSpan;
    }

}
