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

package com.stream_pi.action_api.actionproperty.gaugeproperties;

import javafx.scene.paint.Color;

import java.io.Serializable;

public class SerializableColor implements Serializable
{
    private final double red;
    private final double blue;
    private final double green;
    private final double opacity;

    private static final long serialVersionUID = 1967194720041976L;

    public SerializableColor(Color color)
    {
        this.red = color.getRed();
        this.blue = color.getBlue();
        this.green = color.getGreen();
        this.opacity = color.getOpacity();
    }

    public double getRed() {
        return red;
    }

    public double getBlue() {
        return blue;
    }

    public double getGreen() {
        return green;
    }

    public double getOpacity() {
        return opacity;
    }

    public Color getColor()
    {
        return Color.color(getRed(), getGreen(), getBlue());
    }
}
