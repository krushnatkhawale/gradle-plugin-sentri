package com.krushnatkhawale.plugins.sentry.explorer;

import org.gradle.api.Project;

public class ProjectExplorer implements InfoExplorer {

    @Override
    public void explore(Project project, Info info) {

        info.addInfo("projectInfo", new ProjectInfo(project.getName(), project.getGroup().toString(), project.getVersion().toString()) );
    }
}