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
import javafx.scene.input.TouchPoint;

import java.io.Serializable;
import java.util.List;

public class StreamPiTouchEvent extends StreamPiInputEvent implements Serializable
{
    private static final long serialVersionUID = 1967194720041981L;

    public StreamPiTouchEvent(EventType<?> eventType, int touchCount, int eventSetId)
    {
        super(eventType);
        this.touchCount = touchCount;
        this.eventSetId = eventSetId;
    }

    private final int touchCount;

    public int getTouchCount()
    {
        return touchCount;
    }

    private final int eventSetId;

    public int getEventSetId()
    {
        return eventSetId;
    }
}
