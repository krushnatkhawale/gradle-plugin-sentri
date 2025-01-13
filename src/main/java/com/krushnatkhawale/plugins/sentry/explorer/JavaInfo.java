package com.krushnatkhawale.plugins.sentry.explorer;

public class JavaInfo implements Info {

    private final int versionAsInt;
    private final String versionAsStr;

    public JavaInfo(int versionAsInt, String versionAsStr){
        this.versionAsInt = versionAsInt;
        this.versionAsStr = versionAsStr;
    }

    @Override
    public void addInfo(String name, Info info) {

    }

    @Override
    public String getInfoType() {
        return "javaVersion";
    }

    public int getVersionAsInt() {
        return versionAsInt;
    }

    public String getVersionAsStr() {
        return versionAsStr;
    }
}
