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

module com.stream_pi.action_api
{
    requires transitive com.stream_pi.util;

    requires transitive javafx.graphics;
    requires transitive javafx.controls;

    requires transitive eu.hansolo.medusa;

    requires transitive org.kordamp.ikonli.javafx;
    requires transitive org.kordamp.ikonli.fontawesome5;

    requires transitive java.logging;

    exports com.stream_pi.action_api;
    exports com.stream_pi.action_api.action;
    exports com.stream_pi.action_api.otheractions;
    exports com.stream_pi.action_api.actionproperty;
    exports com.stream_pi.action_api.actionproperty.property;
    exports com.stream_pi.action_api.externalplugin;
    exports com.stream_pi.action_api.externalplugin.inputevent;
    exports com.stream_pi.action_api.actionproperty.gaugeproperties;
}
