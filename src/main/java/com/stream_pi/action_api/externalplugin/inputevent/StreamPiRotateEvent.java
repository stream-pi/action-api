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

package com.stream_pi.action_api.externalplugin.inputevent;

import javafx.event.EventType;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ScrollEvent;

import java.io.Serializable;

public class StreamPiRotateEvent extends StreamPiInputEvent implements Serializable
{
    private static final long serialVersionUID = 1967194720041979L;

    public StreamPiRotateEvent(EventType<?> eventType, double angle, double totalAngle)
    {
        super(eventType);
        this.angle = angle;
        this.totalAngle = totalAngle;
    }

    private final double angle;

    public double getAngle()
    {
        return angle;
    }

    private final double totalAngle;

    public double getTotalAngle()
    {
        return totalAngle;
    }
}
