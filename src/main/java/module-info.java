module com.StreamPi.ActionAPI{
    requires com.StreamPi.Util;

    requires javafx.graphics;

    exports com.StreamPi.ActionAPI.Action;
    exports com.StreamPi.ActionAPI.OtherActions to com.StreamPi.Server;
    exports com.StreamPi.ActionAPI.ActionProperty;
    exports com.StreamPi.ActionAPI.Service;
    exports com.StreamPi.ActionAPI.NormalAction;
}
