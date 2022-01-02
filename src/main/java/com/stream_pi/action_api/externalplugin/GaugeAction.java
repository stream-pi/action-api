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

package com.stream_pi.action_api.externalplugin;

import com.stream_pi.action_api.action.ActionType;
import com.stream_pi.action_api.i18n.I18N;
import com.stream_pi.util.exception.MinorException;
import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.Section;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.concurrent.Future;

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
            throw new MinorException(I18N.getString("externalplugin.GaugeAction.actionTypeIsNotGauge"));

        getGaugeExtras().updateGauge(getGaugeProperties(), getProfileID(), getID(), getSocketAddressForClient());
    }

    public void updateGaugeValue() throws MinorException
    {
        if(getActionType() != ActionType.GAUGE)
            throw new MinorException(I18N.getString("externalplugin.GaugeAction.actionTypeIsNotGauge"));

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

    public void onGaugeInit() throws MinorException
    {

    }

    private Future<?> gaugeUpdaterFuture = null;

    public void setGaugeUpdaterRunnable(Future<?> gaugeUpdaterFuture)
    {
        if(this.gaugeUpdaterFuture != null)
        {
            this.gaugeUpdaterFuture.cancel(true);
        }

        this.gaugeUpdaterFuture = gaugeUpdaterFuture;
    }

    public void cancelGaugeUpdaterFuture()
    {
        if (gaugeUpdaterFuture != null && !gaugeUpdaterFuture.isDone())
        {
            gaugeUpdaterFuture.cancel(true);
        }
    }
}
