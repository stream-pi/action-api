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
import javafx.scene.input.ZoomEvent;

import java.io.Serializable;

public class StreamPiZoomEvent extends StreamPiInputEvent implements Serializable
{
    private static final long serialVersionUID = 1508194720042000L;

    public StreamPiZoomEvent(EventType<?> eventType, double zoomFactor, double totalZoomFactor)
    {
        super(eventType);
        this.zoomFactor = zoomFactor;
        this.totalZoomFactor = totalZoomFactor;
    }

    private final double zoomFactor;

    public double getZoomFactor()
    {
        return zoomFactor;
    }

    private final double totalZoomFactor;

    public double getTotalZoomFactor()
    {
        return totalZoomFactor;
    }
}
