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
    exports com.stream_pi.action_api.actionproperty.gaugeproperties;
}
