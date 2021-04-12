package com.stream_pi.action_api.externalplugin;

import com.stream_pi.util.exception.MinorException;

import java.net.SocketAddress;

public interface ToggleExtras
{
    void setToggleStatus(boolean toggleStatus, String profileID, String actionID, SocketAddress clientSocketAddress) throws MinorException;
}
