package com.krushnatkhawale.plugins.sentry.explorer;

public class DependencyInfo implements Info {
    private final String someDependency;

    public DependencyInfo(String someDependency) {
        this.someDependency = someDependency;
    }

    public String getSomeDependency() {
        return someDependency;
    }

    @Override
    public void addInfo(String name, Info info) {
        info.addInfo("dependencyInfo", new DependencyInfo("wowow"));
    }
}
