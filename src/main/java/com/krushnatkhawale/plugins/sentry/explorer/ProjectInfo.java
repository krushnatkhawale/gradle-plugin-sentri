package com.krushnatkhawale.plugins.sentry.explorer;

public class ProjectInfo implements Info {

    private final String infoType = "projectInfo";

    private final String name;
    private final String group;
    private final String version;

    public ProjectInfo(String name, String group, String version) {
        this.name = name;
        this.group = group;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getGroup() {
        return group;
    }

    public String getInfoType() {
        return infoType;
    }

    @Override
    public void addInfo(String name, Info info) {

    }
}
