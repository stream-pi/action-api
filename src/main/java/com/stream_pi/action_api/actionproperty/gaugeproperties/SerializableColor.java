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
