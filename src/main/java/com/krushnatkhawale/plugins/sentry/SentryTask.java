package com.krushnatkhawale.plugins.sentry;

import com.krushnatkhawale.plugins.sentry.explorer.DependenciesExplorer;
import com.krushnatkhawale.plugins.sentry.explorer.Info;
import com.krushnatkhawale.plugins.sentry.explorer.InfoExplorer;
import com.krushnatkhawale.plugins.sentry.explorer.ProjectExplorer;
import com.krushnatkhawale.plugins.sentry.report.SentryReport;
import com.krushnatkhawale.plugins.sentry.services.ReportingService;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.util.List;

public class SentryTask extends DefaultTask {

    private final ReportingService reportingService = new ReportingService();

    private final List<InfoExplorer> explorers = List.of(new ProjectExplorer(), new DependenciesExplorer());

    @TaskAction
    public void sentryAction(){

        SentryReport sentryReport = new SentryReport();
        for (InfoExplorer explorer : explorers){
            Info exploredInfo = explorer.explore(getProject());
            sentryReport.addInfo(exploredInfo);
        }

        reportingService.printReport(sentryReport);
        reportingService.logReport(sentryReport);
    }
}