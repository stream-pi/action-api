package com.stream_pi.action_api.externalplugin;

import com.stream_pi.action_api.actionproperty.gaugeproperties.GaugeProperties;

import java.net.SocketAddress;

public interface GaugeExtras
{
    void updateGauge(GaugeProperties gaugeProperties, String profileID, String actionID, SocketAddress clientSocketAddress);
    void updateGaugeValue(double value, String profileID, String actionID, SocketAddress clientSocketAddress);
}
