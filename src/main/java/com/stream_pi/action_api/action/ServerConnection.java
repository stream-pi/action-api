package com.stream_pi.action_api.action;

import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.platform.Platform;

import java.net.SocketAddress;
import java.util.Locale;

public interface ServerConnection
{
    Platform getPlatform();
    void sendActionFailed(MinorException exception, SocketAddress socketAddress, String profileID, String actionID);
    Locale getCurrentLocale();
}
