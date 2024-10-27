package com.krushnatkhawale.plugins.sentry.explorer;

import org.gradle.api.Project;

public class DependenciesExplorer implements InfoExplorer {
    @Override
    public Info explore(Project project) {
        return new DependencyInfo("someDependency");
    }
}
