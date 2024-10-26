package com.krushnatkhawale.plugins.sentry.explorer;

import org.gradle.api.Project;

public interface InfoExplorer {

    Info explorer(Project project, Info info);
}