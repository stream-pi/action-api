module com.stream_pi.actionapi{
    requires transitive com.stream_pi.util;

    requires transitive javafx.graphics;
    requires transitive javafx.controls;

    requires transitive org.kordamp.ikonli.javafx;
    requires transitive org.kordamp.ikonli.fontawesome5;

    requires transitive java.logging;

    exports com.stream_pi.actionapi;
    exports com.stream_pi.actionapi.action;
    exports com.stream_pi.actionapi.otheractions;
    exports com.stream_pi.actionapi.actionproperty;
    exports com.stream_pi.actionapi.actionproperty.property;
    exports com.stream_pi.actionapi.normalaction;
}
