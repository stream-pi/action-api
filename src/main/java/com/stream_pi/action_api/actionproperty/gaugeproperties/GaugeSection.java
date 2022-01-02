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

public class GaugeSection implements Serializable
{
    private final double start;
    private final double stop;

    private final SerializableColor color;

    private static final long serialVersionUID = 2000196720041976L;

    public GaugeSection(double start, double stop, Color color)
    {
        this(start, stop, new SerializableColor(color));
    }

    public GaugeSection(double start, double stop, SerializableColor color)
    {
        this.start = start;
        this.stop = stop;

        this.color = color;
    }


    public double getStart() {
        return start;
    }

    public double getStop() {
        return stop;
    }

    public SerializableColor getColor()
    {
        return color;
    }
}
