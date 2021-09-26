package com.stream_pi.action_api.actionproperty;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.Section;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GaugeProperties implements Serializable
{
    private Gauge.SkinType skinType;
    private double minValue;
    private double maxValue;
    private ArrayList<GaugeSection> sections;
    private double value;

    private String unit;
    private String subTitle;
    private int decimals;


    private static final long serialVersionUID = 2000200419671976L;

    public GaugeProperties(Gauge.SkinType skinType, double minValue, double maxValue, double value,
                           ObservableList<Section> sections, String unit, String subTitle, int decimals)
    {
        this.skinType = skinType;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.value = value;
        this.sections = new ArrayList<>();
        sections.forEach(section -> this.sections.add(new GaugeSection(section.getStart(), section.getStop(), section.getColor())));

        this.unit = unit;
        this.subTitle = subTitle;
        this.decimals = decimals;
    }

    public GaugeProperties()
    {
        this.skinType = Gauge.SkinType.FLAT;
        this.minValue = 0;
        this.maxValue = 100;
        this.value = 0;
        this.sections = new ArrayList<>();
        this.unit = "";
        this.subTitle = "";
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getMaxValue()
    {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue()
    {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public Gauge.SkinType getSkinType()
    {
        return skinType;
    }

    public void setSkinType(Gauge.SkinType skinType) {
        this.skinType = skinType;
    }

    public ObservableList<Section> getSections()
    {
        ArrayList<Section> tbr = new ArrayList<>();

        sections.forEach(section->{
            tbr.add(new Section(section.getStart(), section.getStop(), Color.color(
                    section.getRed(), section.getGreen(), section.getBlue(), section.getOpacity()
            )));
        });

        return FXCollections.observableList(tbr);
    }

    public void setSections(List<Section> sections)
    {
        this.sections.clear();
        sections.forEach(section -> this.sections.add(new GaugeSection(section.getStart(), section.getStop(), section.getColor())));
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getSubTitle()
    {
        return subTitle;
    }

    public void setSubTitle(String subTitle)
    {
        this.subTitle = subTitle;
    }

    public int getDecimals()
    {
        return decimals;
    }

    public void setDecimals(int decimals)
    {
        this.decimals = decimals;
    }

    public GaugeProperties chaap()
    {
        return new GaugeProperties(getSkinType(), getMinValue(), getMaxValue(), getValue(), getSections(),
                getUnit(), getSubTitle(), getDecimals());
    }
}

class GaugeSection implements Serializable
{
    private final double start;
    private final double stop;

    private final double red;
    private final double blue;
    private final double green;
    private final double opacity;

    private static final long serialVersionUID = 2000196720041976L;

    public GaugeSection(double start, double stop, Color color)
    {
        this.start = start;
        this.stop = stop;

        this.red = color.getRed();
        this.blue = color.getBlue();
        this.green = color.getGreen();
        this.opacity = color.getOpacity();
    }

    public double getStart() {
        return start;
    }

    public double getStop() {
        return stop;
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
}
