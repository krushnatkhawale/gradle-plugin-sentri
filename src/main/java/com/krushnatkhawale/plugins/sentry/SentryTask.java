package com.krushnatkhawale.plugins.sentry;

import com.krushnatkhawale.plugins.sentry.explorer.Info;
import com.krushnatkhawale.plugins.sentry.explorer.InfoExplorer;
import com.krushnatkhawale.plugins.sentry.explorer.ProjectExplorer;
import com.krushnatkhawale.plugins.sentry.services.ReportingService;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.util.List;

public class SentryTask extends DefaultTask {

    private final ReportingService reportingService = new ReportingService();

    private final List<InfoExplorer> explorers = List.of(new ProjectExplorer());

    @TaskAction
    public void sentryAction(){

        Info info = null;
        for (InfoExplorer explorer : explorers){
            info = explorer.explorer(getProject(), info);
        }

        SentryReport sentryReport = new SentryReport(info);
        reportingService.printReport(sentryReport);
    }
}