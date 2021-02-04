package com.stream_pi.actionapi.action;

public enum DisplayTextAlignment {
    TOP("Top"), CENTER("Center"), BOTTOM("Bottom");

    private final String UIName;
    DisplayTextAlignment(String UIName)
    {
        this.UIName = UIName;
    }

    public String getUIName() {
        return UIName;
    }
}
