package com.krushnatkhawale.plugins.sentry.explorer;

import org.gradle.api.Project;

public class ProjectExplorer implements InfoExplorer {

    @Override
    public Info explore(Project project) {

        return new ProjectInfo(project.getName(), project.getGroup().toString(), project.getVersion().toString());
    }
}