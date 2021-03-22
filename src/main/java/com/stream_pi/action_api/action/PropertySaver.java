package com.stream_pi.action_api.action;

import java.net.SocketAddress;

public interface PropertySaver
{
    void saveServerProperties();
    void saveClientAction(String profileID, String actionID, SocketAddress clientSocketAddress, boolean sendIcons, boolean runAsync);
    void saveAllIcons(String profileID, String actionID, SocketAddress clientSocketAddress);
    void saveIcon(String state, String profileID, String actionID, SocketAddress clientSocketAddress);
}
