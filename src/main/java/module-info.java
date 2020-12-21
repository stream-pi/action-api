module com.StreamPi.ActionAPI{
    requires transitive com.StreamPi.Util;

    requires transitive javafx.graphics;
    requires transitive javafx.controls;

    requires transitive org.kordamp.ikonli.javafx;
    requires transitive org.kordamp.ikonli.fontawesome5;

    requires org.apache.logging.log4j;

    exports com.StreamPi.ActionAPI;
    exports com.StreamPi.ActionAPI.Action;
    exports com.StreamPi.ActionAPI.OtherActions;
    exports com.StreamPi.ActionAPI.ActionProperty;
    exports com.StreamPi.ActionAPI.ActionProperty.Property;
    exports com.StreamPi.ActionAPI.NormalAction;
}
