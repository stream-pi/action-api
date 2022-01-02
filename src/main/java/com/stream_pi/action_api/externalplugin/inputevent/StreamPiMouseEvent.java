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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;

import java.io.Serializable;

public class StreamPiMouseEvent extends StreamPiInputEvent implements Serializable
{
    private static final long serialVersionUID = 1967194720041978L;

    public StreamPiMouseEvent(EventType<?> eventType, int clickCount, MouseButton button)
    {
        super(eventType);
        this.clickCount = clickCount;
        this.button = button;
    }

    private final int clickCount;

    public int getClickCount()
    {
        return clickCount;
    }

    private final MouseButton button;

    public MouseButton getButton()
    {
        return button;
    }
}
