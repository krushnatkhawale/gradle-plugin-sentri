package com.krushnatkhawale.plugins.sentry.explorer;

public class ProjectInfo implements Info {
    private final String name;
    private final String version;

    public ProjectInfo(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}
