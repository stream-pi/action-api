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
