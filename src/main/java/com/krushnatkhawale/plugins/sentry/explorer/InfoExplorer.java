package com.krushnatkhawale.plugins.sentry.explorer;

import com.krushnatkhawale.plugins.sentry.SentryReport;
import org.gradle.api.Project;

public class InfoExplorer {
    public SentryReport generateReport(Project project) {
        SentryReport sentryReport = new SentryReport(project.getName());
        return sentryReport;
    }
}
