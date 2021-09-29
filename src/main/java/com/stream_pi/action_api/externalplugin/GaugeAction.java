package com.stream_pi.action_api.externalplugin;

import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.util.exception.MinorException;
import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.Section;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.util.Arrays;

public class GaugeAction extends ExternalPlugin
{
    public GaugeAction()
    {
        super(ActionType.GAUGE);
    }

    public void setSkinType(Gauge.SkinType skinType)
    {
        getGaugeProperties().setSkinType(skinType);
    }

    public void setMaxValue(double maxValue)
    {
        getGaugeProperties().setMaxValue(maxValue);
    }

    public void setMinValue(double minValue)
    {
        getGaugeProperties().setMinValue(minValue);
    }

    public void setValue(double value)
    {
        getGaugeProperties().setValue(value);
    }

    public void setSections(Section... sections)
    {
        getGaugeProperties().setSections(Arrays.asList(sections));
    }

    public Gauge.SkinType getSkinType()
    {
        return getGaugeProperties().getSkinType();
    }

    private GaugeExtras gaugeExtras = null;

    public void setGaugeExtras(GaugeExtras gaugeExtras)
    {
        this.gaugeExtras = gaugeExtras;
    }

    private GaugeExtras getGaugeExtras()
    {
        return gaugeExtras;
    }

    public void updateEntireGauge() throws MinorException
    {
        if(getActionType() != ActionType.GAUGE)
            throw new MinorException("Action type is not GAUGE");

        getGaugeExtras().updateGauge(getGaugeProperties(), getProfileID(), getID(), getSocketAddressForClient());
    }

    public void updateGaugeValue() throws MinorException
    {
        if(getActionType() != ActionType.GAUGE)
            throw new MinorException("Action type is not GAUGE");

        getGaugeExtras().updateGaugeValue(getGaugeProperties().getValue(), getProfileID(), getID(), getSocketAddressForClient());
    }

    public void setUnit(String unit)
    {
        getGaugeProperties().setUnit(unit);
    }

    public void setDecimals(int decimals)
    {
        getGaugeProperties().setDecimals(decimals);
    }

    public void setSubTitle(String subTitle)
    {
        getGaugeProperties().setSubTitle(subTitle);
    }

    public void setSectionsVisible(boolean sectionsVisible)
    {
        getGaugeProperties().setSectionsVisible(sectionsVisible);
    }

    public void setBarColor(Color barColor)
    {
        getGaugeProperties().setBarColor(barColor);
    }

    public void setGaugeForegroundBaseColor(Color foregroundBaseColor)
    {
        getGaugeProperties().setForegroundBaseColor(foregroundBaseColor);
    }
}
