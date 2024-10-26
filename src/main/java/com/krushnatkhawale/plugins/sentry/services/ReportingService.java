package com.krushnatkhawale.plugins.sentry.services;

import com.krushnatkhawale.plugins.sentry.report.SentryReport;
import com.krushnatkhawale.plugins.sentry.explorer.ProjectInfo;

public class ReportingService {
    public void printReport(SentryReport sentryReport) {
        System.out.println("  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!>   S E N T R Y    P L U G I N   <!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("    Application name                : " + ((ProjectInfo)sentryReport.info()).getName());
        System.out.println("    Group                           : " + ((ProjectInfo)sentryReport.info()).getGroup());
        System.out.println("    Artifact name                   : " + ((ProjectInfo)sentryReport.info()).getName());
        System.out.println("    Version                         : " + ((ProjectInfo)sentryReport.info()).getVersion());
        System.out.println("  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}