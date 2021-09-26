package com.stream_pi.action_api.externalplugin;

import com.stream_pi.action_api.actionproperty.GaugeProperties;
import com.stream_pi.util.exception.MinorException;
import eu.hansolo.medusa.Gauge;

import java.net.SocketAddress;

public interface GaugeExtras
{
    void updateGauge(GaugeProperties gaugeProperties, String profileID, String actionID, SocketAddress clientSocketAddress);
    void updateGaugeValue(double value, String profileID, String actionID, SocketAddress clientSocketAddress);
}
