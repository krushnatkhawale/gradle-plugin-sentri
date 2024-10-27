package com.krushnatkhawale.plugins.sentry.explorer;

import org.gradle.api.Project;

public interface InfoExplorer {

    void explore(Project project, Info info);
}