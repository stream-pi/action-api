package com.stream_pi.action_api.action;

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
