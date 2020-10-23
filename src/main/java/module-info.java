module com.StreamPi.ActionAPI{
    requires com.StreamPi.Util;

    requires javafx.graphics;
    requires org.kordamp.ikonli.javafx;

    exports com.StreamPi.ActionAPI.Action;
    exports com.StreamPi.ActionAPI.OtherActions;
    exports com.StreamPi.ActionAPI.ActionProperty;
    exports com.StreamPi.ActionAPI.NormalAction;
}
