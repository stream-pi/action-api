/*
 * Stream-Pi - Free, Open-Source, Modular, Cross-Platform and Programmable Macro Pad
 * Copyright (C) 2019-2022 Debayan Sutradhar (rnayabed),  Samuel Quiñones (SamuelQuinones)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package com.stream_pi.action_api.action;

import java.io.Serializable;

public class Location implements Serializable
{
    private static final long serialVersionUID = 2087650019667976L;

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
