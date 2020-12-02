module com.StreamPi.ActionAPI{
    requires com.StreamPi.Util;

    requires javafx.graphics;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;

    requires org.apache.logging.log4j;

    exports com.StreamPi.ActionAPI;
    exports com.StreamPi.ActionAPI.Action;
    exports com.StreamPi.ActionAPI.OtherActions;
    exports com.StreamPi.ActionAPI.ActionProperty;
    exports com.StreamPi.ActionAPI.ActionProperty.Property;
    exports com.StreamPi.ActionAPI.NormalAction;
}
