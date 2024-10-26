package com.krushnatkhawale.plugins.sentry.services;

import com.krushnatkhawale.plugins.sentry.SentryReport;

public class ReportingService {
    public void printReport(SentryReport sentryReport) {
        System.out.println("  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!  S E N T R I  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("  Application name: " + sentryReport.applicationName());
        System.out.println("  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}