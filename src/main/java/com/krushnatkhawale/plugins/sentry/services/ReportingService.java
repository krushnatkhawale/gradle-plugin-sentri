package com.krushnatkhawale.plugins.sentry.services;

import com.krushnatkhawale.plugins.sentry.SentryReport;
import com.krushnatkhawale.plugins.sentry.explorer.ProjectInfo;

public class ReportingService {
    public void printReport(SentryReport sentryReport) {
        System.out.println("  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  S E N T R Y  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("    Application name              : " + ((ProjectInfo)sentryReport.info()).getName());
        System.out.println("    Version                       : " + ((ProjectInfo)sentryReport.info()).getVersion());
        System.out.println("  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}