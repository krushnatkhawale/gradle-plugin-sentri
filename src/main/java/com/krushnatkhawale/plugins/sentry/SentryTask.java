package com.krushnatkhawale.plugins.sentry;

import com.krushnatkhawale.plugins.sentry.explorer.InfoExplorer;
import com.krushnatkhawale.plugins.sentry.services.ReportingService;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class SentryTask extends DefaultTask {

    private final ReportingService reportingService = new ReportingService();
    private final InfoExplorer infoExplorer = new InfoExplorer();

    @TaskAction
    public void sentryAction(){

        SentryReport report = infoExplorer.generateReport( getProject() );
        reportingService.printReport(report);
    }
}