package com.krushnatkhawale.plugins.sentry.explorer;

import org.gradle.api.Project;

public class DependenciesExplorer implements InfoExplorer {
    @Override
    public void explore(Project project, Info info) {
        info.addInfo("dependencyInfo", new DependencyInfo("someDependency") );
    }
}
