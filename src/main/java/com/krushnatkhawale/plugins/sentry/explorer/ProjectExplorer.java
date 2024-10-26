package com.krushnatkhawale.plugins.sentry.explorer;

import org.gradle.api.Project;

public class ProjectExplorer implements InfoExplorer {

    @Override
    public Info explorer(Project project, Info info) {

        return new ProjectInfo(project.getName(), project.getGroup().toString(), project.getVersion().toString());
    }
}